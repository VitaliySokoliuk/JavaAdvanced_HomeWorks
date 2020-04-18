package ua.lviv.SpringMVC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringMVC.entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {



}
