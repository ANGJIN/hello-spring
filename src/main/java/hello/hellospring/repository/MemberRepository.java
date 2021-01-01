package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// Repository
// 데이터베이스에 실제로 접근하고 도메인 객체를 DB에 저장하고 관리하는 역할을 한다
// 인터페이스를 이용해 구현체를 추후 변경하기 용이하도록 (다른 저장소로 교체하기 쉽도록) 설계

public interface MemberRepository {
    Member save(Member member);

    // find의 결과가 null인 경우를 처리하기 위해 Optional 객체 사용
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
