package org.dongguk.sayoung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.domain.Content;
import org.dongguk.sayoung.dto.LoginDto;
import org.dongguk.sayoung.repository.ContentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {
    private final ContentRepository contentRepository;

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
    public String returnAdminIndex(Model model) {
        // 모든 아티클 가져오기
        List<Content> contentsList = (List<Content>) contentRepository.findAll();

        // 가져온 아티클 묶음을 뷰로 전달
        model.addAttribute("contents", contentsList);

        // 뷰 페이지를 설정
        return "adminIndex";
    }
}
