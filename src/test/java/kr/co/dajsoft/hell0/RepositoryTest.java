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

import javax.transaction.Transactional;
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
   @Test
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
    //@Test
    public void insertReplys(){
        Random r = new Random();
        for(long i=1; i<=3; i=i+1){
            Board board = Board.builder()
                    .BOARD_NUMBER((long)(r.nextInt(1) + 1))
                    .build();
//와....해동인 천재야........
            //걍 숫자가 안 맞아서 그런거였움
            //보드값이 3개면 랜덤댓글달아줄 것도 3개 이하여야햐는데
            //100개나 설정해놓으니 ^^ 되겟?니
            Reply reply = Reply.builder()
                    .REPLY_IP((("198.168"+i)))
                    .REPLY_CONTENT("댓글..." + i)
                    .REPLY_PASSWORD(1234L)
                    .REPLY_SERCERET("d")
                    .MEMBER_NICKNAME("")
                    .REPLY_ID("sfd")
                    .board_number(board)
                    .build();
            replyRepository.save(reply);
        }
    }
    @Test
    @Transactional
    public void lazyLoading(){
        Optional<Board> board = boardRepository.findById(1L);
        if(board.isPresent()){
            System.out.println(board.get());
            System.out.println(board.get().getWriter());
        }
    }


}
