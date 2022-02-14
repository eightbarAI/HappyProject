package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.dto.BoardDTO;
import kr.co.dajsoft.hell0.dto.MemberDTO;
import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;

import kr.co.dajsoft.hell0.entity.Reply;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import kr.co.dajsoft.hell0.repository.MemberRepository;
import kr.co.dajsoft.hell0.repository.ReplyRepository;
import kr.co.dajsoft.hell0.service.BoardService;
import kr.co.dajsoft.hell0.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertMembers(){
        for(int i=1; i<=2; i=i+1){
            Member member = Member.builder()
                    .memberEMAIL("user" + i + "@gmail.com")
                    .memberPW("1234")
                    .memberNAME("USER" + i)
                    .memberNICKNAME("dal")
                    .memberADDRESS("seoul")
                    .memberPHONE("01077717524")
                    .memberGENDER("m")
                    .build();
            memberRepository.save(member);
        }
    }
    @Test
    public void insertBoards(){
        for(int i=1; i<=2; i=i+1){
            MemberDTO member = MemberDTO.builder()
                    .memberNICKNAME("dal")
                    .build();

            BoardDTO board = BoardDTO.builder()
                    .boardTITLE("제목..." + i)
                    .boardCONTENT("내용..." + i)
                    .boardNICKNAME("daj"+i)
                    .boardREADCNT(1)
                    .boardNUMBER(i)
                    .memberNICKNAME(member.getMemberNICKNAME())
                    .build();
            Board board1 = boardService.dtoToEntity(board);

            boardRepository.save(board1);
        }

    }
    @Autowired
    private ReplyRepository replyRepository;

    //@Test
    public void insertReplys(){
       Random r = new Random();
       for(long i=1; i<=50; i=i+1){
           Board board = Board.builder()
                   .boardNUMBER((long)(r.nextInt(1) + 1))
                   .build();

           Reply reply = Reply.builder()
                   .replyID(+i)
                   .replyCONTENT("댓글..." + i)
                   .replyPASSWORD(1234L)
                   .replySERCERET("d")
                   //.memberNICKNAME("dal")
                   //.ip("168.180"+i)
                   //.replyID("sfd")
                   .board(board)
                   .build();
           replyRepository.save(reply);
       }
//        Random r = new Random();
//        for(long i=1; i<=50; i=i+1){
//            Board board = Board.builder()
//                    .boardNUMBER((long)(r.nextInt(100) + 1))
//                    .build();
//
//            Reply reply = Reply.builder()
//                   // .replyID((("198.168"+i)))
//                    .replyCONTENT("댓글..." + i)
//                    .replyPASSWORD(1234L)
//                    .replySERCERET("d")
//                   // .memberNICKNAME("dally")
//                    .replyID(1L)
//                    .ip("19.168.")
//
//                    .board(board)
//                    .build();
//            replyRepository.save(reply);
//        }
    }
    //@Test
    //@Transactional
    public void lazyLoading(){
        Optional<Board> board = boardRepository.findById(1L);
        if(board.isPresent()){
            System.out.println(board.get());
            System.out.println(board.get().getMemberNICKNAME());
        }
    }
    //해결 >> could not initialize proxy - no Session >> @Transactional
    // @Test
    //@Transactional
    public void testJoin1(){
        Object result = boardRepository.getBoardWithWriter(1L);
        Object []  arr = (Object []) result;
        System.out.println(Arrays.toString(arr));
    }

    //@Test
    public void testJoin2(){
        List<Object[]> result = boardRepository.getBoardWithReply(1L);
        for(Object []  arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }

    //@Test //could not initialize proxy - no Session
    //@Transactional
    public void testBoardList(){
        //페이징 조건 생성 - 0 페이지에 10개의 데이터를 bno의 내림차순으로 가져오기
        Pageable pageable = PageRequest.of(0, 1, Sort.by("boardNUMBER").descending());

        Page<Object[]> result =
                boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            Object[] ar = (Object [])row;
            System.out.println(Arrays.toString(ar));
        });
    }

    //@Test
    //@Transactional
    public void testBoard(){
        Object result = boardRepository.getBoardByBno(1L);
        Object [] ar = (Object []) result;
        System.out.println(Arrays.toString(ar));
    }
}
