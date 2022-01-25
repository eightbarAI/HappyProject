package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.entity.Reply;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import kr.co.dajsoft.hell0.repository.MemberRepository;
import kr.co.dajsoft.hell0.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;


    @Autowired
    private ReplyRepository replyRepository;

    //@Test
    public void insertMember(){
        for(int i=1; i<=3; i=i+1){
            Member member = Member.builder()
                    .MEMBER_NICKNAME("user" + i + "@gmail.com")
                    .MEMBER_PW("1234")
                    .MEMBER_NAME("USER" + i)
                    .MEMBER_EMAIL("dal")
                    .MEMBER_ADDRESS("seoul")
                    .MEMBER_PHONE("01077717524")
                    .MEMBER_GENDER("m")
                    .build();
            memberRepository.save(member);
        }
    }
   //@Test
    public void insertBoards(){
        for(int i=1; i<=3; i=i+1){
            Member member = Member.builder()
                    .MEMBER_NICKNAME("user" + i + "@gmail.com")
                    .MEMBER_PW("1234")
                    .MEMBER_NAME("USER" + i)
                    .MEMBER_EMAIL("dal")
                    .MEMBER_ADDRESS("seoul")
                    .MEMBER_PHONE("01077717524")
                    .MEMBER_GENDER("m")
                    .build();

            Board board = Board.builder()
                    .BOARD_TITLE("제목..." + i)
                    .BOARD_CONTENT("내용..." + i)
                    .BOARD_NICKNAME("daj"+i)
                    .BOARD_READCNT(1L)
                    .BOARD_NUMBER((long) i)
                    .writer(member)

                    .build();
            boardRepository.save(board);
        }
    }
//    @Test
//    public void insertReplys(){
//        Random r = new Random();
//        for(long i=1; i<=3; i=i+1){
//            Board board = Board.builder()
//                    .BOARD_NUMBER((long)(r.nextInt(100) + 1))
//                    .build();
//
//            Reply reply = Reply.builder()
//                    .REPLY_ID("guest"+i)
//                    .REPLY_CONTENT("댓글..." + i)
//                    .REPLY_IP("182.168."+i)
//                    .REPLY_PASSWORD(1234L)
//                    .REPLY_SERCERET("y")
//                    .MEMBER_NICKNAME("user" + i )
//                    .board_number(board)
//                    .build();
//            replyRepository.save(reply);
//        }
//    }
}
