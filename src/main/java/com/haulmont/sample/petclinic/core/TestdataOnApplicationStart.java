package com.haulmont.sample.petclinic.core;

import com.haulmont.cuba.core.sys.events.AppContextStartedEvent;
import io.jmix.core.security.Authenticated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class TestdataOnApplicationStart {

    @Inject
    protected VisitTestDataCreation visitTestDataCreation;

    @Authenticated
    @EventListener
    protected void appStarted(AppContextStartedEvent event) {
        visitTestDataCreation.createData();
    }
}