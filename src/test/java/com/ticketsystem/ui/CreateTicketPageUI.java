package com.ticketsystem.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateTicketPageUI {

    public static final Target TITLE_INPUT = Target.the("campo de título del ticket")
            .located(By.id("ticket-title"));

    public static final Target DESCRIPTION_TEXTAREA = Target.the("campo de descripción del ticket")
            .located(By.id("ticket-description"));

    public static final Target SUBMIT_BUTTON = Target.the("botón de enviar ticket")
            .located(By.cssSelector("button[type='submit'].form-button"));

    public static final Target PAGE_TITLE = Target.the("título de la página de crear ticket")
            .located(By.cssSelector(".create-ticket-title"));

    public static final Target ERROR_ALERT = Target.the("alerta de error")
            .located(By.cssSelector(".error-alert"));

    private CreateTicketPageUI() {
    }
}
