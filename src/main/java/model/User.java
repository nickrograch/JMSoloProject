package model;

import javax.persistence.*;

@Entity
@Table(name = "name")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "fathername")
    private String fatherName;

    public User(String name, String surname, String fatherName){
        this.name = name;
        this.surname = surname;
        this. fatherName = fatherName;
    }

    public User(long id, String name, String surname, String fatherName){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this. fatherName = fatherName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
