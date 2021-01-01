package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect /* 공통 관심 사항인 시간 측정 로직*/
public class TimeTraceAop {

    // 의존관계가 있는 객체 간 메소드 호출 시 바로 호출하는 것이 아닌 프록시 객체를 두어 AOP를 적용

    @Around("execution(* hello.hellospring..*(..))") /* hello.hellospring 패키지 내의 모든 메소드 대상 */
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed(); // 실제 메소드의 수행으로 proceed
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
