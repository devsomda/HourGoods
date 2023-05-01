package org.a204.hourgoods.domain.concert.repository;

import java.util.List;

import org.a204.hourgoods.domain.concert.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
	List<Concert> findAllByTitleContaining(String keyword);
}
