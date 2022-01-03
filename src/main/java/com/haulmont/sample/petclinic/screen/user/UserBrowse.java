package com.haulmont.sample.petclinic.screen.user;

import com.haulmont.sample.petclinic.entity.User;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;

@UiController("sec$User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {
}