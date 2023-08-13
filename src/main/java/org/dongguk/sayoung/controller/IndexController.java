package org.dongguk.sayoung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/")
    public String indexController() {
        return "index";
    }

    @GetMapping("/login")
    public String loginController() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutController() {
        return "index";
    }

    @GetMapping("/about")
    public String aboutController() {
        return "about";
    }

    @PostMapping("/admin")
    public String checkController(LoginDto data) {

        String ps = data.getPassword();

        log.info(ps);

        if (ps.equals("0105"))
            return "adminIndex";
        else
            return "login";
    }

    @GetMapping("/admin")
    public String returnAdminIndex() {
        return "adminIndex";
    }
}
