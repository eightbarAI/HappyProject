package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto) {
        //등록을 위해서 Entity 객체로 변환
        Board board = dtoToEntity(dto);
        boardRepository.save(board);
        return board.getBoardNUMBER();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO dto) {
        return null;
    }

    @Override
    public BoardDTO get(Long board_number) {
        return null;
    }

    @Override
    public void removeWithReplies(Long board_number) {

    }

    @Override
    public void modify(BoardDTO dto) {

    }


}
