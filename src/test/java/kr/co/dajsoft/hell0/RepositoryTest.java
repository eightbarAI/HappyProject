package kr.co.dajsoft.hell0;

import kr.co.dajsoft.hell0.entity.Board;
import kr.co.dajsoft.hell0.entity.Member;
import kr.co.dajsoft.hell0.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {


    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void insertBoards() {
        for (int i = 1; i <= 100; i = i + 1) {
            Member member = Member.builder()
                    .member_EMAIL("user" + i + "@gmail.com")
                    .member_PW("1234")
                    .member_NAME("USER" + i)
                    .build();

            Board board = Board.builder()
                    .board_NUMBER(Long.valueOf(i))
                    .board_TITLE("내용..." + i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        }


    }
}

