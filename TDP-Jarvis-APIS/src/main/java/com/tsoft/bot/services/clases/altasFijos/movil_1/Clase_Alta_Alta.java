package com.tsoft.bot.services.clases.altasFijos.movil_1;

import com.tsoft.bot.frontend.utility.ExcelReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

public class Clase_Alta_Alta {

    private static final String EXCEL_WEB = "services/excel/ServicioJarvis.xlsx";
    private static final String HOJA = "Input";
    private static final String CELDA_ENDPOINT = "Endpoint";

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, HOJA);
    }

    public static void showData() throws Throwable {

        String endPoint = getData().get(0).get(CELDA_ENDPOINT);
        HttpClient cliente = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endPoint);

        //Cabeceras
        post.setHeader("X-IBM-Client-Id","825d5f93-7034-4a86-b602-38361ef0c128");
        post.setHeader("X-IBM-Client-Secret","I0vM0jP5cF1tF5qX2tW3bL1kO4rJ4aN2cS2eG7oT4sN7yN8jX7");

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
        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/src/main/java/com/tsoft/bot/services/response/ResponseAlta.JSON");
        pw.write("Resultado: " + sb.toString());

        String resultado = sb.toString();
        ExcelReader.writeCellValue(EXCEL_WEB, HOJA, 1, 4, resultado);

        pw.close();
        pw.flush();
    }

}
