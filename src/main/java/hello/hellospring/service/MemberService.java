package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Service
// 핵심 비즈니스 로직 구현

@Transactional /* 메소드 실행 시 트랜잭션 시작, 종료 시 커밋, 에러 발생 시 롤백 JPA를 이용한 모든 데이터 변경은 트랜잭션 안에서 실행해야 함*/
@Service /* 컴포넌트 스캔으로 Spring Bean 등록 가능*/
public class MemberService {
    // @Autowired를 사용하여 필드에 주입 가능
    private final MemberRepository memberRepository;

    // setMemberRepository() 선언후 @Autowired 사용하여 Setter에 주입 가능

    @Autowired /* 생성자에 Autowired 사용하여 객체 생성 시점에 스프링 컨테이너에서 해당 빈을 찾아서 주입. 생성자가 1개인 경우 생략가능 */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 참고 : 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자에 Autowired를 사용하여 주입하는 방법 권장.

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
