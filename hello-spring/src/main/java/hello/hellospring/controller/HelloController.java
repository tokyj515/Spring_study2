package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러라고 어노테이션 달아줘야 함
public class HelloController {

    @GetMapping("hello") // /hello라고 주소에 쳐지면 이 메소드를 실행해줌
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello!";
    }



    //MVC와 템플릿 엔진 예제
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); //key, value
        return "hello-template";
    }



    //API 방식 예제
    @GetMapping("hello-string")
    @ResponseBody // http body 부분에 리턴값을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;

    }


    //보통 사용하는 api 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
