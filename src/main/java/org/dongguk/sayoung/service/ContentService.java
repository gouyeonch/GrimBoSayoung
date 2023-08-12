package org.dongguk.sayoung.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguk.sayoung.domain.Content;
import org.dongguk.sayoung.dto.ContentDto;
import org.dongguk.sayoung.repository.ContentRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public String createContent(ContentDto data) {
        Content content = data.toEntity();
        log.info("create service");

        Content saved = contentRepository.save(content);

        log.info(saved.toString());

        return "";
    }
}
