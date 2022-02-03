package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Object[]> searchPage(String type, String keyword, Pageable bno);
}
