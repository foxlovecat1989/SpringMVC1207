package com.spring.mvc.controller;

import com.spring.mvc.service.LottoService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto")
public class Lotto {
    
    @Autowired
    private LottoService lottoService;
    
    @RequestMapping("/get")
    // @ResponseBody // 拿掉, 使用 jsp
    public String get(){
        Set<Integer> nums = lottoService.getNumbers();
        return "lotto_page"; // <-- jsp 的檔案(可含子路徑)
    }
}
