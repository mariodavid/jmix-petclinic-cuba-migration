package com.haulmont.sample.petclinic.web.screens.veterinarian.veterinarian;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.veterinarian.Veterinarian;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("petclinic_Veterinarian.edit")
@UiDescriptor("veterinarian-edit.xml")
@EditedEntityContainer("veterinarianDc")
@LoadDataBeforeShow
@Route(value = "veterinarians/edit", parentPrefix = "veterinarians")
public class VeterinarianEdit extends StandardEditor<Veterinarian> {

}