package kr.co.dajsoft.hell0.service;

import kr.co.dajsoft.hell0.dto.ApiDTO;
import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.entity.Api;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;

public interface ApiService {

    public PageResultDTO<ApiDTO, Object[]> getList(PageRequestDTO dto);

    public ApiDTO get(Long apino);

    default Api dtoToEntity(ApiDTO dto){
        Api api = Api.builder()
                .apino(dto.getApino())
                .gubun(dto.getGubun())
                .maxclassnm(dto.getMaxclassnm())
                .minclassnm(dto.getMinclassnm())
                .svcstatnm(dto.getSvcstatnm())
                .svcnm(dto.getSvcnm())
                .payatnm(dto.getPayatnm())
                .placenm(dto.getPlacenm())
                .usetgtinfo(dto.getUsetgtinfo())
                .svcurl(dto.getSvcurl())
                .areanm(dto.getAreanm())
                .telno(dto.getTelno())
                .build();

        return api;
    }
    default ApiDTO entityToDTO(Api api){
        ApiDTO dto = ApiDTO .builder()
                .apino(api.getApino())
                .gubun(api.getGubun())
                .maxclassnm(api.getMaxclassnm())
                .minclassnm(api.getMinclassnm())
                .svcstatnm(api.getSvcstatnm())
                .svcnm(api.getSvcnm())
                .payatnm(api.getPayatnm())
                .placenm(api.getPlacenm())
                .usetgtinfo(api.getUsetgtinfo())
                .svcurl(api.getSvcurl())
                .areanm(api.getAreanm())
                .telno(api.getTelno())
                .build();
        return dto;
    }
}