package com.doo.sbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author doo at 2018/03/02
 */
@RestController
@RequestMapping("hello")
public class HelloWorldController {
   /* @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;*/
    @Autowired
    private HelloProperties girl;
    //@RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET) //多个映射
    //获取url传递的值,1.//http://localhost:8080/sbdemo/hello/say/23
       /* @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
        public String say(@PathVariable("id") Integer id){*/
    //获取url传递的值,2.//http://localhost:8080/sbdemo/hello/say?id=23
        //@RequestMapping(value = "/say",method = RequestMethod.GET)
    //简化Mapping
        //@PostMapping(value = "/say")
        @GetMapping(value = "/say")
        //public String say(@RequestParam("id") Integer id){
        public String say(@RequestParam(value="id", required = false, defaultValue = "0") Integer id){ //设置默认值
            //return "Hello Spring Boot"+cupSize+age+content;
            return girl.getCupSize()+girl.getAge()+"**"+id;
        }
}
