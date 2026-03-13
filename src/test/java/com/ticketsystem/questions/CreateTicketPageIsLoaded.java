package com.ticketsystem.questions;

import com.ticketsystem.ui.CreateTicketPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreateTicketPageIsLoaded implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CreateTicketPageUI.PAGE_TITLE.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> value() {
        return new CreateTicketPageIsLoaded();
    }
}
