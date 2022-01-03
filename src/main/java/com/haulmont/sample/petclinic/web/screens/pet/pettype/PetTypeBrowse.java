package com.haulmont.sample.petclinic.web.screens.pet.pettype;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.pet.PetType;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.ColorPicker;
import io.jmix.ui.component.Component;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.Install;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.MasterDetailScreen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import javax.inject.Inject;

import static com.haulmont.sample.petclinic.web.screens.pet.pettype.ColorGeneration.randomColor;

@UiController("petclinic_PetType.browse")
@UiDescriptor("pet-type-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
@Route("pet-types")
public class PetTypeBrowse extends MasterDetailScreen<PetType> {

    @Inject
    protected UiComponents uiComponents;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<PetType> event) {
        event.getEntity().setColor(randomColor());
    }

    @Install(to = "table.color", subject = "columnGenerator")
    protected Component tableColorColumnGenerator(PetType petType) {
        if (petType.getColor() != null) {
            return colorPicker(petType.getColor());
        }

        return null;
    }


    private Component colorPicker(String color) {
        ColorPicker component = uiComponents.create(ColorPicker.class);
        component.setValue(color);
        component.setEditable(false);
        return component;
    }


}