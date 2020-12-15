package com.spring.mvc.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
