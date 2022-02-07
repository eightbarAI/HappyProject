package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {

    public Board search();

    Page<Object[]> searchPage(
            String type, String keyword, Pageable pageable
    );

}
