package com.ticketsystem.tasks;

import com.ticketsystem.ui.CreateTicketPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterTicketDescription implements Task {

    private final String description;

    public EnterTicketDescription(String description) {
        this.description = description;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(description).into(CreateTicketPageUI.DESCRIPTION_TEXTAREA)
        );
    }

    public static Performable of(String description) {
        return instrumented(EnterTicketDescription.class, description);
    }
}
