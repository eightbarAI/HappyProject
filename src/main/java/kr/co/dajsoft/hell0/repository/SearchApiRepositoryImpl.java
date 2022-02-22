package kr.co.dajsoft.hell0.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import kr.co.dajsoft.hell0.entity.Api;
import kr.co.dajsoft.hell0.entity.QApi;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class SearchApiRepositoryImpl
        extends QuerydslRepositorySupport
        implements SearchApiRepository{

    public SearchApiRepositoryImpl(){
       super(Api.class);
    }

    @Override
    public Api search() {
        log.info("apisearch 메서드 호출");
        //Api 엔티티에 쿼리를 수행하기 위한 객체 생성
        QApi api = QApi.api;


        JPQLQuery<Api> jpqlQuery = from(api);
        jpqlQuery.select(api);
        List<Api> result = jpqlQuery.fetch();
        System.out.println(result);
        return null;
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
        QApi api = QApi.api;
        JPQLQuery<Api> jpqlQuery = from(api);
        jpqlQuery.select(api);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = api.apino.gt(0L);
        booleanBuilder.and(expression);


        //페이지 처리
        jpqlQuery.offset(pageable.getOffset());
        jpqlQuery.limit(pageable.getPageSize());

        //데이터 가져오기
        List<Api> result = jpqlQuery.fetch();

//        //데이터 리턴
//        return new PageImpl<Object []>(
//                result.stream().collec
//                t(Collectors.toList()),
//                pageable,
//                jpqlQuery.fetchCount()
//        );
        return null;

    }
}
