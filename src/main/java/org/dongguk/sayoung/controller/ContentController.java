package org.dongguk.sayoung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.domain.Content;
import org.dongguk.sayoung.dto.ContentDto;
import org.dongguk.sayoung.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/admin/content/{id}")
    public String viewContent(@PathVariable Long id, Model model) {
        Content content = contentService.getContent(id);

        model.addAttribute("content", content);

        return "content/view";
    }

    @DeleteMapping("/content/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);

        return "adminIndex";
    }

    @GetMapping("/content/update/{id}")
    public String getUpdateContent(@PathVariable Long id, Model model){
        Content content = contentService.getContent(id);

        model.addAttribute("content", content);

        return "content/updateContent";
    }
}
