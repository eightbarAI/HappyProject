package kr.co.dajsoft.hell0.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "writer")


public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BOARD_NUMBER;
    @Column(length = 100, nullable = false)
    private String BOARD_TITLE;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String BOARD_CONTENT;

    @Column(length = 10, nullable = false)
    private String BOARD_NICKNAME;

    @Column
    private Long BOARD_READCNT;


    //?
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

}
