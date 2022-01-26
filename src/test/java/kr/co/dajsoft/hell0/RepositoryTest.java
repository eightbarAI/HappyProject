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

    //회원 데이터 100명을 추가할 테스트 메서드를 작성하고 수행
    //@Test
    public void insertMembers() {
        for (int i = 1; i <= 100; i = i + 1) {
            Member member = Member.builder()
                    .MEMBER_PHONE("0101234" + i)
                    .MEMBER_ADDRESS("효자동" + i + "번지")
                    .MEMBER_EMAIL("user" + i + "@naver.com")
                    .MEMBER_NAME("name" + i)
                    .MEMBER_GENDER("남,여")
                    .MEMBER_NICKNAME("nickname" + i)
                    .MEMBER_PW("123" + i)
                    .build();

            memberRepository.save(member);
        }
    }

    //@Test
    public void insertBoards() {
        for (int i = 1; i <= 100; i = i + 1) {
            Member member = Member.builder()
                    .MEMBER_PHONE("0101234" + i)
                    .MEMBER_ADDRESS("효자동" + i + "번지")
                    .MEMBER_EMAIL("user" + i + "@naver.com")
                    .MEMBER_NAME("name" + i)
                    .MEMBER_GENDER("남,여")
                    .MEMBER_NICKNAME("nickname" + i)
                    .MEMBER_PW("123" + i)
                    .build();

            Board board = Board.builder()
                    .BOARD_TITLE("제목" + i)
                    .BOARD_NICKNAME("nickname" + i)
                    .BOARD_CONTENT("내용")
                    .writer(member)
                    .build();
            boardRepository.save(board);
        }
    }

    //@Test
    public void insertReply() {
        Random r = new Random();
        for (long i = 1; i <= 300; i = i + 1) {
            Board board = Board.builder()
                    .BOARD_NUMBER((long) (r.nextInt(100) + 1))
                    .build();

            Reply reply = Reply.builder()
                    .REPLY_ID(i)
                    .REPLY_CONTENT("댓글..." + i)
                    .REPLY_IP("손님")
                    .board(board)
                    .build();
            replyRepository.save(reply);
        }
    }
}