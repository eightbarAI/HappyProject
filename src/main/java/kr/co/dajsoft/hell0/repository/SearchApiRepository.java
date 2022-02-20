package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchApiRepository {
    public Api search();

    Page<Object[]> searchPage(
            String type, String keyword, Pageable pageable
    );
}
