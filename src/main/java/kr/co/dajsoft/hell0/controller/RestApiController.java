package kr.co.dajsoft.hell0.controller;

import kr.co.dajsoft.hell0.dto.ApiDTO;
import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RestApiController {

    @GetMapping("/jsonapi")
    public String callApiWithJson(Model model) throws Exception {
        StringBuilder sb = new StringBuilder();

        // 1. URL을 만들기 위한 StringBuilder.
        StringBuilder urlBuilder = new StringBuilder("http://openAPI.seoul.go.kr:8088/69436867646a686a313031457758656b/json/ListPublicReservationSport/1/30/"); /*URL*/
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
        urlBuilder.append(URLEncoder.encode("농구장", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET.
        conn.setRequestMethod("GET");
        // 6. 통신을 위한 Content-type SET.
        conn.setRequestProperty("Content-type", "application/json");
        // 7. 통신 응답 코드 확인.
        System.out.println("Response code: " + conn.getResponseCode());
        // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.

        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 10. 객체 해제.
        rd.close();
        conn.disconnect();
        List<ApiDTO> list = new ArrayList<>();

        JSONObject jObj;
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj = (JSONObject) jsonParser.parse(sb.toString());
        JSONObject ListPublicReservationSport = (JSONObject) jsonObj.get("ListPublicReservationSport");
        JSONArray row = (JSONArray) ListPublicReservationSport.get("row");

        for (int i = 0; i < row.size(); i++) {
            jObj = (JSONObject) row.get(i);
            ApiDTO apiDTO = new ApiDTO();
            apiDTO.setGubun(jObj.get("GUBUN").toString());
            apiDTO.setMaxclassnm(jObj.get("MAXCLASSNM").toString());
            apiDTO.setMinclassnm(jObj.get("MINCLASSNM").toString());
            apiDTO.setSvcstatnm(jObj.get("SVCSTATNM").toString());
            apiDTO.setSvcnm(jObj.get("SVCNM").toString());
            apiDTO.setPayatnm(jObj.get("PAYATNM").toString());
            apiDTO.setPlacenm(jObj.get("PLACENM").toString());
            apiDTO.setUsetgtinfo(jObj.get("USETGTINFO").toString());
            apiDTO.setSvcurl(jObj.get("SVCURL").toString());
            apiDTO.setAreanm(jObj.get("AREANM").toString());
            apiDTO.setTelno(jObj.get("TELNO").toString());
            list.add(apiDTO);
            model.addAttribute("data",list);
             //4. model에 담아준다.

        }

        return list.toString();
    }
    @GetMapping({"read", "modify"})
    //ModelAttribute를 작성한 파라미터는 아무런 작업을 하지 않아도 뷰로
    //전달 된다.
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long bno, Model model){
        BoardDTO dto = boardService.get(bno);
        model.addAttribute("dto", dto);
    }
}