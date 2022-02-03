package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;

public interface BoardService {

    //게시물 등록을 위한 메서드
    public Long register(BoardDTO dto);

    //목록 보기 요청을 처리할 메서드
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO dto);


    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder()
                .member_EMAIL(dto.getMember_EMAIL())
                .build();

        Board board = Board.builder()
                .board_NUMBER((long) dto.getBoard_NUMBER())
                .board_TITLE(dto.getBoard_TITLE())
                .board_CONTENT(dto.getBoard_CONTENT())
                .writer(member)
                .build();
        return board;

    }
    default BoardDTO entityToDTO(Board board,
                                 Member member,
                                 Long replyCount){
        BoardDTO dto = BoardDTO .builder()
                .board_NUMBER(board.getBoard_NUMBER())
                .board_TITLE(board.getBoard_TITLE())
                .board_CONTENT(board.getBoard_CONTENT())
                .regDate(board.getRegDate())
                .modDate(board.getRegDate())
                .writerEmail(member.getMember_EMAIL())
                .writerName(member.getMember_NAME())
                .replyCount(replyCount.intValue())
                .build();
        return dto;
    }
}
