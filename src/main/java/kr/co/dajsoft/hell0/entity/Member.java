package kr.co.dajsoft.hell0.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.Assigned;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member extends BaseEntity {

    @Id
  //  @GeneratedValue(generator = "memberNICKNAME")
   // @GenericGenerator(name = "memberNICKNAME", strategy = "uuid")
    private String memberNICKNAME;

    @Column(length = 200, nullable = false)
    private String memberPW;

    @Column(length = 30, nullable = false)
    private String memberNAME;

    @Column(length = 200, nullable = false)
    private String memberEMAIL;

    @Column(length = 11, nullable = false)
    private String memberPHONE;

    @Column(length = 3, nullable = false)
    private String memberGENDER;

    @Column(length = 600)
    private String memberADDRESS;

    //private String writer;

    //@OneToMany
    //private List<Board> board;

    @Builder
    public Member(String memberADDRESS, String memberEMAIL, String memberGENDER, String memberNAME, String memberNICKNAME, String memberPHONE, String memberPW) {
        this.memberADDRESS = memberADDRESS;
        this.memberEMAIL = memberEMAIL;
        this.memberGENDER = memberGENDER;
        this.memberNAME = memberNAME;
        this.memberNICKNAME = memberNICKNAME;
        this.memberPHONE = memberPHONE;
        this.memberPW = memberPW;
    }
}
