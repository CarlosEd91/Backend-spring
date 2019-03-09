package com.hogam.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hogam.backendninja.model.Person;
import com.hogam.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Carlos", 27));
		people.add(new Person("Maria", 43));
		people.add(new Person("Maribell", 21));
		people.add(new Person("Victoria", 2));

		LOG.info("HELLO FROM SERVICE");

		return people;

	}

}
