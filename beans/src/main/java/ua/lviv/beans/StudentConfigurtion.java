package ua.lviv.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfigurtion {

    @Bean
    public StudentDAO getStudentDAO(){
        return new StudentDAO();
    }

}
