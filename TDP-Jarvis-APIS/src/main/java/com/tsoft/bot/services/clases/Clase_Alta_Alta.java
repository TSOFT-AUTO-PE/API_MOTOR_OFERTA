package com.tsoft.bot.services.clases;

import com.tsoft.bot.frontend.utility.ExcelReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Clase_Alta_Alta{


    private static final String EXCEL_WEB                       =           "services/excel/ServicioJ.xlsx";
    private static final String HOJA                            =           "Input";
    private static final String CELDA_ENDPOINT                  =           "Endpoint";

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, HOJA);
    }

    public static void showData() throws Throwable {

        //Se ingresa el ENDPOINT mediante el excel:
        String endPoint = getData().get(0).get(CELDA_ENDPOINT);

        //Se ingresa el Body JSON mediante archivo en paquete request:
        File requestFile = new File(System.getProperty("user.dir") +
                "/src/main/java/com/tsoft/bot/services/request/RequestAltaAlta.JSON");

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

        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuffer sb = new StringBuffer();

        while ((line = br.readLine()) != null)
        {
            sb.append(line);
        }
        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") +
                "/src/main/java/com/tsoft/bot/services/response/ResponseAlta.JSON");

        pw.write("Resultado: " + sb.toString());
        String resultado = sb.toString();


        //Código adicional para comparativas y validaciones:
        String valor1 = "23322";
        String valor2 = "Movistar Total 13GB TV Estándar Digital HD 200Mbps";
        String valor3 = "175.0";
        String valor4 = "30000";
        String valor5 = "43.0";
        String valor6 = "13000";
        String valor7 = "132.0";
        String valor8 = "43.0";
        String valor9 = "De alta velocidad para compartir PasaGigas y usar en America y Europa.";



        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 2, resultado);
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 3, "" + valor1 + ": " + resultado.contains(valor1));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 4, "" + valor2 + ": " + resultado.contains(valor2));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 5, "" + valor3 + ": " + resultado.contains(valor3));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 6, "" + valor4 + ": " + resultado.contains(valor4));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 7, "" + valor5 + ": " + resultado.contains(valor5));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 8, "" + valor6 + ": " + resultado.contains(valor6));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 9, "" + valor7 + ": " + resultado.contains(valor7));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 10, "" + valor8 + ": " + resultado.contains(valor8));
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 11, "" + valor9 + ": " + resultado.contains(valor9));

        if ((resultado.contains(valor1) && resultado.contains(valor2) && resultado.contains(valor3) &&
                resultado.contains(valor4) && resultado.contains(valor5) && resultado.contains(valor6) &&
                resultado.contains(valor7) && resultado.contains(valor8) && resultado.contains(valor9))==true)
        {
            ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 12, "OK");
        }
        else
        {
            ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 12, "FALLIDO");
        }

        //Cierre de ejecución:
        pw.close();
        pw.flush();
    }

}
