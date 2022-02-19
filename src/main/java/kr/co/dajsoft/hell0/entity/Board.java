package kr.co.dajsoft.hell0.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "memberNICKNAME")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNUMBER;

    @Column(length = 100, nullable = false)
    private String boardTITLE;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String boardCONTENT;

    //@Column(length = 10, nullable = false)
    //private String boardNICKNAME;

    @Column
    private Long boardREADCNT;

    private String ip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNICKNAME")
    private Member memberNICKNAME;

    public void changeTitle(String title){
        this.boardTITLE = title;
    }

    //content를 수정하는 메서드
    public void changeContent(String content){
        this.boardCONTENT = content;
    }

}
