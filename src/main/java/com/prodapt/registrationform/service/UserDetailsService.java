package com.prodapt.registrationform.service;

import java.util.List;

import com.prodapt.registrationform.entities.UserDetails;

public interface UserDetailsService {

	public UserDetails addUser(UserDetails userDetails);

	// Retrieve
	public UserDetails getUserById(Long id);

	// Update
	public UserDetails updateUser(UserDetails userDetails);

	// Delete
	public void deleteUserById(Long id);

	// retrieve
	public List<UserDetails> getList();
}
