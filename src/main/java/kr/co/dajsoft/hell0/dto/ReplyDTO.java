package kr.co.dajsoft.hell0.dto;

import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReplyDTO {
    private Long REPLY_ID;
    private  String MEMBER_NICKNAME;
    private  String REPLY_CONTENT;
    private  String REPLY_IP;
    private  String REPLY_SERCERET;
    private  Long REPLY_PASSWORD;

    private Board board;//이게 보드엔티티와 연결을 확인하는 건지 물어보기
    private Member member;//멤버 엔티티와 연결이 되는지 확인하지

}
