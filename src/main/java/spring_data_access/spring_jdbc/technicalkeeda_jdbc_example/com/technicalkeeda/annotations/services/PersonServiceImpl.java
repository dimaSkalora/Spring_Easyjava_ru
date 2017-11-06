package spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.bean.Person;
import spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.dao.PersonDao;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    public void addPerson(Person person) {
        personDao.addPerson(person);

    }

    public void editPerson(Person person, int personId) {
        personDao.editPerson(person, personId);
    }

    public void deletePerson(int personId) {
        personDao.deletePerson(personId);
    }

    public Person find(int personId) {
        return personDao.find(personId);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }
}
