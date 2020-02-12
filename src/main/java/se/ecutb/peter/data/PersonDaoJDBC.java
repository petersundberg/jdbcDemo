package se.ecutb.peter.data;

import se.ecutb.peter.entity.Person;

public class PersonDaoJDBC {

    private static final String INSERT =
            "INSERT INTO person (firstname, lastname, email, brthdate) VALUES(?, ?, ?, ?)";

    public Person create(Person person){
        return null;
    }


}
