package org.dongguk.sayoung.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongguk.sayoung.dto.ContentDto;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "contents")
@DynamicUpdate
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", expression='" + expression + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }

    @Column(name = "expression")
    private String expression;

    @Column(name = "caption")
    private String caption;

    //생성년도 추후 추가

    @Builder
    public Content(String title, String description, String expression, String caption) {
        this.title = title;
        this.description = description;
        this.expression = expression;
        this.caption = caption;
    }
}
