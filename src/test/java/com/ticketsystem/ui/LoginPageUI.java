package com.ticketsystem.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUI {

    public static final Target EMAIL_INPUT = Target.the("campo de email")
            .located(By.id("email"));

    public static final Target PASSWORD_INPUT = Target.the("campo de contraseña")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("botón de login")
            .located(By.cssSelector("button[type='submit']"));

    public static final Target PAGE_TITLE = Target.the("título de la página de login")
            .located(By.cssSelector(".auth-title"));

    public static final Target ERROR_MESSAGE = Target.the("mensaje de error de autenticación")
            .located(By.cssSelector(".auth-error"));

    private LoginPageUI() {
    }
}
