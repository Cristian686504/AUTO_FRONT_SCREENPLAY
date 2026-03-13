package com.ticketsystem.questions;

import com.ticketsystem.ui.LoginPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginPageIsLoaded implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LoginPageUI.PAGE_TITLE.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> value() {
        return new LoginPageIsLoaded();
    }
}
