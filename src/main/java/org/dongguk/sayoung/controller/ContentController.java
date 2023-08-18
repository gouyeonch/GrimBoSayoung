package org.dongguk.sayoung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.domain.Content;
import org.dongguk.sayoung.dto.ContentDto;
import org.dongguk.sayoung.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/content/{id}")
    public String viewContent(@PathVariable Long id, Model model) {
        Content content = contentService.getContent(id);

        model.addAttribute("content", content);

        return "content/view";
    }

    @GetMapping("/admin/content/new")
    public String newContentForm() {
        return "content/newContent";
    }

    @PostMapping("/admin/content/new")
    public String createContent(ContentDto data, MultipartFile pic) {

        log.info(data.toString());

        contentService.createContent(data, pic);

        return "redirect:/admin";
    }

    @GetMapping("/admin/content/{id}")
    public String adminViewContent(@PathVariable Long id, Model model) {
        Content content = contentService.getContent(id);

        model.addAttribute("content", content);

        return "content/adminView";
    }

    @DeleteMapping("/admin/content/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);

        return "redirect:/admin";
    }

    @GetMapping("/admin/content/update/{id}")
    public String getUpdateContent(@PathVariable Long id, Model model) {
        Content content = contentService.getContent(id);

        model.addAttribute("content", content);

        return "content/updateContent";
    }

    @PutMapping("/admin/content/update/{id}")
    public String putUpdateContent(@PathVariable Long id, ContentDto data) {

        contentService.updateContent(data, id);

        return "redirect:/admin";
    }
}
