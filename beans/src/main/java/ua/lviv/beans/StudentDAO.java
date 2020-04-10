package ua.lviv.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

//@Component
public class StudentDAO {

    private List<Student> studentList;

    public StudentDAO(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Autowired
    public StudentDAO() {
        studentList = new ArrayList<>();
    }

    public List<Student> getAll(){
        return studentList;
    }

    public Student getById(int id){
        for (Student s : studentList) {
            if (id == s.getId())
                return s;
        }
        throw new RuntimeException("User is absent");
    }

    public void insert(int id, String name, int age){
        studentList.add(new Student(id, name, age));
        System.out.println("New student added");
    }

    public void delete(int id){
        boolean search = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                search = true;
                studentList.remove(i);
            }
        }
        if(!search)
            System.out.println("Student is not found");
        else
            System.out.println("Student successfully deleted");
    }

    public void update(int id, String name, int age){
        boolean search = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                studentList.get(i).setName(name);
                studentList.get(i).setAge(age);
                search = true;
            }
        }
        if(!search)
            System.out.println("Student is not found");
        else
            System.out.println("Student successfully updated");
    }

    @PostConstruct
    private void hello(){
        System.out.println("Hello");
    }

    @PreDestroy
    private void bye(){
        System.out.println("bye");
    }

}
