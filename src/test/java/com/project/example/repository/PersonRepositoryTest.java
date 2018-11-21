package com.project.example.repository;

import com.project.example.base.IntegrationBaseTest;
import com.project.example.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonRepositoryTest extends IntegrationBaseTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testLoadDataFind() {
        List<Person> personList = personRepository.findByName("JAMES");

        Assert.assertFalse(personList.isEmpty());
        Person person = personList.get(0);
        Assert.assertEquals(Long.valueOf(1), person.getId());
        Assert.assertEquals("JAMES", person.getName());
    }
}
