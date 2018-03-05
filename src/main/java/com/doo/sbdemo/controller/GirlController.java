package com.doo.sbdemo.controller;

import com.doo.sbdemo.domain.Girl;
import com.doo.sbdemo.domain.Result;
import com.doo.sbdemo.repository.GirlRepository;
import com.doo.sbdemo.service.GirlService;
import com.doo.sbdemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    //记录日志
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    /**
     * 查询所有数据
     */
    @GetMapping(value = "/girls")
    public List<Girl> getAll(){
        logger.info("do.....");
        return girlRepository.findAll();
    }
    /**
     * 新增数据
     * @param cupSize
     * @param age
     * @return Girl
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
     * 新增数据
     * @param girl
     * @return Girl
     */
    @PostMapping(value = "/obj/girl")
    public Result<Girl> save(@Valid Girl girl, BindingResult bindingResult){
       /* if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(0);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
        }
        girl.getAge();
        girl.getCupSize();
        girl.getMoney();
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(girlRepository.save(girl));
        return result;*/
       //重构，使用util类
        if(bindingResult.hasErrors()){
//            return null;
            return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }
        /*girl.getAge();
        girl.getCupSize();
        girl.getMoney();*/
        return ResultUtil.success(girlRepository.save(girl));
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
    /**
     * 查询数据（排除不符合条件的数据）
     */
    @GetMapping(value = "/obj/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.findByAge(id);
    }
}
