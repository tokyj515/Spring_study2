package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//컨트롤러라고 명시함 -> 스프링이 실행되면 MemberController를 자동 생성해서 스프링 컨테이너 안에 갖고 있음
public class MemberController {
    //private final MemberService memberService = new MemberService();
    // 이렇게 사용하면 여러군데서 사용될 가능성이 있음. 별 기능이 없기 때문에 하나만 생성해서 공용으로 사용

    private final MemberService memberService;
    @Autowired //스프링 컨테이너에서 생성되어 있는 memberService를 가져올 것이라고 명시해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }




}
