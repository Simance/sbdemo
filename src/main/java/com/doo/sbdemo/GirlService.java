package com.doo.sbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务管理
 */
@Service
public class GirlService {
    @Autowired
    private  GirlRepository girlRepository;

    @Transactional
    public void addGirls(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        //int a = 1/0;
        Girl girlB = new Girl();
        girlB.setAge(18);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }
}
