package org.springframework.samples.petclinic.customers.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.PetRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@WebMvcTest(PetResource.class)
@ActiveProfiles("test")


public class OwerResourceVerifyTest {
    @MockBean
    PetRepository petRepository;

    @MockBean
    OwnerResource ownerResource;  
    
    
    /*
     * OwerData Format Test
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldOwerNeed10DigitTelephonFormat() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789123456");
        ownerResource.createOwner(owner);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void owerNeedTelephonNumberFormat() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("02-3781-1234");
        ownerResource.createOwner(owner);
    }
    
    
    /*
     * Ower Data Mandatory Resource Test
     */

    @Test(expected = IllegalArgumentException.class)
    public void owerNeedFirstname() throws Exception {
        Owner owner = new Owner();
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789");
        ownerResource.createOwner(owner);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void owerNeedLastname() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789");
        ownerResource.createOwner(owner);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void owerNeedAddress() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setTelephone("123456789");
        ownerResource.createOwner(owner);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void owerNeedCityName() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setAddress("IFC IBM");
        owner.setTelephone("123456789");
        ownerResource.createOwner(owner);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void owerNeedTelephonNumber() throws Exception {
        Owner owner = new Owner();
        owner.setFirstName("George");
        owner.setLastName("Bush");
        owner.setCity("Seoul");
        owner.setAddress("IFC IBM");
        ownerResource.createOwner(owner);
    }
	
}
