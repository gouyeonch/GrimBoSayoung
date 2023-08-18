package org.dongguk.sayoung.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dongguk.sayoung.dto.ContentDto;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contents")
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class Content extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "expression")
    private String expression;

    @Column(name = "caption")
    private String caption;

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", filepath='" + filepath + '\'' +
                ", expression='" + expression + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }

    @Builder
    public Content(String title, String description, String expression, String caption) {
        this.title = title;
        this.description = description;
        this.expression = expression;
        this.caption = caption;
        this.filepath = "/img";
    }
}
