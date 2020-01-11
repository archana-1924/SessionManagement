package com.deloitte.session.repo;

import java.sql.Connection;

import com.deloitte.sessionmanagement.model.Person;

public interface PersonRepo {

	boolean addPerson(Person person) throws Exception;
	Person getPersonById(String userName) throws Exception;
	Connection getDbConnection() throws Exception;
}
