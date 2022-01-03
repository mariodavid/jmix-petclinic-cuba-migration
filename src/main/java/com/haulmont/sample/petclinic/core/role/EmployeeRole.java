package com.haulmont.sample.petclinic.core.role;

import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = EmployeeRole.NAME, code = EmployeeRole.NAME)
public interface EmployeeRole {

    public final static String NAME = "Employee";

    @ScreenPolicy(screenIds = {
            "application-petclinic",
            "application-masterdata",
            "help",
            "aboutWindow",
            "settings",
            "date-interval-editor",
            "bulkEditor",
    })
    void screenPermissions();

    @SpecificPolicy(resources = {
            "ui.filter.modifyConfiguration",
            "ui.filter.modifyJpqlCondition",
            "ui.presentations.global",
            "cuba.gui.filter.maxResults",
            "ui.bulkEdit.enabled"
    })
    void specificPermissions();
}
