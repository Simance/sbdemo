package com.doo.sbdemo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄查询
    List<Girl> findByAge(Integer age);
}
