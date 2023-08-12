package org.dongguk.sayoung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/")
    public String indexController() {
        return "index";
    }
}
