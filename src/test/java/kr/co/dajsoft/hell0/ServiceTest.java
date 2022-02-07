package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.PageRequestDTO;
import kr.co.dajsoft.hell0.dto.PageResultDTO;
import kr.co.dajsoft.hell0.dto.ReplyDTO;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private BoardService boardService;

   // @Test
    public void testInsert(){
        BoardDTO dto = BoardDTO.builder()
                .boardNUMBER(2)
                .boardTITLE("삽입 테스트")
                .boardCONTENT("삽입을 테스트 합니다.")
                .boardNICKNAME("qwr")
                .memberNICKNAME("dal")
                .build();
        Long bno = boardService.register(dto);
//        System.out.println(dto);


        System.out.println("삽입한 글 번호:" + bno);
        /*System.out.println(BoardDTO.builder().boardNUMBER(101).build());
        System.out.println(BoardDTO.builder().boardTITLE("삽입테스트").build());
        System.out.println(BoardDTO.builder().boardCONTENT("삽입을 테스트").build());
        System.out.println(BoardDTO.builder().boardNICKNAME("qwer").build());
        System.out.println(BoardDTO.builder().memberNICKNAME("user100@gmail.com").build());*/

    }
    //???????nullpointexception
    @Test
    public void testList(){
        PageRequestDTO dto = new PageRequestDTO();
        dto.setSize(20);
        PageResultDTO<BoardDTO, Object[]> result =
                boardService.getList(dto);
        //result.setPageSu(1);
        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
        System.out.println(result.getPageList());
    }
   // @Test
    public void testGet(){
        BoardDTO dto = boardService.get(1L);
        System.out.println(dto);
    }
    //삭제 ㅇㅋ
    //@Test
    public void testDelete(){

        boardService.removeWithReplies(11L);
    }
    //숮정 ㅇㅋ
  //  @Test
    public void testModify(){
        BoardDTO dto = BoardDTO.builder()
                .boardNUMBER(2)
                .boardTITLE("수정한 제목")
                .boardCONTENT("수정한 내용")
                .build();

        boardService.modify(dto);
    }
//    @Autowired
//    private ReplyService replyService;
//
//    @Test
//    public void testGetReplies(){
//        List<ReplyDTO> list =
//                replyService.getList(77L);
//        System.out.println(list);
//    }


}
