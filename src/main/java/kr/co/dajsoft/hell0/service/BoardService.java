package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.BoardDTO;

public interface BoardService {
    //게시물 등록을 위한 메서드
    public Long register(BoardDTO dto);

    //목록 보기 요청을 처리할 메서드
    //public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO dto);

    //상세 보기 요청을 처리할 메서드
    public BoardDTO get(Long bno);

    //게시글을 삭제하는 메서드
    public void removeWithReplies(Long bno);

    //게시글을 수정하는 메서드
    public void modify(BoardDTO dto);
}
