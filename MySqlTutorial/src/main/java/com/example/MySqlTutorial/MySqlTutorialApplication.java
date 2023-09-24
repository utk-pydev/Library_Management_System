package com.example.MySqlTutorial;
import com.example.MySqlTutorial.Model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySqlTutorialApplication {

	public static void main(String[] args) {

		SpringApplication.run(MySqlTutorialApplication.class, args);
		Person obj = new Person();
		Person newPerson = Person.builder()
		.age(10)
				.firstName("Shantanu")
		.build();
		obj.setAge(10);
		Person.PersonBuilder personBuilder = Person.builder();
		personBuilder.firstName("ABC").lastName("XYZ");
		Person currentPerson = setFn(personBuilder).build();

	}
	public static Person.PersonBuilder setFn(Person.PersonBuilder newPerson){
		return newPerson.lastName("Sharma");
	}
}
