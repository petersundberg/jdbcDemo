package se.ecutb.peter.data;

import se.ecutb.peter.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoJDBC {

    private static final String INSERT =
            "INSERT INTO person (firstname, lastname, email, brthdate) VALUES(?, ?, ?, ?)";

    public Person create(Person person) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet keySet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, person.getFirstName());  // (?, ?, ?, ?) = (Nisse, ?, ?, ?)
            statement.setString(2, person.getLastName());   // (?, ?, ?, ?) = (Nisse, Nilsson, ?, ?)
            statement.setString(3, person.getEmail());                       // (?, ?, ?, ?) = (Nisse, Nilsson, nisse@gmail.com, ?)
            statement.setObject(4, person.getBirthDate());                  // (?, ?, ?, ?) = (Nisse, Nilsson, nisse@gmail.com, 1980-01-01)
            statement.execute();
            keySet = statement.getGeneratedKeys();
            while(keySet.next()){
                person = new Person(keySet.getInt("person_id"),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getEmail(),
                        person.getBirthDate()
                );

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(keySet != null){
                keySet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();

            }

        }
    }

    private Connection getConnection() {
    }


}
