package com.spring.mvc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller                     // 這是一個 Controller
@RequestMapping("/hello")       // 網址映射路徑
public class Hello {
    
    @RequestMapping("/time")    // 網址映射路徑
    @ResponseBody               // 把 return的內容作為 response body
    public String time() {
        return new Date().toString();
    }
    
    @RequestMapping("/add/{a}/{b}")
    @ResponseBody
    public String add(@PathVariable int a, @PathVariable int b){
        int sum = a + b;
        return sum + "";
    }
    
     /*
        Ant 語法:
        * : 任意多字
        ? : 任意一字
        ** : 任意多組資料夾
    */
    
    // @RequestMapping("/*/antPath")  
    // @RequestMapping("/java?/antPath")
    @RequestMapping("/**/antPath") 
    @ResponseBody
    public String antPath(){
        return "Ant path Success!!!";
    }
    
    // /login?username=admin&password=1234
    // /checkin?username=admin&password=4321
    // /login?username=admin
    @RequestMapping(value = {"/login", "/checkin"})
    @ResponseBody
   //public String login(@RequestParam String username, 
         // @RequestParam String password){
    public String login(@RequestParam String username, 
            @RequestParam(required = false) String password){ 
        return username + ":" + password;
   }
    
    
    // /login2?user=admin&pwd=1234
    // /login2?&pwd=1234
    @RequestMapping(value = {"/login2", "/checkin2"})
    @ResponseBody 
    public String login2(
            @RequestParam(name = "user", required = false) String username, 
            @RequestParam(name = "pwd") String password){ 
        return username + ":" + password;
   }
    
    // 多個參數時
    // /login3?user=admin&pwd=1234&age=12&level=7
    @RequestMapping(value = {"/login3"})
    @ResponseBody
    public String login3(@RequestParam Map<String, String> params){
        return params.toString();
    }
    
    // 一個參數擁有多個值時
    // /login4?id=1,3,2,5,68
    @RequestMapping(value = {"/login4"})
    @ResponseBody
    public String login4(@RequestParam(name = "id") List<String> ids){
        return ids.toString();
    }
}
