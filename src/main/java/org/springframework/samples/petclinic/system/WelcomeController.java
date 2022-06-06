package org.springframework.samples.petclinic.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.login.model.AdmUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@Controller
class WelcomeController {

    @GetMapping("/")
    public String welcome(Principal principal, Map<String, Object> model, HttpSession session) {

        AdmUser admUser = new AdmUser();
        admUser.setUserName(principal.getName());
        model.put("admUser", admUser);
        session.setAttribute("admUser", admUser);

        return "welcome";
    }
}
