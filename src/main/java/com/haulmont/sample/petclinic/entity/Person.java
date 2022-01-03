package com.haulmont.sample.petclinic.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@JmixEntity
@MappedSuperclass
public class Person extends StandardEntity {
    private static final long serialVersionUID = -2777766826323269523L;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        String name = firstName;

        if (lastName != null) {
            name += " " + lastName;
        }

        return name;
    }

    @DependsOnProperties({"firstName", "lastName"})
    @InstanceName
    public String getInstanceName() {
        return String.format("%s %s", firstName, lastName);
    }
}