package com.haulmont.sample.petclinic.web.pet.pet;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("petclinic_Pet.edit")
@UiDescriptor("pet-edit.xml")
@EditedEntityContainer("petDc")
@LoadDataBeforeShow
@Route(value = "pets/edit", parentPrefix = "pets")
public class PetEdit extends StandardEditor<Pet> {
}