package com.haulmont.sample.petclinic.web.owner.owner;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.owner.Owner;
import io.jmix.ui.component.Label;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.MessageBundle;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("petclinic_Owner.edit")
@UiDescriptor("owner-edit.xml")
@EditedEntityContainer("ownerDc")
@LoadDataBeforeShow
@Route(value = "owners/edit", parentPrefix = "owners")
public class OwnerEdit extends StandardEditor<Owner> {
    @Inject
    protected Label<String> titleLabel;
    @Inject
    protected MessageBundle messageBundle;

    @Subscribe
    protected void onAfterShow(AfterShowEvent event) {
        titleLabel.setValue(messageBundle.formatMessage("ownerTitle", getEditedEntity().getName()));
    }


}