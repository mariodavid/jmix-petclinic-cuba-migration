package com.haulmont.sample.petclinic.web.pet.pet;

// TODO: [required] [S] replace with "io.jmix.ui.action.Action", but why?
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.owner.Owner;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import com.haulmont.sample.petclinic.entity.pet.PetType;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.Slider;
import io.jmix.ui.component.TextField;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("petclinic_Pet.browse")
@UiDescriptor("pet-browse.xml")
@LookupComponent("petsTable")

// TODO: [optional] [S] replace with dataLoadCoordinator facet
@LoadDataBeforeShow
@Route("pets")
public class PetBrowse extends StandardLookup<Pet> {

    @Inject
    protected Slider birthDateFilterField;

    @Inject
    protected TextField<String> idFilterField;

    @Inject
    protected ComboBox<Owner> ownerFilterField;

    @Inject
    protected ComboBox<PetType> typeFilterField;


    @Subscribe("petsTable.clearFilter")
    protected void onPetsTableClearFilter(Action.ActionPerformedEvent event) {
        typeFilterField.setValue(null);
        ownerFilterField.setValue(null);
        idFilterField.setValue(null);
        birthDateFilterField.setValue(null);
    }

}