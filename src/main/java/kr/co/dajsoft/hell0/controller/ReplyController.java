package kr.co.dajsoft.hell0.controller;

import kr.co.dajsoft.hell0.dto.ReplyDTO;
import kr.co.dajsoft.hell0.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/replies/")

public class ReplyController {

    private final ReplyService replyService;
    //
    //댓글 목록 요청을 처리하는 메서드
    @GetMapping(value="/board/{boardNUMBER}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> getListByboardNUMBER(
            @PathVariable("boardNUMBER") Long boardNUMBER){

        return new ResponseEntity<>(
                replyService.getList(boardNUMBER), HttpStatus.OK);
    }

    //댓글 작성 요청을 처리하는 메서드
    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO){
        Long replyID = replyService.register(replyDTO);
        return new ResponseEntity<>(replyID, HttpStatus.OK);
    }

    //댓글 삭제 요청을 처리하는 메서드
    @DeleteMapping("/{replyID}")
    public ResponseEntity<String> remove(@PathVariable("replyID") Long replyID){
        replyService.remove(replyID);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    //댓글 수정 요청을 처리하는 메서드
    @PutMapping("/{replyID}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) {
        replyService.modify(replyDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
