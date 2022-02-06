package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
<<<<<<< HEAD
import kr.co.dajsoft.hell0.repository.BoardRepository;
import kr.co.dajsoft.hell0.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

=======
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
>>>>>>> 8a27e20704129bfa75d294e15807b3c22219749c
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

<<<<<<< HEAD
    public void insertMembers() {
        for (int i = 1; i <= 100; i = i + 1) {
            Member member = Member.builder()
                    .member_PHONE("0101234" + i)
                    .member_ADDRESS("효자동" + i + "번지")
                    .member_EMAIL("user" + i + "@naver.com")
                    .member_NAME("name" + i)
                    .member_GENDER("남,여")
                    .member_NICKNAME("nickname" + i)
                    .member_PW("123" + i)
                    .build();

            memberRepository.save(member);
        }
    }

    @Test
    public void insertBoards() {
        for (int i = 1; i <= 100; i = i + 1) {
            Member member = Member.builder()
                    .member_EMAIL("user" + i + "@gmail.com")
                    .member_PW("1234")
                    .member_NAME("USER" + i)
                    .build();

            Board board = Board.builder()
                    .board_NICKNAME("da")
                    .board_TITLE("title..." + i)
                    .board_CONTENT("content.."+i)
=======
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
                    .boardTITLE("제목..." + i)
                    .boardCONTENT("내용..." + i)
                    .boardNICKNAME("daj"+i)
                    .boardREADCNT(1L)
                    .boardNUMBER((long) i)
>>>>>>> 8a27e20704129bfa75d294e15807b3c22219749c
                    .writer(member)
                    .build();
            boardRepository.save(board);
        }
<<<<<<< HEAD


    }
}

=======
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
                    .replyCONTENT("댓글..." + i)
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
    //얘는 왜 안돼 ? could not initialize proxy - no Session
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
    public void testBoard(){
        Object result = boardRepository.getBoardByBno(1L);
        Object [] ar = (Object []) result;
        System.out.println(Arrays.toString(ar));
    }



}
>>>>>>> 8a27e20704129bfa75d294e15807b3c22219749c
