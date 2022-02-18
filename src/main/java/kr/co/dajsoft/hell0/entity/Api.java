package kr.co.dajsoft.hell0.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@ToString
public class Api {
    @Id
    private Long apino;
    @Column
    private String gubun;
    @Column
    private String maxclassnm;
    @Column
    private String minclassnm;
    @Column
    private String svcstatnm;
    @Column
    private String svcnm;
    @Column
    private String payatnm;
    @Column
    private String placenm;
    @Column
    private String usetgtinfo;
    @Column
    private String svcurl;
    @Column
    private String areanm;
    @Column
    private String telno;

}
