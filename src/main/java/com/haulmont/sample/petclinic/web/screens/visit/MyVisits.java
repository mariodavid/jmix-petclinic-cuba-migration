package com.haulmont.sample.petclinic.web.screens.visit;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.sample.petclinic.entity.visit.Visit;

import com.haulmont.sample.petclinic.entity.visit.VisitTreatmentStatus;
import io.jmix.ui.Notifications;
import io.jmix.ui.Notifications.NotificationType;
import io.jmix.ui.action.Action.ActionPerformedEvent;
import io.jmix.ui.action.list.EditAction;
import io.jmix.ui.component.Table;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.MasterDetailScreen;
import io.jmix.ui.screen.MessageBundle;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("petclinic_myVisits")
@UiDescriptor("my-visits.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class MyVisits extends MasterDetailScreen<Visit> {

    @Inject
    protected CollectionLoader<Visit> visitsDl;

    @Inject
    protected UserSession userSession;
    @Inject
    protected Table<Visit> table;
    @Inject
    protected Notifications notifications;

    @Named("table.edit")
    protected EditAction<Visit> tableEdit;
    @Inject
    protected UserSessionSource userSessionSource;
    @Inject
    protected DataContext dataContext;
    @Inject
    protected InstanceContainer<Visit> visitDc;
    @Inject
    protected DataManager dataManager;
    @Inject
    protected MessageBundle messageBundle;

    @Subscribe
    protected void onInit(InitEvent event) {
        visitsDl.setParameter("currentUser", userSession.getCurrentOrSubstitutedUser());

        tableEdit.withHandler(actionPerformedEvent -> {
            Visit item = table.getSingleSelected();
            if (item != null) {
                refreshOptionsForLookupFields();
                disableEditControls();
                getActionsPane().setVisible(true);
            }
        });
    }

    @Subscribe("table.start")
    protected void onStart(ActionPerformedEvent event) {
        final Visit visit = table.getSingleSelected();

        if (visit.hasStarted()) {
            petTreatmentWarningMessage("treatmentAlreadyStarted", visit.getPetName());
        } else {
            updateTreatmentTo(visit, VisitTreatmentStatus.IN_PROGRESS);
            petTreatmentSuccessMessage("treatmentStarted", visit.getPetName());
        }
    }

    @Subscribe("table.finish")
    protected void onTableFinish(ActionPerformedEvent event) {
        final Visit visit = table.getSingleSelected();

        if (visit.hasFinished()) {
            petTreatmentWarningMessage("treatmentAlreadyFinished", visit.getPetName());
        } else {
            updateTreatmentTo(visit, VisitTreatmentStatus.DONE);
            petTreatmentSuccessMessage("treatmentFinished", visit.getPetName());
        }
    }

    private void petTreatmentWarningMessage(String messageKey, String petName) {
        message(messageKey, petName, NotificationType.WARNING);
    }

    private void petTreatmentSuccessMessage(String messageKey, String petName) {
        message(messageKey, petName, NotificationType.TRAY);
    }

    private void message(String messageKey, String petName, NotificationType warning) {
        notifications.create(warning)
                .withCaption(messageBundle.formatMessage(messageKey, petName))
                .show();
    }

    private void updateTreatmentTo(Visit visitToStart, VisitTreatmentStatus targetStatus) {
        visitToStart.setTreatmentStatus(targetStatus);
        dataManager.commit(visitToStart);
        visitsDl.load();
    }

}