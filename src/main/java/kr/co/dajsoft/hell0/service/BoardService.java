package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;

public interface BoardService {

    //게시물 등록을 위한 메서드
    public Long register(BoardDTO dto);

    default BoardDTO entityToDTO(Board board,
                                 Member member
                                 ){
        BoardDTO dto = BoardDTO .builder()
                .BOARD_NUMBER(board.getBOARD_NUMBER())
                .BOARD_TITLE(board.getBOARD_TITLE())
                .BOARD_CONTENT(board.getBOARD_CONTENT())
                .MEMBER_JOINDATE(member.getMEMBER_JOINDATE())
                .MEMBER_LOGINDATE(member.getMEMBER_LOGINDATE())
                .BOARD_NICKNAME(board.getBOARD_NICKNAME())
                .BOARD_READCNT(board.getBOARD_READCNT())
                .build();
        return dto;
    }



    //목록 보기 요청을 처리할 메서드
    //public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO dto);

}
