package com.doo.sbdemo.service;

import com.doo.sbdemo.domain.Girl;
import com.doo.sbdemo.enums.ResultEnum;
import com.doo.sbdemo.exception.GirlException;
import com.doo.sbdemo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 事务管理
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

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

    public void findByAge(Integer id) throws Exception {
        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if (age<10){
            //throw new Exception("年龄小于10");
            //throw new GirlException(100, "年龄小于10");
            throw new GirlException(ResultEnum.PRIMARY);
        }else if (age>10 && age<16){
            //throw new Exception("年龄大于10小于16");
//            throw new GirlException(101, "年龄大于10小于16");
            throw new GirlException(ResultEnum.MIDDLE);
        }
    }
}
