package com.amsidh.mvc.controller;

import com.amsidh.mvc.client.feign.AccountFeignClient;
import com.amsidh.mvc.client.feign.AddressFeignClient;
import com.amsidh.mvc.model.PersonModel;
import com.amsidh.mvc.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    private final PersonService personService;
    private final AddressFeignClient addressFeignClient;
    private final AccountFeignClient accountFeignClient;

    @PostMapping
    public PersonModel registerPerson(@RequestBody @Validated PersonModel personModel) {
        return personService.savePerson(personModel);
    }

    @GetMapping("{personId}")
    public PersonModel getPerson(@PathVariable("personId") Long personId) {
        PersonModel personModel = personService.getPersonByPersonId(personId);
        personModel.setAddressModel(addressFeignClient.getAddressByAddressId(personId));
        personModel.setAccountModel(accountFeignClient.getAccountByAccountId(personId));
        return personModel;
    }

    @PutMapping("{personId}")
    public PersonModel updatePerson(@PathVariable("personId") Long personId, @RequestBody @Validated PersonModel personModel) {
        return personService.updatePerson(personId, personModel);
    }

    @DeleteMapping("{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePersonByPersonId(personId);
        return ResponseEntity.ok(String.format("Person with personId %d deleted successfully", personId));
    }

    @GetMapping
    public List<PersonModel> persons() {
        return personService.getPersons();
    }

}
