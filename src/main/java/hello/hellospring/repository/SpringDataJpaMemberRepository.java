package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Spring Data Jpa 자동으로 구현체 생성하여 스프링 빈으로 등록
// Interface 만으로도 기본적인 CRUD 가능
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 규칙에 맞게 method명 선언 (findBy~~~) 하면 Spring Data JPA가 자동으로 기능 구현한 메소드 생성
//    @Override
//    Optional<Member> findByName(String name);
}
