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

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public String createContent(ContentDto data, MultipartFile file) {

        try {
            Content content = data.toEntity();
            log.info("create service");

            String uploadDir = "/img/";
            String fileName = data.getTitle();
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            log.info(data.toString());

            Path copyOfLocation = Paths.get("src/main/resources/static/img" + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));

//            Path filePath = Path.of(uploadDir + fileName + "." + extension);

            log.info(copyOfLocation.toString());

            Files.copy(file.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);

            log.info(copyOfLocation.toString());

            //저장되는것 까지 완료
            content.setFilepath(copyOfLocation.toString());
            Content saved = contentRepository.save(content);

            log.info(saved.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
