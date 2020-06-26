package com.tsoft.bot.services.clases;

import com.tsoft.bot.frontend.utility.ExcelReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Clase_Servicio {

    private static final String EXCEL_WEB = "excel/services/MotorOferta/Servicios_MotorOferta.xlsx";
    private static final String Servicio = "Input";
    private static final String CELDA_ENDPOINT_TOKEN = "Endpoint";

    private static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, Servicio);
    }

    public static void getNumero() throws Throwable {

        String endPoint = getData().get(0).get(CELDA_ENDPOINT_TOKEN);
        System.out.println("Endpoint: " + endPoint);
        HttpClient cliente = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(endPoint);

        //Cabeceras
        get.setHeader("X-IBM-Client-Id","e70e694e-46e7-4de2-82ce-e98fd25c4ff0");
        get.setHeader("X-IBM-Client-Secret","J6hQ2tM0cW2xB6nW6bB7jJ3dU1eT4lQ0aV6rJ4nH7tX3rF8sU2");
        get.setHeader("UNICA-User","DNI-40736542");

        HttpResponse response = cliente.execute(get);
        System.out.println("Resultado: " + response.getStatusLine().getStatusCode());
        System.out.println("Endpoint: " + endPoint);

        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null)
        {
            sb.append(line);
        }
        PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/src/main/java/com/tsoft/bot/services/response/ResponseServicio1.JSON");
        pw.write(sb.toString());

        String resultado = sb.toString();
        String numeroTelefonico = resultado.substring(426, 435);
        ExcelReader.writeCellValue(EXCEL_WEB, Servicio, 1, 2, resultado);
        ExcelReader.writeCellValue(EXCEL_WEB, Servicio, 1, 3, numeroTelefonico);

        pw.close();
        pw.flush();
    }

}
