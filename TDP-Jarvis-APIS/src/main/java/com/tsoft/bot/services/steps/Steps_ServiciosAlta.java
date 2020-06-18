package com.tsoft.bot.services.steps;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.services.clases.Clase_Alta_Alta;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class Steps_ServiciosAlta extends BaseClass {
    private WebDriver driver;

    public Steps_ServiciosAlta() {
        this.driver = Hook.getDriver();
    }

    @Given("^Se ejecuta el servicio alta alta$")
    public void seEjecutaElServicioAltaAlta() throws Throwable {
        try {
            Clase_Alta_Alta.showData();
            stepPass(driver, "El servicio fue ejecutado correctamente");

        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo en la ejecución del servicio : " + we.getMessage());
        }
    }
}
