package org.dongguk.sayoung.repository;

import org.dongguk.sayoung.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
