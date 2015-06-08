package com.realdolmen;


import junit.framework.Assert;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class JDBCPersonRepositoryTest {

    @Before
    public void initializeDataSets() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        IDatabaseConnection databaseConnection = new DatabaseConnection(connection);

        IDataSet peopleDataSet = new FlatXmlDataSetBuilder().build(new File("people.xml"));

        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, peopleDataSet);
    }

    private PersonRepository repository = new JdbcPersonRepository();

    @Test
    public void testPersonCanBeFoundById() throws Exception {
        PersonRepository repository = new JdbcPersonRepository();
        Person person = repository.find(1);
        Assert.assertEquals("Jimi", person.getFirstName());
        Assert.assertEquals("Hendrix", person.getLastName());
    }

    @Test
    public void testFindPersonWithNonExistentiDDoesNotCrashProgram() throws Exception {
        Assert.assertEquals(null, repository.find(5));

    }

    @Test
    public void testRemovingPersonById() throws Exception {
        PersonRepository repository = new JdbcPersonRepository();
        repository.remove(repository.find(1));
        Assert.assertNull(repository.find(1));
    }

    @Test
    public void testIfSafeMethodAddsPersonToDatabase() throws Exception {
        PersonRepository repository = new JdbcPersonRepository();
        Date larsBirthDay = new Date(1991, 1, 14);
        City larsCity = new City("Vorselaar", "2290");
        Address larsAddress = new Address("Groenstraat", "22", larsCity);
        Person lars = new Person("Lars", "De Pauw", larsBirthDay, larsAddress);

        repository.save(lars);
        Assert.assertEquals("Lars", repository.find(3).getFirstName());
    }
}
