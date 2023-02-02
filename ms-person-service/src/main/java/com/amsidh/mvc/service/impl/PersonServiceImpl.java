package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Person;
import com.amsidh.mvc.exception.PersonNotFoundException;
import com.amsidh.mvc.model.PersonModel;
import com.amsidh.mvc.repository.PersonRepository;
import com.amsidh.mvc.service.PersonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ObjectMapper objectMapper;

    @Override
    public PersonModel savePerson(PersonModel personModel) {
        Person person = objectMapper.convertValue(personModel, Person.class);
        Person savedPerson = personRepository.save(person);
        return objectMapper.convertValue(savedPerson, PersonModel.class);
    }

    @Override
    public PersonModel getPersonByPersonId(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(String.format("Person with personId %d not found", personId)));
        return objectMapper.convertValue(person, PersonModel.class);
    }

    @Override
    public PersonModel updatePerson(Long personId, PersonModel personModel) {
        PersonModel oldPerson = getPersonByPersonId(personId);
        Optional.ofNullable(personModel.getName()).ifPresent(oldPerson::setName);
        Optional.ofNullable(personModel.getMobileNumber()).ifPresent(oldPerson::setMobileNumber);
        Optional.ofNullable(personModel.getEmailId()).ifPresent(oldPerson::setEmailId);
        Person convertValue = objectMapper.convertValue(oldPerson, Person.class);
        Person updatedPerson = personRepository.saveAndFlush(convertValue);
        return objectMapper.convertValue(updatedPerson, PersonModel.class);
    }

    @Override
    public void deletePersonByPersonId(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public List<PersonModel> getPersons() {
        return objectMapper.convertValue(personRepository.findAll(), new TypeReference<List<PersonModel>>() {
        });
    }
}
