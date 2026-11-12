package controller;

import database.DBConnection;
import database.SchemaDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Student;

import java.sql.*;

@NoArgsConstructor
@Setter
@Getter
public class School {

    // private Connection connection;
    private Statement statement;
    // private PreparedStatement preparedStatement;

    public void insertStudent(Student student) throws SQLException {
        // statement
        // 1-> connection

        // prepareStatement X
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?,?,?,?,?)", SchemaDB.TAB_STUDENTS,
                SchemaDB.COL_NAME, SchemaDB.COL_LAST, SchemaDB.COL_EMAIL, SchemaDB.COL_AGE, SchemaDB.COL_PROFILE);
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            // 2-> query -> string + " " -> String.format
        /*String query = "INSERT INTO students (name,last,mail,age,profile) " +
                "VALUES ('" + student.getName() + "','" + student.getLast() + "','"
                + student.getMail() + "'," + student.getAge() + "," + student.getProfile() + ")";*/
            // mensaje, parametros %s -> string %d -> int %.2f -> double
        /*String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES ('%s','%s','%s',%d,%d)",
                SchemaDB.TAB_STUDENTS,
                SchemaDB.COL_NAME, SchemaDB.COL_LAST, SchemaDB.COL_EMAIL, SchemaDB.COL_AGE, SchemaDB.COL_PROFILE,
                student.getName(), student.getLast(), student.getMail(), student.getAge(), student.getProfile());
        // 3 -> crear statement*/

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getLast());
            preparedStatement.setString(3, student.getMail());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setLong(5, student.getProfile());
            preparedStatement.execute();

        } catch (SQLSyntaxErrorException e) {
            System.out.println("Error en la query, esta mal escrita");
        }
        /*try {
            statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Query ejecutada correctamente");
        } catch (SQLException e) {
            System.out.println("Error en query");
            System.out.println(e.getMessage());
        }*/

    }

}
