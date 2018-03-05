package com.doo.sbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author doo at 2018/03/02
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
     * 查询所有数据
     */
    @GetMapping(value = "/girls")
    public List<Girl> getAll(){
        return girlRepository.findAll();
    }
    /**
     * 新增数据
     */
    @PostMapping(value = "/girls")
    public Girl save(@RequestParam("cupSize") String cupSize,
                     @RequestParam("age") Integer age){

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    /**
     * 根据ID查询数据
     */
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> getOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }
    /**
     * 修改数据
     */
    @PutMapping(value = "/girls/{id}") //put提交的数据要用x-www-form-urlencoded
    public Girl update(@PathVariable("id") Integer id,
                       @RequestParam("age") Integer age,
                       @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    /**
     * 根据ID删除数据
     */
    @DeleteMapping(value = "/girls/{id}")
    public void delete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }
    /**
     * 根据年龄查询
     */
    @PutMapping(value = "/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 添加多条数据
     */
    @GetMapping(value = "/addgirls")
    public void addGirls(){
        girlService.addGirls();
    }
}
