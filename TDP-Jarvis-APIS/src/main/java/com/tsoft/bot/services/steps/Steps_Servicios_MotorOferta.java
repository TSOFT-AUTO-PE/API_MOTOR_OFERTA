package com.tsoft.bot.services.steps;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Altas_Fijos._1Movil.Clase_Alta_Alta_23321;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Altas_Fijos._1Movil.Clase_Alta_Alta_23322;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Altas_Fijos._1Movil.Clase_Alta_Alta_23323;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Altas_Fijos._1Movil.Clase_Alta_Alta_23329;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Replace_Fijos._1Movil.Clase_Replace_Alta_23321;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Replace_Fijos._1Movil.Clase_Replace_Alta_23322;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Replace_Fijos._1Movil.Clase_Replace_Alta_23323;
import com.tsoft.bot.services.clases.Totalizacion_Regular.Replace_Fijos._1Movil.Clase_Replace_Alta_23329;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class Steps_Servicios_MotorOferta extends BaseClass {
    private WebDriver driver;
    private String statusResult = "";
    private String stado = "";

    public Steps_Servicios_MotorOferta() {
        this.driver = Hook.getDriver();
    }


    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil \\(Paquete_PS (23322)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilPaquete_PS23322(int arg0, int arg1) throws Throwable {
        try {
            Clase_Alta_Alta_23322.showData(stado);
            statusResult = Clase_Alta_Alta_23322.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                    stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                    stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
            }
                catch (Exception we)
                    {
                        stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
                    }
    }


    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil \\(Paquete_PS (23323)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilPaquete_PS23323(int arg0, int arg1) throws Throwable {
        try {
            Clase_Alta_Alta_23323.showData(stado);
            statusResult = Clase_Alta_Alta_23323.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }

    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil \\(Paquete_PS (23321)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilPaquete_PS23321(int arg0, int arg1) throws Throwable {
        try {
            Clase_Alta_Alta_23321.showData(stado);
            statusResult = Clase_Alta_Alta_23321.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }

    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil \\(Paquete_PS (23329)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilPaquete_PS23329(int arg0, int arg1) throws Throwable {
        try {
            Clase_Alta_Alta_23329.showData(stado);
            statusResult = Clase_Alta_Alta_23329.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }

    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil Replace \\(Paquete_PS (23321)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilReplacePaquete_PS23321(int arg0, int arg1) throws Throwable {
        try {
            Clase_Replace_Alta_23321.showData(stado);
            statusResult = Clase_Replace_Alta_23321.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }

    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil Replace \\(Paquete_PS (23322)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilReplacePaquete_PSPS23322(int arg0, int arg1) throws Throwable {
        try {
            Clase_Replace_Alta_23322.showData(stado);
            statusResult = Clase_Replace_Alta_23322.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }

    }


    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil Replace \\(Paquete_PS (23323)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilReplacePaquete_PS23323(int arg0, int arg1) throws Throwable {
        try {
            Clase_Replace_Alta_23323.showData(stado);
            statusResult = Clase_Replace_Alta_23323.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }

    @Given("^Se ejecuta el Servicio de Totalización Regular : Altas Fijos : (\\d+) Movil Replace \\(Paquete_PS (23329)\\)$")
    public void seEjecutaElServicioDeTotalizaciónRegularAltasFijosMovilReplacePaquete_PS23329(int arg0, int arg1) throws Throwable {
        try {
            Clase_Replace_Alta_23329.showData(stado);
            statusResult = Clase_Replace_Alta_23329.showData(stado);
            if(statusResult.contentEquals("200 OK")){
                stepPass(driver, "El resultado de la ejecución es : "+ statusResult);}
            else {
                stepFail(driver, "El resultado de la ejecución es : "+ statusResult);}
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }
}
