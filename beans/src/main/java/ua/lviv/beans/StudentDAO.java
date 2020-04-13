package ua.lviv.beans;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        Optional<Student> obj = studentList.stream().filter(x -> x.getId() == id).findFirst();
        if(obj.isPresent()) {
            return obj.get();
        }else {
            System.out.println("Student is absent");
            return null;
        }
    }

    public void insert(int id, String name, int age){
        studentList.add(new Student(id, name, age));
        System.out.println("New student added");
    }

    public void delete(int id){
        Optional<Student> obj = studentList.stream().filter(x -> x.getId() == id).findFirst();
        if(obj.isPresent()) {
            Student s = obj.get();
            studentList.remove(s);
            System.out.println("Student successfully deleted");
        }else {
            System.out.println("Student is absent");
        }
    }

    public void update(int id, String name, int age){

        boolean find = studentList.stream().anyMatch(x -> x.getId() == id);
        if(find){
            Student student = studentList.stream().filter(x -> x.getId() == id).findFirst().get();
            student.setAge(age);
            student.setName(name);
            System.out.println("Student successfully updated");
        }else{
            System.out.println("Student is absent");
        }
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
