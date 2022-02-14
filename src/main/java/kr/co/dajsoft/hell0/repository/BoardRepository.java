package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository {

    //testjoin okay(transactional없어도...)
    @Query("select b, w.memberNICKNAME from Board b left join b.memberNICKNAME w where b.boardNUMBER = :boardNUMBER")
    Object getBoardWithWriter(@Param("boardNUMBER") Long boardNUMBER);

    //bno 에 해당하는 Board 를 가져올 때 reply 대한 정보도 가져오기
    @Query("select b, r.memberNICKNAME from Board b left join Reply r ON r.board = b " +
            "where b.boardNUMBER = :boardNUMBER")
    //하나의 게시글에 댓글이 여러 개 일 수 있어서 리턴 타입은 List
    List<Object []> getBoardWithReply(@Param("boardNUMBER") Long boardNUMBER);

    //목록 보기를 위한 메서드
    //JPQL 에서는 Page 단위로 리턴할 때 countQuery 가 필수
    @Query(value = "select b, w.memberNICKNAME, count(r)" +
            "from Board b LEFT JOIN b.memberNICKNAME w LEFT JOIN Reply r ON r.board = b " +
            "GROUP BY b",
            countQuery = "select count(b) from Board b")
    Page<Object []> getBoardWithReplyCount(Pageable pageable);

    //게시글 상세보기를 위한 메서드
    @Query("select b, w, count(r) from Board b left join b.memberNICKNAME w left outer join Reply r on r.board = b where b.boardNUMBER = :boardNUMBER")
    Object getBoardByBno(@Param("boardNUMBER") Long boardNUMBER);

    //Page<Object[]> searchPage(String type, String keyword, Pageable bno);
}
