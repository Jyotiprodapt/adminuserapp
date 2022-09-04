package com.prodapt.registrationform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.registrationform.entities.User;
import com.prodapt.registrationform.entities.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>{

	User findByEmail(String email);
}
