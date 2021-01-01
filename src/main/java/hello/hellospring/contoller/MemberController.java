package hello.hellospring.contoller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller /* Controller 어노테이션은 내부에 @Component 어노테이션 포함. 컴포넌트 스캔에 의해 자동으로 스프링 컨테이너에 Bean 등록*/
public class MemberController {

    private final MemberService memberService;

    @Autowired /* Spring 으로부터 MemberService 객체(빈)을 주입받는다*/
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/membersList";
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // home 화면으로 redirect
    }
}


