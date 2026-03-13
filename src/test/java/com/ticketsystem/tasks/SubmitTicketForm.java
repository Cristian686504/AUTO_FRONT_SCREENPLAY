package com.ticketsystem.tasks;

import com.ticketsystem.ui.CreateTicketPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SubmitTicketForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CreateTicketPageUI.SUBMIT_BUTTON)
        );
    }

    public static Performable now() {
        return instrumented(SubmitTicketForm.class);
    }
}
