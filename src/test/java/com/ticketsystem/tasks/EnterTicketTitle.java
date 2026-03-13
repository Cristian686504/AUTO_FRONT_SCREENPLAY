package com.ticketsystem.tasks;

import com.ticketsystem.ui.CreateTicketPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterTicketTitle implements Task {

    private final String title;

    public EnterTicketTitle(String title) {
        this.title = title;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(title).into(CreateTicketPageUI.TITLE_INPUT)
        );
    }

    public static Performable of(String title) {
        return instrumented(EnterTicketTitle.class, title);
    }
}
