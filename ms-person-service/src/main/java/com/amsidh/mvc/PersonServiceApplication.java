package com.amsidh.mvc;

import com.amsidh.mvc.entity.Person;
import com.amsidh.mvc.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class PersonServiceApplication implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Redis Database password and username are {}:{}", environment.getProperty("spring.data.redis.password"), environment.getProperty("spring.data.redis.username"));
        log.info("Cleaning Person table");
        personRepository.deleteAll();
        log.info("Loading sample data in person table");
        List<Person> persons = Arrays.asList(Person.builder().personId(1l).name("Amsidh1").emailId("amsidhlokhande1@gmail.com").mobileNumber(8108551845L).build(), Person.builder().personId(2l).name("Amsidh2").emailId("amsidhlokhande2@gmail.com").mobileNumber(8108551846L).build(), Person.builder().personId(3l).name("Amsidh3").emailId("amsidhlokhande3@gmail.com").mobileNumber(8108551847L).build(), Person.builder().personId(4l).name("Amsidh4").emailId("amsidhlokhande4@gmail.com").mobileNumber(8108551848L).build(), Person.builder().personId(5l).name("Amsidh5").emailId("amsidhlokhande5@gmail.com").mobileNumber(8108551849L).build(), Person.builder().personId(6l).name("Amsidh6").emailId("amsidhlokhande6@gmail.com").mobileNumber(8108551810L).build(), Person.builder().personId(7l).name("Amsidh7").emailId("amsidhlokhande7@gmail.com").mobileNumber(8108551811L).build(), Person.builder().personId(8l).name("Amsidh8").emailId("amsidhlokhande8@gmail.com").mobileNumber(8108551812L).build(), Person.builder().personId(9l).name("Amsidh9").emailId("amsidhlokhande9@gmail.com").mobileNumber(8108551813L).build(), Person.builder().personId(10l).name("Amsidh10").emailId("amsidhlokhande10@gmail.com").mobileNumber(8108551814L).build());
        log.info("Loading sample data to person-db");
        List<Person> savedPersons = personRepository.saveAll(persons);

        log.info("Number of person saved are {}", savedPersons.size());
    }
}
