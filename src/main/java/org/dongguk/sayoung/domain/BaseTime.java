package org.dongguk.sayoung.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass // (1)
@Getter
@Setter
public class BaseTime {
    @Column(updatable = false) // (2)
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @PrePersist // (3)
    public void before() {
        LocalDateTime now = LocalDateTime.now();
        this.createTime = now;
        this.updateTime = now;
    }

    @PreUpdate // (4)
    public void always() {
        this.updateTime = LocalDateTime.now();
    }
}