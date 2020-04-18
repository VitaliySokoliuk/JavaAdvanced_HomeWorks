package ua.lviv.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lviv.SpringMVC.entities.Participant;

import javax.servlet.http.HttpServletRequest;
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
    public String postUpdate(@RequestParam int id, @RequestParam String name, @RequestParam String email, HttpServletRequest req) {
        if(!participantService.existById(id)){
            return "redirect:all";
        }
        Participant participant = participantService.findById(id).get();
        participant.setName(name);
        participant.setEmail(email);
        participantService.save(participant);
        return "redirect:all";
    }

    @GetMapping("/delete")
    public String postDelete(@RequestParam int id, HttpServletRequest req) {
        if(!participantService.existById(id)){
            return "redirect:all";
        }
        participantService.delete(id);
        return "redirect:all";
    }

//    @PostMapping("/save")
//    public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
//        participantService.save(participant);
//        req.setAttribute("participants", participantService.selectAll());
//        req.setAttribute("mode", "PARTICIPANT_VIEW");
//        return "participant";
//    }



//    @GetMapping("/delete")
//    public String deleteBook(@RequestParam(name = "id") int bookId, HttpServletRequest req) {
//        participantService.delete(bookId);
//        req.setAttribute("books", participantService.findAllBooks());
//        req.setAttribute("mode", "BOOK_VIEW");
//        // Todo Fix
//        return "/books/";
//    }

}
