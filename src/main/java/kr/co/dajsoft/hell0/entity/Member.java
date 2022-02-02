package kr.co.dajsoft.hell0.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "board_member")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
    @Id
    private  String MEMBER_NICKNAME;//여기
    private  String MEMBER_PW;
    private  String MEMBER_NAME;
    private  String MEMBER_EMAIL;
    private  String MEMBER_PHONE;
    private  String MEMBER_GENDER;
    private  String MEMBER_ADDRESS;
}
