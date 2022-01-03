package com.haulmont.sample.petclinic.web.screens.veterinarian.veterinarian;

import com.haulmont.cuba.gui.screen.*;
import com.haulmont.sample.petclinic.entity.veterinarian.Veterinarian;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("petclinic_Veterinarian.browse")
@UiDescriptor("veterinarian-browse.xml")
@LookupComponent("veterinariansTable")
@LoadDataBeforeShow
@Route("veterinarians")
public class VeterinarianBrowse extends StandardLookup<Veterinarian> {

}