package com.haulmont.sample.petclinic.web.screens.main;

import com.haulmont.sample.petclinic.screen.login.LoginScreen;
import com.vaadin.ui.Dependency.Type;
import io.jmix.ui.action.Action.ActionPerformedEvent;
import io.jmix.ui.component.Button.ClickEvent;
import io.jmix.ui.component.Component.Alignment;
import io.jmix.ui.component.HBoxLayout;
import io.jmix.ui.component.Label;
import io.jmix.ui.component.MessageDialogFacet;
import io.jmix.ui.component.RelativePathResource;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.ScreenDependencyUtils;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import javax.inject.Inject;


@Route(path = "login", root = true)
@UiController("login")
@UiDescriptor("petclinic-login-screen.xml")
public class PetclinicLoginScreen extends LoginScreen {

    @Inject
    protected HBoxLayout bottomPanel;

    @Inject
    protected Label<String> poweredByLink;
    @Inject
    protected MessageDialogFacet helpDialog;

    @Subscribe
    public void onAppLoginScreenInit(InitEvent event) {
        loadStyles();

        initBottomPanel();
    }

    @Subscribe("submit")
    public void onSubmit(ActionPerformedEvent event) {
        login();
    }

    protected void loadStyles() {
        ScreenDependencyUtils.addScreenDependency(this,
                "vaadin://brand-login-screen/login.css", Type.STYLESHEET);
    }

    protected void initBottomPanel() {
        if (!globalConfig.getLocaleSelectVisible()) {
            poweredByLink.setAlignment(Alignment.MIDDLE_CENTER);

            if (!webConfig.getLoginDialogPoweredByLinkVisible()) {
                bottomPanel.setVisible(false);
            }
        }
    }

    @Override
    protected void initLogoImage() {
        logoImage.setSource(RelativePathResource.class)
                .setPath("VAADIN/brand-login-screen/petclinic_logo_body.svg");
    }

    @Subscribe("helpBtn")
    protected void onHelpBtnClick(ClickEvent event) {
        helpDialog.show();
    }
}