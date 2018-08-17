/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.drachnyen.tuskat;

import com.drachnyen.tuskat.model.Employee;
import com.drachnyen.tuskat.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		Optional<Employee> byId = repository.findById(1L);
		if (!byId.isPresent()) {
			this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
			this.repository.save(new Employee("Bilbo", "Baggins", "burglar"));
			this.repository.save(new Employee("Gandalf", "the Grey", "wizard"));
			this.repository.save(new Employee("Samwise", "Gamgee", "gardener"));
			this.repository.save(new Employee("Meriadoc", "Brandybuck", "pony rider"));
			this.repository.save(new Employee("Peregrin", "Took", "pipe smoker"));
		}
	}
}
// end::code[]