package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.ApiDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.repository.BoardRepository;

public class ApiServiceImpl implements ApiService{

    private final BoardRepository boardRepository;


    @Override
    public PageResultDTO<ApiDTO, Object[]> getList(PageRequestDTO dto) {
        return null;
    }

    @Override
    public ApiDTO get(Long apino) {
        return null;
    }
}
