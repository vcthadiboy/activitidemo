package com.copart.g1.services.contracts;

import javax.persistence.Entity;

import lombok.Data;

public class Assignee {


    private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

   
}
