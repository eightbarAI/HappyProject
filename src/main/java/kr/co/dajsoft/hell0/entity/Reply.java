package kr.co.dajsoft.hell0.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = {"boardNUMBER", "memberNICKNAME"})
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyID;

    @Column(length = 300, nullable = false)
    private  String replyCONTENT;

    @Column(length = 3, nullable = false)
    private  String replySERCERET;

    @Column(length = 4, nullable = false)
    private  Long replyPASSWORD;

    private String ip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNICKNAME")
    private Member memberNICKNAME;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardNUMBER")
    private Board board;

}
