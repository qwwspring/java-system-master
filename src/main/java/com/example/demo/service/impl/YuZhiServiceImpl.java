package com.example.demo.service.impl;

import com.example.demo.bean.YuZhi;
import com.example.demo.service.YuZhiRepository;
import com.example.demo.service.YuZhiServive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YuZhiServiceImpl implements YuZhiServive {
    private final YuZhiRepository yuZhiRepository;

    public List<YuZhi> getList(){
        return  yuZhiRepository.findAll();
    }

}
