package ua.lviv.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.SpringMVC.entities.Participant;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private ParticipantRepository participantRepo;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepo) {
        this.participantRepo = participantRepo;
    }

    public Participant save(Participant participant){
        return participantRepo.save(participant);
    }

    public List<Participant> selectAll(){
        return participantRepo.findAll();
    }

    public boolean existById(int id){
        return participantRepo.existsById(id);
    }

    public Optional<Participant> findById(int id){
        return participantRepo.findById(id);
    }

    public void delete(int id){
        participantRepo.deleteById(id);
    }

    @Transactional
    public byte[] getPhoto(int id){
        return participantRepo.getPhoto(id);
    }

}
