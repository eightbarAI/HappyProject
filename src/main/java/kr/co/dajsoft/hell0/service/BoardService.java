package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;

public interface BoardService {

    //게시물 등록을 위한 메서드
    public Long register(BoardDTO dto);

    default BoardDTO entityToDTO(Board board){
        BoardDTO dto = BoardDTO .builder()
                .BOARD_NUMBER(board.getBOARD_NUMBER())
                .BOARD_TITLE(board.getBOARD_TITLE())
                .BOARD_CONTENT(board.getBOARD_CONTENT())
                .MEMBER_JOINDATE(board.getMEMBER_JOINDATE())
                .MEMBER_LOGINDATE(board.getMEMBER_LOGINDATE())
                .BOARD_NICKNAME(board.getBOARD_NICKNAME())
                .BOARD_READCNT(board.getBOARD_READCNT())
                .build();
        return dto;
    }

    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder()
                .MEMBER_EMAIL(dto.getMEMBER_EMAIL())
                .build();

        Board board = Board.builder()
                .BOARD_NUMBER(dto.getBOARD_NUMBER())
                .BOARD_TITLE(dto.getBOARD_TITLE())
                .BOARD_CONTENT(dto.getBOARD_CONTENT())
                .writer(member)
                .build();

        return board;

    }



    //목록 보기 요청을 처리할 메서드
    //public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO dto);

}
