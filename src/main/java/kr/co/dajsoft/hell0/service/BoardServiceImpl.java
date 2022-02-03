package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import kr.co.dajsoft.hell0.repository.MemberRepository;
import kr.co.dajsoft.hell0.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j

public class BoardServiceImpl implements BoardService{

   // private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;

    private final ReplyRepository replyRepository;


    @Override
    public Long register(BoardDTO dto) {
        Board board = dtoToEntity(dto);
        boardRepository.save(board);
        return board.getBoard_NUMBER();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO dto) {
        Page<Object []> result = boardRepository.searchPage(
                dto.getType(), dto.getKeyword(),
                dto.getPageable(Sort.by("bno").descending())
        );

        Function<Object[], BoardDTO> fn = (
                en -> entityToDTO((Board)en[0],
                        (Member)en[1],
                        (Long)en[2]));
        return new PageResultDTO<>(result, fn);

    }

    @Override
    public BoardDTO get(Long board_number) {
        Object result= boardRepository.getBoardByboard_number(board_number);
        Object [] ar = (Object []) result;
        return entityToDTO((Board)ar[0], (Member)ar[1], (Long)ar[2]);

    }

    @Override
    public void removeWithReplies(Long board_number) {
        replyRepository.deleteByboard_number(board_number);
        boardRepository.deleteById(board_number);
    }

    @Override
    public void modify(BoardDTO dto) {
        Optional<Board> board =
                boardRepository.findById(dto.getBoard_NUMBER());
        if(board.isPresent()){
            board.get().changeboard_Title(dto.getTitle());
            board.get().changeContent(dto.getContent());

            boardRepository.save(board.get());

        }


}
