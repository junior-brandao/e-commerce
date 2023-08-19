package com.eblj.sistema._e_commerce.projections;

import java.time.LocalDate;

public interface UserDetailsProjection {

	String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();
	//String getPhone();
	//LocalDate getBirthDate();
}
