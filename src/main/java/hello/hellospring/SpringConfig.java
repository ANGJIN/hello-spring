package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// 자바 코드로 직접 스프링 빈 등록하기
// 컴포넌트 스캔 방식이 아닌 직접 자바 코드로 컨테이너에 빈을 등록한다.

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//
//    private final DataSource dataSource;
//    private final EntityManager em;
//
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository(); /* Memory 를 이용한 DB */
////        return new JdbcMemberRepository(dataSource); /* 순수 JDBC를 이용해 DB 접근 */
////        return new JdbcTemplateMemberRepository(dataSource); /* JDBC Template를 이용해 DB 접근 */
////        return new JpaMemberRepository(em); /* JPA를 이용한 DB 접근*/
//    }

}
