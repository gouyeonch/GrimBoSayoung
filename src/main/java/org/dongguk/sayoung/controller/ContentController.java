package org.dongguk.sayoung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.dto.ContentDto;
import org.dongguk.sayoung.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/content/new")
    public String newContentForm() {
        return "content/newContent";
    }

    @PostMapping("/content/new")
    public String createContent(ContentDto data, MultipartFile pic) {

        log.info(data.toString());

        contentService.createContent(data, pic);

        return "redirect:/admin";
    }
}
