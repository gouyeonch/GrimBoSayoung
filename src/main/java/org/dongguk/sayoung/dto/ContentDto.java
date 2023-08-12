package org.dongguk.sayoung.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dongguk.sayoung.domain.Content;

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
