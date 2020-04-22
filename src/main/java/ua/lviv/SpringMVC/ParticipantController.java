package ua.lviv.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.SpringMVC.entities.Participant;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String Home(HttpServletRequest req){
        req.setAttribute("mode", "HOME_VIEW");
        return "participant";
    }

    @GetMapping("/all")
    public String allParticipant(HttpServletRequest req){
        req.setAttribute("participants", participantService.selectAll());
        req.setAttribute("mode", "PARTICIPANT_ALL");
        return "participant";
    }

    @GetMapping("/new")
    public String newParticipant(HttpServletRequest req){
        req.setAttribute("mode", "PARTICIPANT_CREATE");
        return "participant";
    }
    @PostMapping("/new")
    public String postNewParticipant(@RequestParam String name, @RequestParam String email, HttpServletRequest req){
        Participant participant = new Participant(name, email);
        participantService.save(participant);
        return "redirect:all";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        if(!participantService.existById(id)){
            return "redirect:all";
        }
        Optional<Participant> findedById = participantService.findById(id);
        req.setAttribute("particip", findedById.get());
        req.setAttribute("mode", "PARTICIPANT_EDIT");
        return "participant";
    }

    @PostMapping("/update")
    public String postUpdate(@RequestParam MultipartFile file, @RequestParam int id, @RequestParam String name, @RequestParam String email, HttpServletRequest req) {
        if(!participantService.existById(id)){
            return "redirect:all";
        }
        try {
            Participant participant = participantService.findById(id).get();
            String contentType = file.getContentType();
            if(contentType != null && contentType.startsWith("image")){
                participant.setPhoto(file.getBytes());
            }
            participant.setName(name);
            participant.setEmail(email);
            participantService.save(participant);
            req.setAttribute("id", id);
            return "redirect:all";
        } catch (IOException e) {
            throw new RuntimeException("Could not save file" + file.getOriginalFilename());
        }
    }

    @GetMapping("download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int id) {
        byte[] photo = participantService.getPhoto(id);
        return ResponseEntity.ok().body(new ByteArrayResource(photo));
    }


    @GetMapping("/delete")
    public String postDelete(@RequestParam int id, HttpServletRequest req) {
        if(!participantService.existById(id)){
            return "redirect:all";
        }
        participantService.delete(id);
        return "redirect:all";
    }

}
