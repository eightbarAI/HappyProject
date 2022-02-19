package kr.co.dajsoft.hell0.controller;


import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
//공통 URL 설정
@RequestMapping(value = "/board/")
public class BoardController {
    private final BoardService boardService;
//
//    @GetMapping("board")
//    public void list(PageRequestDTO pageRequestDTO, Model model){
//        model.addAttribute("result", boardService.getList(pageRequestDTO));
//    }

    @GetMapping ("register")
    public void register(){

    }
    @PostMapping("register")
    public String register(BoardDTO dto, RedirectAttributes rattr){
        Long boardNUMBER = boardService.register(dto);
        rattr.addFlashAttribute("msg", boardNUMBER+" 등록");
        return "redirect:/board/board";
    }

    @GetMapping({"read", "modify"})
    //ModelAttribute를 작성한 파라미터는 아무런 작업을 하지 않아도 뷰로
    //전달 된다.
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long boardNUMBER, Model model){
        BoardDTO dto = boardService.get(boardNUMBER);
        model.addAttribute("dto", dto);
    }

    @PostMapping("remove")
    public String remove(Long boardNUMBER, RedirectAttributes rattr){
        System.out.println(boardNUMBER);
        boardService.removeWithReplies(boardNUMBER);
        //출력할 메시지 저장
        rattr.addFlashAttribute("msg",boardNUMBER + "삭제");
        return "redirect:/board/board";
    }

    @PostMapping("modify")
    public String modify(BoardDTO dto,@ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes rattr){
        boardService.modify(dto);
        rattr.addAttribute("page", requestDTO.getPage());
        rattr.addAttribute("type", requestDTO.getType());
        rattr.addAttribute("keyword", requestDTO.getKeyword());
        rattr.addAttribute("boardNUMBER", dto.getBoardNUMBER());
        return "redirect:/board/board";
    }
}

