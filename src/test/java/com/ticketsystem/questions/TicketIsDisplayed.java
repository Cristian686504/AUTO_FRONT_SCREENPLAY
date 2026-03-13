package com.ticketsystem.questions;

import com.ticketsystem.ui.TicketListPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TicketIsDisplayed implements Question<Boolean> {

    private final String ticketTitle;

    public TicketIsDisplayed(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return TicketListPageUI.ticketWithTitle(ticketTitle).resolveFor(actor).isVisible();
    }

    public static Question<Boolean> withTitle(String title) {
        return new TicketIsDisplayed(title);
    }
}
