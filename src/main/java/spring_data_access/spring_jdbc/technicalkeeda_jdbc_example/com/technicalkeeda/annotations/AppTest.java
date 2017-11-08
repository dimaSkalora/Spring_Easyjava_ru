package spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.bean.Person;
import spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.configuration.ApplicationConfig;
import spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.services.PersonService;

import java.util.List;

public class AppTest {
    public static void main(String args[]) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PersonService personService = (PersonService) context.getBean("personService");

        Person yashwant = new Person(1, "Yashwant", "Chavan", 32);
        Person mahesh = new Person(2, "Mahesh", "Patil", 25);
        Person vishal = new Person(3, "Vishal", "Naik", 40);

        personService.addPerson(yashwant);
        personService.addPerson(mahesh);
        personService.addPerson(vishal);

        System.out.println("Find All");
        List< Person > persons = personService.findAll();
        for (Person person: persons) {
            System.out.println(person);
        }

        System.out.println("Delete person Id = 3");
        int deleteMe = 3;
        personService.deletePerson(deleteMe);

        yashwant.setFirstName("Yashwant - Updated");
        yashwant.setLastName("Chavan - Updated");
        yashwant.setAge(40);

        System.out.println("Update person Id = 1");
        int updateMe = 1;
        personService.editPerson(yashwant, updateMe);

        System.out.println("Find person Id = 2");
        Person person = personService.find(2);
        System.out.println(person);

        System.out.println("Find All Again");
        persons = personService.findAll();
        for (Person p: persons) {
            System.out.println(p);
        }

        context.close();
    }
}