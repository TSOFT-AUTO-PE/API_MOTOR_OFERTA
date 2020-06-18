package com.tsoft.bot.services.steps;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.services.clases.Clase_Servicio;
import com.tsoft.bot.services.clases.Clase_Servicio2;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Steps_Servicio extends BaseClass {

    private WebDriver driver;

    public Steps_Servicio() {
        this.driver = Hook.getDriver();
    }

    @Given("^Se obtine el numero telefonico que es entrada de servicio$")
    public void seObtineElNumeroTelefonicoQueEsEntradaDeServicio() throws Throwable {
        try {
            Clase_Servicio.getNumero();
            stepPass(driver, "Se ha generado el token correctamente");
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo el servicio : " + we.getMessage());
        }
    }

    @Then("^Se llama el servicio$")
    public void seLlamaElServicio() throws Throwable {
        try {
            Clase_Servicio2.showData();
            stepPass(driver, "El servicio respondió correctamente");
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo el servicio : " + we.getMessage());
        }
    }
}
