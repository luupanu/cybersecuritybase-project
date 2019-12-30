package sec.project.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.database.Database;
import sec.project.database.MessageDao;
import sec.project.database.SignupDao;
import sec.project.domain.Message;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;
import sec.project.repository.MessageRepository;

@Controller
public class Controllers {

    private final Database database;
    private final SignupDao signupDao;
    private final MessageDao messageDao;

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private MessageRepository messageRepository;

    // set up our in-memory DB here
    public Controllers() throws SQLException {
        this.database = new Database("jdbc:h2:mem:db");
        this.signupDao = new SignupDao(database);
        this.messageDao = new MessageDao(database);
    }

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm(Model model) {
        List<Signup> attendees = signupRepository.findAll();
        List<Message> messages = messageRepository.findAll();
        model.addAttribute("count", attendees.size());
        model.addAttribute("messages", messages);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, @RequestParam String creditcard) {
        signupDao.addSignup(name, address, creditcard);
        return "done";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String submitMessage(@RequestParam String message) {
        messageDao.addMessage(message);
        return "redirect:/form";
    }

    @RequestMapping("/admin")
    public String loadAdmin(Model model) {
        List<Signup> attendees = signupRepository.findAll();
        model.addAttribute("attendees", attendees);
        return "admin";
    }
}
