package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b, w from Board b left join b.writer w where b.board_NUMBER = :board_NUMBER")
    Object getBoardWithWriter(@Param("board_NUMBER") Long bno);

    @Query("select b, r from Board b left join Reply r ON r.board = b " +
            "where b.board_NUMBER = :board_NUMBER")
    List<Object[]> getBoardWithReply(@Param("board_NUMBER")Long board_NUMBER);

    @Query(value = "select b, w, count(r)" +
            "from Board b LEFT JOIN b.writer w LEFT JOIN Reply r ON r.board = b " +
            "GROUP BY b",
            countQuery = "select count(b) from Board b")

    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

}
