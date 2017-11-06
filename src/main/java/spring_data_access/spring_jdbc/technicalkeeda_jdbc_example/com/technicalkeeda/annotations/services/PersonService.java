package spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.services;

import spring_data_access.spring_jdbc.technicalkeeda_jdbc_example.com.technicalkeeda.annotations.bean.Person;

import java.util.List;

public interface PersonService {

    public void addPerson(Person person);

    public void editPerson(Person person, int personId);

    public void deletePerson(int personId);

    public Person find(int personId);

    public List< Person > findAll();
}
