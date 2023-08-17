package org.dongguk.sayoung.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.domain.Content;
import org.dongguk.sayoung.dto.ContentDto;
import org.dongguk.sayoung.repository.ContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public String createContent(ContentDto data, MultipartFile file) {
        log.info("create service");
        try {
            Content content = data.toEntity();

            log.info(data.toString());

            String uploadDir = "src/main/resources/static/img";
            String originalFilename = file.getOriginalFilename();

            Path copyOfLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(originalFilename));

            log.info(copyOfLocation.toString());

            Files.copy(file.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);

            log.info("img saved");

            //저장되는것 까지 완료
            String pathString = copyOfLocation.toString().substring(25);
            log.info(pathString);
            content.setFilepath(pathString);

            Content saved = contentRepository.save(content);

            log.info(saved.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public Content getContent(Long id) {
        Content content = contentRepository.findById(id).orElseThrow(
                () -> new NullPointerException()
        );
        return content;
    }

    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }

    public void updateContent(ContentDto data, Long id) {
        Content content = contentRepository.findById(id).orElseThrow(
                () -> new NullPointerException()
        );

        content.setTitle(data.getTitle());
        content.setDescription(data.getDescription());
        content.setExpression(data.getExpression());
        content.setCaption(data.getCaption());

        contentRepository.save(content);
    }
}
