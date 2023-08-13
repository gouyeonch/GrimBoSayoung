package org.dongguk.sayoung.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.domain.Content;
import org.dongguk.sayoung.dto.ContentDto;
import org.dongguk.sayoung.repository.ContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public String createContent(ContentDto data, MultipartFile file) {

        try {
            Content content = data.toEntity();
            log.info("create service");

            String uploadDir = "/static/img/";
            String fileName = data.getTitle();
            log.info(data.toString());
            Path filePath = Path.of(uploadDir + fileName);

            log.info(filePath.toString());

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            content.setFilepath(filePath.toString());
            Content saved = contentRepository.save(content);

            log.info(saved.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
