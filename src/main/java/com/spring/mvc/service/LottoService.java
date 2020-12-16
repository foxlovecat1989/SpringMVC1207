package com.spring.mvc.service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class LottoService {

    public Set<Integer> getNumbers(){
        Set<Integer> nums = new LinkedHashSet<>();
        while(nums.size() < 5){
            nums.add(new Random().nextInt(39 + 1));
        }
        return nums;
    }
}
