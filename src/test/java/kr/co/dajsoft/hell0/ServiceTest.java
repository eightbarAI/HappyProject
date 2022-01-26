package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
public class ServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void testInsert(){
        BoardDTO dto = BoardDTO.builder()
                .BOARD_TITLE("삽입 테스트")
                .BOARD_CONTENT("삽입을 테스트 합니다.")
                .BOARD_NICKNAME("user1@gmail.com")
                .build();
        Long board = boardService.register(dto);
        System.out.println("삽입한 글 번호:" + bno);
    }




}
