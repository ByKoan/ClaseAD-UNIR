package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name, last, mail;
    private int age;
    private Long profile;


    public Student(String name, String last, String mail, int age, Long profile) {
        this.name = name;
        this.last = last;
        this.mail = mail;
        this.age = age;
        this.profile = profile;
    }

    public Student(String name, String last, String mail, int age) {
        this.name = name;
        this.last = last;
        this.mail = mail;
        this.age = age;
    }

    public void showData() {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("last = " + last);
        System.out.println("mail = " + mail);
        System.out.println("age = " + age);
        System.out.println("profile = " + profile);
    }
}
