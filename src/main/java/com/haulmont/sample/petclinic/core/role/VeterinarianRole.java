package com.haulmont.sample.petclinic.core.role;

import com.haulmont.sample.petclinic.entity.User;
import com.haulmont.sample.petclinic.entity.owner.Owner;
import com.haulmont.sample.petclinic.entity.pet.Pet;
import com.haulmont.sample.petclinic.entity.pet.PetType;
import com.haulmont.sample.petclinic.entity.veterinarian.Specialty;
import com.haulmont.sample.petclinic.entity.veterinarian.Veterinarian;
import com.haulmont.sample.petclinic.entity.visit.Visit;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = VeterinarianRole.NAME, code = VeterinarianRole.NAME)
public interface VeterinarianRole {

    public final static String NAME = "Veterinarian";

    @EntityPolicy(entityClass = Visit.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = Pet.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = Owner.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = PetType.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = Specialty.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = Veterinarian.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.DELETE})
    void entityPermissions();


    @EntityAttributePolicy(entityClass = Owner.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Pet.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Visit.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = PetType.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Specialty.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Veterinarian.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Visit.class, attributes = "pet", action = EntityAttributePolicyAction.MODIFY)
        // TODO: remove when https://github.com/cuba-platform/cuba/issues/2869 is solved
    void entityAttributePermissions();


    @ScreenPolicy(screenIds = {
            "petclinic_myVisits",
            "petclinic_Visit.browse",
            "petclinic_Visit.edit",
            "petclinic_Pet.browse",
            "petclinic_Pet.edit",
            "petclinic_Owner.browse",
            "petclinic_Owner.edit",
            "petclinic_Veterinarian.browse",
            "petclinic_Veterinarian.edit",
            "petclinic_PetType.browse",
            "petclinic_PetType.edit",
            "petclinic_Specialty.browse",
            "petclinic_Specialty.lookup",
            "petclinic_Specialty.edit",
    })
    void screenPermissions();

}
