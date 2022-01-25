package kr.co.dajsoft.hell0.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;


@NoArgsConstructor

@Data

public class ReplyDTO  {
    private Long REPLY_ID;


    private  String MEMBER_NICKNAME;

    private  String REPLY_CONTENT;

    private  String REPLY_IP;


    private  String REPLY_SERCERET;

    private Long BOARD_NUMBER;
    private  Long REPLY_PASSWORD;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
