package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.ApiDTO;
import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.entity.Api;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class ApiServiceImpl implements ApiService{

    private final ApiRepository apiRepository;



    @Override
    public PageResultDTO<ApiDTO, Object[]> getList(PageRequestDTO dto) {
        Page<Object []> result = apiRepository.searchPage(
                dto.getType(), dto.getKeyword(),
                dto.getPageable(Sort.by("apino").descending())
        );

        Function<Object[], ApiDTO> fn = (
                en -> entityToDTO((Api) en[0]));
        return new PageResultDTO<>(result, fn);

    }

    @Override
    public ApiDTO get(Long apino) {
        Object result= apiRepository.getApiByBno(apino);
        Object [] ar = (Object []) result;
        return entityToDTO((Api) ar[0]);
    }
}
