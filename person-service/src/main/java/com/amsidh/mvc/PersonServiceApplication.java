package com.amsidh.mvc;

import com.amsidh.mvc.model.PersonModel;
import com.amsidh.mvc.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class PersonServiceApplication implements CommandLineRunner {

    private final PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Deleting existing person data");
        personService.getPersons().forEach(p -> personService.deletePersonByPersonId(p.getPersonId()));
        log.info("Creating sample data for person");
        List<PersonModel> personModelList = Arrays.asList(
                PersonModel.builder().name("Amsidh1").emailId("amsidhlokhande1@gmail.com").mobileNumber(8108551845L).build(),
                PersonModel.builder().name("Amsidh2").emailId("amsidhlokhande2@gmail.com").mobileNumber(8108551846L).build(),
                PersonModel.builder().name("Amsidh3").emailId("amsidhlokhande3@gmail.com").mobileNumber(8108551847L).build(),
                PersonModel.builder().name("Amsidh4").emailId("amsidhlokhande4@gmail.com").mobileNumber(8108551848L).build(),
                PersonModel.builder().name("Amsidh5").emailId("amsidhlokhande5@gmail.com").mobileNumber(8108551849L).build(),
                PersonModel.builder().name("Amsidh6").emailId("amsidhlokhande6@gmail.com").mobileNumber(8108551810L).build(),
                PersonModel.builder().name("Amsidh7").emailId("amsidhlokhande7@gmail.com").mobileNumber(8108551811L).build(),
                PersonModel.builder().name("Amsidh8").emailId("amsidhlokhande8@gmail.com").mobileNumber(8108551812L).build(),
                PersonModel.builder().name("Amsidh9").emailId("amsidhlokhande9@gmail.com").mobileNumber(8108551813L).build(),
                PersonModel.builder().name("Amsidh10").emailId("amsidhlokhande10@gmail.com").mobileNumber(8108551814L).build()
        );
        log.info("Loading sample data to person-db");
        personModelList.forEach(personService::savePerson);

        log.info("Number of person saved are {}", personService.getPersons().size());
    }
}
