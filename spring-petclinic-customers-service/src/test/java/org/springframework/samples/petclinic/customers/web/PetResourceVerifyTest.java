package org.springframework.samples.petclinic.customers.web;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.model.Pet;
import org.springframework.samples.petclinic.customers.model.PetRepository;
import org.springframework.samples.petclinic.customers.model.PetType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author msoh
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PetResource.class)
@ActiveProfiles("test")
public class PetResourceVerifyTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    PetRepository petRepository;

    @MockBean
    OwnerRepository ownerRepository;

    @Test // (expected = NullPointerException.class)
    public void shouldSaveProperDateFormat() {
    	
        // Create Null Date 
        Date bDate = null;
        
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        
        Pet pet = new Pet();
        pet.setBirthDate(bDate);
        pet.setName("testDog");
        pet.setId(8);
        
        PetType petType = new PetType();
        petType.setId(6);
        pet.setType(petType);
        
        owner.addPet(pet);
    }
    
//    @Test
//    public void shouldSaveProperFormat() {
//    	
//        Date bDate = new Date();
//       
//        Owner owner = new Owner();
//        owner.setFirstName("George");
//        owner.setLastName("Bush");
//        owner.setAddress("IFC IBM");
//        owner.setTelephone("123456789");
//        owner.setCity("Seoul");
//        
//        Pet pet = new Pet();
//        pet.setBirthDate(bDate);
//        pet.setName("testDog");
//        pet.setId(8);
//        
//        PetType petType = new PetType();
//        petType.setId(6);
//        pet.setType(petType);
//        
//        owner.addPet(pet);
//        
//        assertThat(petRepository.findAll()).contains(pet);
//    }
        
    
//    @Test
//    public void shouldGetAPet() throws Exception {
//      Pet pet = petRepository.findOne(2);
//      assertEquals("Basil", pet.getName());
//    }
    
    @Test
    public void shouldGetAPetInJSonFormat() throws Exception {

        Pet pet = setupPet();

        given(petRepository.findOne(2)).willReturn(pet);


        mvc.perform(get("/owners/2/pets/2.json").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.name").value("Basil"))
            .andExpect(jsonPath("$.type.id").value(6));
    }

    private Pet setupPet() {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");

        Pet pet = new Pet();

        pet.setName("Basil");
        pet.setId(2);

        PetType petType = new PetType();
        petType.setId(6);
        pet.setType(petType);

        owner.addPet(pet);
        return pet;
    }
    

}
