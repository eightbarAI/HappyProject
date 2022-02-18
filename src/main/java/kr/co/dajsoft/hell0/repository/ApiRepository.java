package kr.co.dajsoft.hell0.repository;

import kr.co.dajsoft.hell0.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Api, Long>,SearchBoardRepository {

}
