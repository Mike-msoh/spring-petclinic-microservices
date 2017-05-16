package org.springframework.samples.petclinic.customers.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.model.Pet;
import org.springframework.samples.petclinic.customers.model.PetRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")


public class OwerResourceVerifyTest {
    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;
    

    
    
    @Test
    public void shouldGetAPet() throws Exception {
        Pet pet = petRepository.findOne(2);
        assertThat(petRepository.findAll()).contains(pet);
    }
    
    /*
     * OwerData Format Test
     */
    
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void testEmptyList() {
//        new ArrayList<>().get(0);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void shouldOwerNeed10DigitTelephonFormat() throws Exception {
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setLastName("Bush");
//        owner.setCity("Seoul");
//        owner.setAddress("IFC IBM");
//        owner.setTelephone("12345678999999");
//        ownerResource.createOwner(owner);
//    }
    
//    @Test(expected = IllegalArgumentException.class)
//    public void owerNeedTelephonNumberFormat() throws Exception {
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setLastName("Bush");
//        owner.setCity("Seoul");
//        owner.setAddress("IFC IBM");
//        owner.setTelephone("02-3781-1234");
//        ownerResource.createOwner(owner);
//    }
//    
//    
//    /*
//     * Ower Data Mandatory Resource Test
//     */
//
//    @Test(expected = IllegalArgumentException.class)
//    public void owerNeedFirstname() throws Exception {
//        Owner owner = new Owner();
//        owner.setLastName("Bush");
//        owner.setCity("Seoul");
//        owner.setAddress("IFC IBM");
//        owner.setTelephone("123456789");
//        ownerResource.createOwner(owner);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void owerNeedLastname() throws Exception {
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setCity("Seoul");
//        owner.setAddress("IFC IBM");
//        owner.setTelephone("123456789");
//        ownerResource.createOwner(owner);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void owerNeedAddress() throws Exception {
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setLastName("Bush");
//        owner.setCity("Seoul");
//        owner.setTelephone("123456789");
//        ownerResource.createOwner(owner);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void owerNeedCityName() throws Exception {
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setLastName("Bush");
//        owner.setAddress("IFC IBM");
//        owner.setTelephone("123456789");
//        ownerResource.createOwner(owner);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void owerNeedTelephonNumber() throws Exception {
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setLastName("Bush");
//        owner.setCity("Seoul");
//        owner.setAddress("IFC IBM");
//        ownerResource.createOwner(owner);
//    }
	
}
