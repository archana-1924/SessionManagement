package com.deloitte.session.service;

import java.sql.Connection;

import com.deloitte.sessionmanagement.model.Person;

public interface PersonService {

	boolean addPerson(Person person) throws Exception;
    Person getPersonById(String userName) throws Exception;
    Connection getDbConnection() throws Exception;
    
}
