package kr.co.dajsoft.hell0.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long REPLY_ID;
    private  String MEMBER_NICKNAME;
    private  String REPLY_CONTENT;
    private  String REPLY_IP;
    private  String REPLY_SERCERET;
    private  Long REPLY_PASSWORD;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
