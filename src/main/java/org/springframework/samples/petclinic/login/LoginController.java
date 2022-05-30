package org.springframework.samples.petclinic.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.adm.AdmUserRepository;
import org.springframework.samples.petclinic.login.model.AdmUser;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    AdmUserRepository admUserRepository;

    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        model.put("admUser", new AdmUser());
        return "login/login";
    }

    @RequestMapping(value = "/perform_login", method = RequestMethod.GET)
    public String signIn(@Valid AdmUser user, BindingResult result, Map<String, Object> model) {
        try {
            AdmUser admUser = admUserRepository.findByEmail(user.getEmail());

            List<String> validMsg = new ArrayList<>();

            if (result.hasErrors()) {
                List<ObjectError> returnErrors = result.getAllErrors();
                returnErrors.stream().forEach(e -> {
                    validMsg.add(e.getDefaultMessage());
                });
            } else if (admUser == null) {
                validMsg.add("查無此客戶");
            }
            if (!validMsg.isEmpty()) {
                model.put("message", validMsg);
                return "login/login";
            }
            model.put("admUser", admUser);
        } catch (Exception e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }
        return "welcome";
    }
}
