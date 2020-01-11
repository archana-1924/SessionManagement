package com.deloitte.session.service;

import java.sql.Connection;

import com.deloitte.session.repo.PersonRepo;
import com.deloitte.session.repo.PersonRepoImpl;
import com.deloitte.sessionmanagement.model.Person;

public class PersonServiceImpl implements PersonService
{

	PersonRepo repo;


public PersonServiceImpl()
 {

    	repo=new PersonRepoImpl();
 }

@Override
public boolean addPerson(Person person) throws Exception 
{
       
	return repo.addPerson(person);
}

@Override
public Person getPersonById(String userName) throws Exception
{
     
		return repo.getPersonById(userName);

}
	
@Override
public Connection getDbConnection() throws Exception 
{

	return null;
     
}

}
