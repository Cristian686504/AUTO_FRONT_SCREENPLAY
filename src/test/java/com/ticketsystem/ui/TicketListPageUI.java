package com.ticketsystem.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TicketListPageUI {

    public static final Target PAGE_TITLE = Target.the("título de la lista de tickets")
            .located(By.cssSelector(".list-header h1"));

    public static final Target TICKETS_GRID = Target.the("grilla de tickets")
            .located(By.cssSelector(".tickets-grid"));

    public static final Target CREATE_TICKET_LINK = Target.the("enlace para crear ticket")
            .located(By.cssSelector("a[href='/tickets/new']"));

    public static final Target EMPTY_STATE = Target.the("estado vacío")
            .located(By.cssSelector(".empty-state"));

    public static Target ticketWithTitle(String title) {
        return Target.the("ticket con título '" + title + "'")
                .located(By.xpath("//*[contains(@class, 'tickets-grid')]//*[contains(text(), '" + title + "')]"));
    }

    private TicketListPageUI() {
    }
}
