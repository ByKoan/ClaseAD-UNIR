import controller.School;
import database.SchemaDB;
import model.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // UI
        School school = new School();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Indica el nombre");
            String name = scanner.next();
            System.out.println("Indica el apellido");
            String last = scanner.next();
            System.out.println("Indica el mail");
            String mail = scanner.next();
            System.out.println("Indica la edad");
            int age = scanner.nextInt();
            long profile = 1;
            Student student = new Student(name, last, mail, age, profile);
            boolean error = false;
            do {
                try {
                    school.insertStudent(student);
                    error = false;
                } catch (SQLException e) {
                    System.out.println("Error en la query, clave duplicada");
                    System.out.println("Por favor indica un nuevo correo");
                    mail = scanner.next();
                    student.setMail(mail);
                    error = true;
                }
            } while (error);
            System.out.println("Estudiante insertado correctamente");

            // TODO -> insertar dos usuarios  secuencialmente cerrando la conexion (evistando el No operations allowed after connection closed.)
            System.out.println("Indica el nombre");
            name = scanner.next();
            System.out.println("Indica el apellido");
            last = scanner.next();
            System.out.println("Indica el mail");
            mail = scanner.next();
            System.out.println("Indica la edad");
            age = scanner.nextInt();
            student = new Student(name, last, mail, age, profile);
            error = false;
            do {
                try {
                    school.insertStudent(student);
                    error = false;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Error en la query, clave duplicada");
                    System.out.println("Por favor indica un nuevo correo");
                    mail = scanner.next();
                    student.setMail(mail);
                    error = true;
                }
            } while (error);
            System.out.println("Estudiante insertado correctamente");

        } catch (InputMismatchException e) {
            System.out.println("Error de IO");
        }

    }
}
