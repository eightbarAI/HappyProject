package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import kr.co.dajsoft.hell0.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

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
                    .writer(member)
                    .build();
            boardRepository.save(board);
        }


    }
}

