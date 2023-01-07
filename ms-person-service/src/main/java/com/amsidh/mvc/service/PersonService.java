package com.amsidh.mvc.service;

import com.amsidh.mvc.model.PersonModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface PersonService {
    @Cacheable(cacheNames = "personCache", key = "#result.personId")
    PersonModel savePerson(PersonModel personModel);
    @Cacheable(cacheNames = "personCache", key = "#personId")
    PersonModel getPersonByPersonId(Long personId);

    @CachePut(cacheNames = "personCache", key = "#result.personId")
    PersonModel updatePerson(Long personId, PersonModel person);

    @CacheEvict(cacheNames = "personCache", key = "#personId")
    void deletePersonByPersonId(Long personId);

    List<PersonModel> getPersons();
}
