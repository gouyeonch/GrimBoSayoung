package org.dongguk.sayoung.repository;

import org.dongguk.sayoung.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {
    @Override
    Optional<Content> findById(Long id);
}
