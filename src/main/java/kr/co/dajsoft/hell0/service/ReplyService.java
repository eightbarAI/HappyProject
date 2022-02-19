package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.ReplyDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Reply;

import java.util.List;

public interface ReplyService {

    //데이터 삽입을 위한 메서드
    public Long register(ReplyDTO replyDTO);
    //데이터 수정을 위한 메서드
    public void modify(ReplyDTO replyDTO);
    //데이터 삭제를 위한 메서드
    public void remove(Long replyID);
    //댓글 목록을 가져오기
    public List<ReplyDTO> getList(Long boardNUMBER);

    //ReplyDTO 를 Reply Entity로 변환해주는 메서드
    default Reply dtoToEntity(ReplyDTO replyDTO){
        Board borad = Board.builder().boardNUMBER(replyDTO.getBoardNUMBER()).build();

        Reply reply = Reply.builder()
                .replyID(replyDTO.getReplyID())
                .replyCONTENT(replyDTO.getReplyCONTENT())

                .board(borad)
                .build();
        return reply;
    }

    //Reply Entity를 ReplyDTO로 변환해주는 메서드
    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .replyID(reply.getReplyID())
                .replyCONTENT(reply.getReplyCONTENT())
                .replySERCERET(reply.getReplySERCERET())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();
        return replyDTO;
    }
}
