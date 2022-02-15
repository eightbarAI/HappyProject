package kr.co.dajsoft.hell0.dto;

import kr.co.dajsoft.hell0.entity.Member;
import lombok.Getter;

import java.io.Serializable;
@Getter
public class MemberSessionDTO implements Serializable {

    private String memberNAME;
    private String memberEMAIL;
    private String memberPHONE;
    private String memberNICKNAME;
    private String memberGENDER;
    private String memberADDRESS;

    //entity -> dto
    public MemberSessionDTO(Member member){
        this.memberNAME = member.getMemberNAME();
        this.memberEMAIL = member.getMemberEMAIL();
        this.memberPHONE = member.getMemberPHONE();
        this.memberNICKNAME = member.getMemberNICKNAME();
        this.memberGENDER = member.getMemberGENDER();
        this.memberADDRESS = member.getMemberADDRESS();
    }
}
