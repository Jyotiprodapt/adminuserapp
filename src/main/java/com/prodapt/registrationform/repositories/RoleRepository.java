package com.prodapt.registrationform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.registrationform.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
