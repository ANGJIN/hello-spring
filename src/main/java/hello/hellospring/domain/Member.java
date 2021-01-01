package hello.hellospring.domain;

// Domain
// 비즈니스 도메인 객체
// 데이터베이스에 저장하고 관리되는 객체

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity /* JPA Entity로 객체 Mapping */
public class Member {

    @Id /* PK */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* PK에 Generation strategy 적용 */
    private Long id;
    private String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    } }
