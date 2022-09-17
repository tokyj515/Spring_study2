package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러라고 어노테이션 달아줘야 함
public class HelloController {

    @GetMapping("/hello") // /hello라고 주소에 쳐지면 이 메소드를 실행해줌
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello!";
    }
}
