package com.amsidh.mvc.service;

import com.amsidh.mvc.model.PersonModel;

import java.util.List;

public interface PersonService {
    PersonModel savePerson(PersonModel personModel);

    PersonModel getPersonByPersonId(Long personId);

    PersonModel updatePerson(Long personId, PersonModel person);

    void deletePersonByPersonId(Long personId);

    List<PersonModel> getPersons();
}
