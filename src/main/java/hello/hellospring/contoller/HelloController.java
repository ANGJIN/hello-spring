package hello.hellospring.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller
// 웹 MVC의 Controller
// Request URL과 Logic을 Mapping해 준다

@Controller
public class HelloController {
    @GetMapping("hello") /* /hello URL의 HTTP GET method 요청에 mapping */
    public String hello(Model model) {

        model.addAttribute("data", "spring!!"); // model에 (data:"spring!!")을 담아
        return "hello"; // hello를 return해 주면
        // viewResolver가 resources/templates/hello.html 을 mapping해 준다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")  String name, /* URL Parameter 중 key가 name인 value를 주입받는다 */
                           Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody /* view resolver를 사용하지 않고 HTTP response body에 return값을 담아 반환*/
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; /* HttpMessageConverter (StringHttpMessageConverter)가 문자를 반환 */
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; /* HttpMessageConverter (MappingJackson2HttpMessageConverter)가 객체를 JSON형태로 반환*/
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        } }
}
