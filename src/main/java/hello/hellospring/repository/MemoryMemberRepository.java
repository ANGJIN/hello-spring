package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    // 동시성 문제가 고려되어 있지 않기 때문에 ConcurrentHashMap 및 AtomicLong 사용 고려해야 한다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id increment
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // get의 값이 null일수도 있으므로 ofNullable로 nullable한 Optional 객체 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); /* 조건에 맞는 녀석들중 하나 return (findAny()의 return 값도 Optional<Member>임)*/
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
