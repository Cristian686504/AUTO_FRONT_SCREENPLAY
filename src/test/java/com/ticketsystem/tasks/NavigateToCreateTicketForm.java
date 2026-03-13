package com.ticketsystem.tasks;

import com.ticketsystem.ui.TicketListPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToCreateTicketForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TicketListPageUI.CREATE_TICKET_LINK)
        );
    }

    public static Performable fromTicketList() {
        return instrumented(NavigateToCreateTicketForm.class);
    }
}
