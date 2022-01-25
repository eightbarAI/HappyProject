package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
