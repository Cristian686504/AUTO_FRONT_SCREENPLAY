package com.ticketsystem.tasks;

import com.ticketsystem.ui.LoginPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginWithCredentials implements Task {

    private final String email;
    private final String password;

    public LoginWithCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPageUI.EMAIL_INPUT),
                Enter.theValue(password).into(LoginPageUI.PASSWORD_INPUT),
                Click.on(LoginPageUI.LOGIN_BUTTON)
        );
    }

    public static Performable withCredentials(String email, String password) {
        return instrumented(LoginWithCredentials.class, email, password);
    }
}
