package com.sevendream.springbootdemo.service;

import com.sevendream.springbootdemo.respository.DeveloperRepository;
import com.sevendream.springbootdemo.bean.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;
    //Transactional标签用于事务管理，一旦失败，2条都不会插入
    @Transactional
    public void batchInsert(){
        Developer developer1 =new Developer();
        developer1.setName("Tom");
        developer1.setAge(22);
        developer1.setSex("man");
        developerRepository.save(developer1);

        Developer developer2 =new Developer();
        developer2.setName("jack");
        developer2.setAge(29);
        developer2.setSex("manmanmanmanmanmanmanman");
        developerRepository.save(developer1);

    }
}
