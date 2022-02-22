package kr.co.dajsoft.hell0.controller;

import kr.co.dajsoft.hell0.dto.ApiDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.service.ApiService;
import kr.co.dajsoft.hell0.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class HomeController {
    private final BoardService boardService;
    private final ApiService apiService;
    @GetMapping("/")
    public String index(){
        return "/board/list";
    }
    @GetMapping("board/login")
    public String login(){
        return "/login/index";
    }
    @GetMapping("board/member")
    public String member(){
        return "/board/member";
    }
    @GetMapping("board/board")
    public String board(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("result", boardService.getList(pageRequestDTO));
        return "board/board";
    }
    @GetMapping("board/basketball")
    public String basketball(Model model){

        List<ApiDTO> list = apiService.get();
        model.addAttribute("result", list);
        System.out.println(list);
        return "board/basketball";
    }
    @GetMapping("board/football")
    public String football(){
        return "/board/football";
    }


}
