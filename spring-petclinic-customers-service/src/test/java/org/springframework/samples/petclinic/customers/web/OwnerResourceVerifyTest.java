package org.springframework.samples.petclinic.customers.web;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.model.Pet;
import org.springframework.samples.petclinic.customers.model.PetRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")


public class OwnerResourceVerifyTest {
    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;
    
    /*
     * OwerData Format Test
     */
    
    @Test(expected = java.lang.IndexOutOfBoundsException.class)
    public void testEmptyList() {
        Pet pet = petRepository.findOne(3000);
        asList(pet).get(1);
    }
    
    @Test
    public void shouldGetAPet() throws Exception {
      Pet pet = petRepository.findOne(3000);
      assertThat(petRepository.findAll()).doesNotContain(pet);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldOwerNeed10DigitTelephonFormat() {
   
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("12345678999999");
        ownerRepository.save(owner);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void owerNeedTelephonNumberFormat() {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("02-3781-1234");
        ownerRepository.save(owner);
    }
    
    
    /*
     * Ower Data Mandatory Resource Test
     */

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void owerNeedFirstname() {
        Owner owner = new Owner();
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789");
        ownerRepository.save(owner);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void owerNeedLastname() {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789");
        ownerRepository.save(owner);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void owerNeedAddress() {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setTelephone("123456789");
        ownerRepository.save(owner);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void owerNeedCityName() {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789");
        ownerRepository.save(owner);
    }
    
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void owerNeedTelephonNumber() {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        ownerRepository.save(owner);
    }
	
}
