//package kr.co.dajsoft.hell0.service;
//
//import kr.co.dajsoft.hell0.controller.RestApiController;
//import kr.co.dajsoft.hell0.dto.ApiDTO;
//import kr.co.dajsoft.hell0.dto.BookingDTO;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookingService extends RestApiController {
//    public void init(String jsonData){
//        List<ApiDTO> list = new ArrayList<>();
//        try {
//            JSONObject jObj;
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonData);
//            JSONObject ListPublicReservationSport = (JSONObject) jsonObj.get("ListPublicReservationSport");
//            JSONArray row = (JSONArray) ListPublicReservationSport.get("row");
//            for(int i=0;i<row.size();i++) {
//                jObj = (JSONObject) row.get(i);
//                ApiDTO apiDTO = new ApiDTO();
//                apiDTO.setGubun(jObj.get("GUBUN").toString());
//                apiDTO.setMaxclassnm(jObj.get("MAXCLASSNM").toString());
//                apiDTO.setMinclassnm(jObj.get("MINCLASSNM").toString());
//                apiDTO.setSvcstatnm(jObj.get("SVCSTATNM").toString());
//                apiDTO.setSvcnm(jObj.get("SVCNM").toString());
//                apiDTO.setPayatnm(jObj.get("PAYATNM").toString());
//                apiDTO.setPlacenm(jObj.get("PLACENM").toString());
//                apiDTO.setUsetgtinfo(jObj.get("USETGTINFO").toString());
//                apiDTO.setSvcurl(jObj.get("SVCURL").toString());
//                apiDTO.setAreanm(jObj.get("AREANM").toString());
//                apiDTO.setTelno(jObj.get("TELNO").toString());
//                list.add(apiDTO);
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
