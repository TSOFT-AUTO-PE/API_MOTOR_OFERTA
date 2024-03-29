package com.tsoft.bot.services.clases.Totalizacion_Regular.Replace_Fijos._1Movil;

import com.tsoft.bot.frontend.utility.ExcelReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Clase_Replace_Alta_23321 {


    private static final String EXCEL_WEB                       = "excel/services/MotorOferta/Servicios_MotorOferta.xlsx";
    private static final String HOJA                            =           "Input";
    private static final String CELDA_ENDPOINT                  =           "Endpoint";

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, HOJA);
    }

    public static String showData(String status) throws Throwable {

        //Se ingresa el ENDPOINT mediante el excel:
        String endPoint = getData().get(0).get(CELDA_ENDPOINT);

        //Se ingresa el Body JSON mediante archivo en paquete request:
        File requestFile = new File(System.getProperty("user.dir") +
                "/src/main/java/com/tsoft/bot/services/request/Totalizacion_Regular/Replace_Fijos/_1Movil/RequestReplaceAlta.JSON");

        //Se inicia los protocoles POST:
        HttpClient cliente          = HttpClientBuilder.create().build();
        HttpPost post               = new HttpPost(endPoint);
        post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));

        //Cabeceras:
        post.setHeader("Content-Type","application/JSON");
        post.setHeader("X-IBM-Client-Id","825d5f93-7034-4a86-b602-38361ef0c128");
        post.setHeader("X-IBM-Client-Secret","I0vM0jP5cF1tF5qX2tW3bL1kO4rJ4aN2cS2eG7oT4sN7yN8jX7");

        //Ejecución y Resultados:
        HttpResponse response = cliente.execute(post);
        System.out.println("Resultado: " + response.getStatusLine().getStatusCode());
        System.out.println("Endpoint: " + endPoint);
        status = response.getStatusLine().getStatusCode()+" "+response.getStatusLine().getReasonPhrase();



        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuffer sb = new StringBuffer();

        while ((line = br.readLine()) != null)
        {
            sb.append(line);
        }
        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") +
                "/src/main/java/com/tsoft/bot/services/response/Totalizacion_Regular/Altas_Fijos/_1Movil/ResponseClaseAltaAlta.JSON");

        pw.write("Resultado: " + sb.toString());
        String resultado = sb.toString();


        //Código adicional para comparativas y validaciones:
        String []escenario1 = {"23321", "Movistar Total 13GB TV Estándar Digital HD 100Mbps", "235.0", "100000", "43.0",
                                "13000", "192.0", "43.0", "De alta velocidad para compartir PasaGigas y usar en America y Europa."};

        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 5, 2, resultado);
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 5, 3, "10. Replace + (Alta)");
        if ((resultado.contains(escenario1[0]) && resultado.contains(escenario1[1]) && resultado.contains(escenario1[2]) &&
            resultado.contains(escenario1[3]) && resultado.contains(escenario1[4]) && resultado.contains(escenario1[5]) &&
            resultado.contains(escenario1[6]) && resultado.contains(escenario1[7]) && resultado.contains(escenario1[8])))
        {
            ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 5, 13, "PASS");
        }
        else
        {
            ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 5, 13, "FAILED");
        }

        for (int i = 0; i < escenario1.length; i++)
        {
            ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 5, i + 4, "" + escenario1[i] + ": " + resultado.contains(escenario1[i]) + i);
        }

        //Cierre de ejecución:
        pw.close();
        pw.flush();

      return status;
    }
}
