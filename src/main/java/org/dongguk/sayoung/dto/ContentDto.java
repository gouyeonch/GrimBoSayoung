package org.dongguk.sayoung.dto;

import lombok.*;
import org.dongguk.sayoung.domain.Content;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class ContentDto {
    private String title;
    private String description;
    private String expression;
    private String caption;
    // 년도

    @Override
    public String toString() {
        return "ContentDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", expression='" + expression + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }

    public Content toEntity() {
        return new Content(title, description, expression, caption);
    }
}
