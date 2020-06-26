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

public class Clase_ProductOrders {

    private static final String EXCEL_WEB = "excel/services/Movistar.xlsx";
    private static final String MOVISTAR = "Input";
    private static final String CELDA_ENDPOINT_TOKEN = "Endpoint_Token";
    private static final String CELDA_ENDPOINT_2 = "Endpoint_2";
    private static final String CELDA_TOKEN = "Token";

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, MOVISTAR);
    }

    public static void SendEPointNew() throws Throwable {

        String endPoint = getData().get(0).get(CELDA_ENDPOINT_2);
        String token = getData().get(0).get(CELDA_TOKEN);
        File requestFile = new File(System.getProperty("user.dir") + "/src/main/java/com/tsoft/bot/frontend/body/body.JSON");
        HttpClient cliente = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endPoint);
        post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));

        //Cabeceras
        post.setHeader("Content-type","application/JSON");
        post.setHeader("X-IBM-Client-Id", "b520253f-24f8-4f3f-a79b-4059c228ef1f");
        post.setHeader("Authorization", "B" + token + "");

        //Ejecución
        HttpResponse response = cliente.execute(post);
        System.out.println("Resultado: " + response.getStatusLine().getStatusCode());

        //Resultados en Excel
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null)
        {
            sb.append(line);
        }
        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/src/main/java/com/tsoft/bot/services/response/Response2.JSON");

        String resultado = sb.toString();
        ExcelReader.writeCellValue(EXCEL_WEB, MOVISTAR, 1, 6, resultado);

        pw.write(sb.toString());
        pw.close();
        pw.flush();
    }

    public static void getToken() throws Throwable {
        String endPoint = getData().get(0).get(CELDA_ENDPOINT_TOKEN);
        File requestFile = new File(System.getProperty("user.dir") + "/src/main/java/com/tsoft/bot/frontend/body/enter.x-www-form-urlencoded");
        HttpClient cliente = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endPoint);
        post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));

        //Cabeceras
        post.setHeader("Content-type","application/x-www-form-urlencoded");

        //Ejecución
        HttpResponse response = cliente.execute(post);
        System.out.println("Resultado: " + response.getStatusLine().getStatusCode());

        //Resultados en Excel
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null)
        {
            sb.append(line);
        }
        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/src/main/java/com/tsoft/bot/services/response/Response.JSON");

        String resultado = sb.toString();
        String cab = resultado.substring(17, resultado.length() -390);
        String token = resultado.substring(41, resultado.length() -233);
        ExcelReader.writeCellValue(EXCEL_WEB, MOVISTAR, 1, 2, resultado);
        ExcelReader.writeCellValue(EXCEL_WEB, MOVISTAR, 1, 3, cab + " " + token);

        pw.write("Resultado: " + sb.toString());
        pw.close();
        pw.flush();
    }

}
