package com.haulmont.sample.petclinic.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

@JmixEntity
@MappedSuperclass
public class NamedEntity extends StandardEntity {
    private static final long serialVersionUID = -629159912292308518L;

    @InstanceName
    @Column(name = "NAME")
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}