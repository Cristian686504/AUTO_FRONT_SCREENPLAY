package com.ticketsystem.stepdefinitions;

import com.ticketsystem.questions.CreateTicketPageIsLoaded;
import com.ticketsystem.questions.IsOnCreateTicketPage;
import com.ticketsystem.questions.IsOnTicketListPage;
import com.ticketsystem.questions.LoginPageIsLoaded;
import com.ticketsystem.questions.TicketIsDisplayed;
import com.ticketsystem.tasks.EnterTicketDescription;
import com.ticketsystem.tasks.EnterTicketTitle;
import com.ticketsystem.tasks.LoginWithCredentials;
import com.ticketsystem.tasks.NavigateToCreateTicketForm;
import com.ticketsystem.tasks.NavigateToLoginPage;
import com.ticketsystem.tasks.SubmitTicketForm;
import com.ticketsystem.ui.TicketListPageUI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearTicketSteps {

    private Actor actor() {
        return OnStage.theActorInTheSpotlight();
    }

    private void verifyOnTicketListPage(String errorMessage) {
        actor().attemptsTo(
                WaitUntil.the(TicketListPageUI.PAGE_TITLE, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(errorMessage, IsOnTicketListPage.value()).isTrue()
        );
    }

    @Given("que el usuario navega a la pagina de login")
    public void queElUsuarioNavegaALaPaginaDeLogin() {
        actor().attemptsTo(
                NavigateToLoginPage.action(),
                Ensure.that("La pagina de login no cargo correctamente", LoginPageIsLoaded.value()).isTrue()
        );
    }

    @When("el usuario inicia sesion con correo {string} y contrasena {string}")
    public void elUsuarioIniciaSesionConCorreoYContrasena(String email, String password) {
        actor().attemptsTo(
                LoginWithCredentials.withCredentials(email, password)
        );
    }

    @Then("el usuario es redirigido a la lista de tickets")
    public void elUsuarioEsRedirigidoALaListaDeTickets() {
        verifyOnTicketListPage("El usuario no fue redirigido a la lista de tickets");
    }

    @When("el usuario navega al formulario de creacion de ticket")
    public void elUsuarioNavegaAlFormularioDeCreacionDeTicket() {
        actor().attemptsTo(
                NavigateToCreateTicketForm.fromTicketList(),
                Ensure.that("La pagina de crear ticket no cargo correctamente", CreateTicketPageIsLoaded.value()).isTrue()
        );
    }

    @And("el usuario completa el titulo con {string}")
    public void elUsuarioCompletaElTituloCon(String titulo) {
        actor().attemptsTo(
                EnterTicketTitle.of(titulo)
        );
    }

    @And("el usuario completa la descripcion con {string}")
    public void elUsuarioCompletaLaDescripcionCon(String descripcion) {
        actor().attemptsTo(
                EnterTicketDescription.of(descripcion)
        );
    }

    @And("el usuario envia el formulario de ticket")
    public void elUsuarioEnviaElFormularioDeTicket() {
        actor().attemptsTo(
                SubmitTicketForm.now()
        );
    }

    @And("el ticket {string} se muestra en la lista de tickets")
    public void elTicketSeMuestraEnLaListaDeTickets(String ticketTitle) {
        actor().attemptsTo(
                Ensure.that("El ticket '" + ticketTitle + "' no se encontro en la lista de tickets",
                        TicketIsDisplayed.withTitle(ticketTitle)).isTrue()
        );
    }
}
