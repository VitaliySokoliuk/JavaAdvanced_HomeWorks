package ua.lviv.dataJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniverDAO extends JpaRepository<Univer, Integer> {

    List<Univer> findByName(String name);

    Univer findById(int id);

    @Modifying
    @Query("update Univer u set u.name = ?1, u.levelOfAccreditation = ?2, u.countOfInstitutes = ?3, u.countOfStudents = ?4, u.address = ?5 where u.id = ?6")
    void update(String name, int levelOfAccreditation, int countOfInstitutes, int countOfStudents, String address, int id);

    @Modifying
    @Query("delete from Univer u where u.id = ?1")
    void delete(int id);

}
