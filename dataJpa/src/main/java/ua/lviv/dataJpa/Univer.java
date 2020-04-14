package ua.lviv.dataJpa;


import javax.persistence.*;

@Entity
@Table(name = "univer")
public class Univer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "level_of_accreditation")
    private int levelOfAccreditation;
    @Column(name = "count_of_institutes")
    private int countOfInstitutes;
    @Column(name = "count_of_students")
    private int countOfStudents;
    private String address;

    public Univer(String name, int levelOfAccreditation, int countOfInstitutes, int countOfStudents, String address) {
        this.name = name;
        this.levelOfAccreditation = levelOfAccreditation;
        this.countOfInstitutes = countOfInstitutes;
        this.countOfStudents = countOfStudents;
        this.address = address;
    }

    public Univer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelOfAccreditation() {
        return levelOfAccreditation;
    }

    public void setLevelOfAccreditation(int levelOfAccreditation) {
        this.levelOfAccreditation = levelOfAccreditation;
    }

    public int getCountOfInstitutes() {
        return countOfInstitutes;
    }

    public void setCountOfInstitutes(int countOfInstitutes) {
        this.countOfInstitutes = countOfInstitutes;
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    public void setCountOfStudents(int countOfStudents) {
        this.countOfStudents = countOfStudents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Univer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", levelOfAccreditation=" + levelOfAccreditation +
                ", countOfInstitutes=" + countOfInstitutes +
                ", countOfStudents=" + countOfStudents +
                ", address='" + address + '\'' +
                '}';
    }
}
