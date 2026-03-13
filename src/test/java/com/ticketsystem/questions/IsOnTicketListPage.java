package com.ticketsystem.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class IsOnTicketListPage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String url = TheWebPage.currentUrl().answeredBy(actor);
        return url.contains("/tickets") && !url.contains("/new");
    }

    public static Question<Boolean> value() {
        return new IsOnTicketListPage();
    }
}
