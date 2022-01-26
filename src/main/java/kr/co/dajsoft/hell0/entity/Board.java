package kr.co.dajsoft.hell0.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "writer")//이건뭐고
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BOARD_NUMBER;
    private String BOARD_TITLE;
    private String BOARD_CONTENT;
    private String BOARD_NICKNAME;
    private Long BOARD_READCNT;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

}
