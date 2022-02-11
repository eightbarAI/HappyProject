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

    public BoardDTO get(Long board_number);

    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder()
                .memberNICKNAME(dto.getMemberNICKNAME())
                .build();

        Board board = Board.builder()
                .boardNUMBER((long) dto.getBoardNUMBER())
                .boardTITLE(dto.getBoardTITLE())
                .boardCONTENT(dto.getBoardCONTENT())
                .boardNICKNAME(dto.getBoardNICKNAME())

                .memberNICKNAME(member)

                .build();
        return board;
    }
    default BoardDTO entityToDTO(Board board,
                                 Member member,
                                 Long replyCount){
        BoardDTO dto = BoardDTO .builder()
                .boardNUMBER(Math.toIntExact(board.getBoardNUMBER()))
                .boardTITLE(board.getBoardTITLE())
                .boardCONTENT(board.getBoardCONTENT())
                .regDATE(board.getRegDate())
                .modDATE(board.getModDate())
                .memberNICKNAME(member.getMemberNICKNAME())
                .replyCount(replyCount.intValue())
                .boardNICKNAME(board.getBoardNICKNAME())
                .build();
        return dto;
    }

    public void removeWithReplies(Long board_number);

    public void modify(BoardDTO dto);

}
