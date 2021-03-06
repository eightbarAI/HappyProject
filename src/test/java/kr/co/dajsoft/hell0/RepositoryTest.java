package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.entity.Reply;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import kr.co.dajsoft.hell0.repository.MemberRepository;
import kr.co.dajsoft.hell0.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

   // @Test
    public void insertMembers(){
        for(int i=1; i<=100; i=i+1){
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
  //  @Test
    public void insertBoards(){
        for(int i=1; i<=100; i=i+1){
            Member member = Member.builder()
                    .memberEMAIL("user" + i + "@gmail.com")
                    .memberPW("1234")
                    .memberNAME("USER" + i)
                    .memberNICKNAME("dal")
                    .memberADDRESS("seoul")
                    .memberPHONE("01077717524")
                    .memberGENDER("m")
                    .build();

            Board board = Board.builder()
                    .boardTITLE("??????..." + i)
                    .boardCONTENT("??????..." + i)
                    .boardNICKNAME("daj"+i)
                    .boardREADCNT(1L)
                    .boardNUMBER((long) i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        }
    }
    //@Test
    public void insertReplys(){
        Random r = new Random();
        for(long i=1; i<=100; i=i+1){
            Board board = Board.builder()
                    .boardNUMBER((long)(r.nextInt(1) + 1))
                    .build();

            Reply reply = Reply.builder()
                   // .replyID((("198.168"+i)))
                    .replyCONTENT("??????..." + i)
                    .replyPASSWORD(1234L)
                    .replySERCERET("d")
                   // .memberNICKNAME("dally")
                     .replyID(1L)
                    .ip("19.168.")

                    .board(board)
                    .build();
            replyRepository.save(reply);
        }
    }
    //@Test
    @Transactional
    public void lazyLoading(){
        Optional<Board> board = boardRepository.findById(1L);
        if(board.isPresent()){
            System.out.println(board.get());
            System.out.println(board.get().getWriter());
        }
    }
    //?????? ??? ?????? ? could not initialize proxy - no Session
    @Test
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
    //@Test could not initialize proxy - no Session
    public void testBoardList(){
        //????????? ?????? ?????? - 0 ???????????? 10?????? ???????????? bno??? ?????????????????? ????????????
        Pageable pageable = PageRequest.of(0, 1, Sort.by("boardNUMBER").descending());

        Page<Object[]> result =
                boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            Object[] ar = (Object [])row;
            System.out.println(Arrays.toString(ar));
        });

    }
    //@Test
    public void testBoard(){
        Object result = boardRepository.getBoardByBno(1L);
        Object [] ar = (Object []) result;
        System.out.println(Arrays.toString(ar));
    }



}
