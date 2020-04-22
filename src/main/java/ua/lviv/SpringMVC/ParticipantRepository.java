package ua.lviv.SpringMVC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringMVC.entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    @Query("select p.photo from Participant p where p.id = :id")
    byte[] getPhoto(@Param("id") int id);

}
