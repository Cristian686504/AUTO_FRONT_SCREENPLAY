package com.ticketsystem.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenplayHooks {

    private static final Logger logger = LoggerFactory.getLogger(ScreenplayHooks.class);
    private static final String ACTOR_NAME = "Usuario";
    @Before(order = 0)
    public void setUp(Scenario scenario) {
        logger.info("========================================");
        logger.info("Iniciando escenario: {}", scenario.getName());
        logger.info("Tags: {}", scenario.getSourceTagNames());
        logger.info("========================================");

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_NAME);

        logger.info("Actor '{}' configurado en el escenario", ACTOR_NAME);
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Escenario FALLIDO: {}", scenario.getName());
        } else {
            logger.info("Escenario EXITOSO: {}", scenario.getName());
        }

        OnStage.drawTheCurtain();
    }
}
