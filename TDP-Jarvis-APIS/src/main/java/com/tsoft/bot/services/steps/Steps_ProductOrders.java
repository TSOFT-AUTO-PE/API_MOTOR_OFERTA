package com.tsoft.bot.services.steps;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.services.clases.Clase_ProductOrders;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Steps_ProductOrders extends BaseClass {

    private WebDriver driver;

    public Steps_ProductOrders() {
        this.driver = Hook.getDriver();
    }

    @Given("^Se genera el token que es entrada de product orders$")
    public void seGeneraElTokenQueEsEntradaDeProductOrders() throws Throwable {
        try {
            Clase_ProductOrders.getToken();
            stepPass(driver, "Se ha generado el token correctamente");
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo el servicio : " + we.getMessage());
        }
    }

    @Then("^Se llama el servicio de product orders$")
    public void seLlamaElServicioDeProductOrders() throws Throwable {
        try {
            Clase_ProductOrders.SendEPointNew();
            stepPass(driver, "El servicio respondió correctamente");
        }
        catch (Exception we)
        {
            stepFail(driver, "Fallo el servicio : " + we.getMessage());
        }
    }
}
