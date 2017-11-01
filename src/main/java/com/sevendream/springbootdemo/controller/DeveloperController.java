package com.sevendream.springbootdemo.controller;

import com.sevendream.springbootdemo.bean.BaseResult;
import com.sevendream.springbootdemo.bean.Developer;
import com.sevendream.springbootdemo.common.CommonException;
import com.sevendream.springbootdemo.common.ExceptionEnum;
import com.sevendream.springbootdemo.respository.DeveloperRepository;
import com.sevendream.springbootdemo.service.DeveloperService;
import com.sevendream.springbootdemo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperService developerService;
    @RequestMapping(value = "developers")
    public List<Developer> getDeveloperList(){
        return developerRepository.findAll();
    }

    /**
     * 新增一个开发者
     * @param name
     * @param age
     * @param sex
     * @return
     * @description 这里我选择的是post方式 需要注意
     */
    @PostMapping(value = "addGirls")
    public Developer addGirls(@RequestParam("name") String name,@RequestParam("age") Integer age,
                           @RequestParam("sex") String sex){
        Developer developer =new Developer();
        developer.setName(name);
        developer.setAge(age);
        developer.setSex(sex);
        return developerRepository.save(developer);
    }

    /**
     * 获取数据库中的一个开发者
     * @param id
     * @return
     * @description 注意这里是截取路径的id 所以注解使用PathVariable
     */
    @RequestMapping(value = "/developer/{id}")
    public Developer getOneDeveloper(@PathVariable("id") Integer id ){
        return  developerRepository.findOne(id);
    }

    /**
     * 修改开发者信息
     * @param id
     * @param age
     * @return
     *  @description 这种有弊端，如果其他属性没写 会置于null
     */
    @PutMapping(value = "/developer/{id}")
    public Developer updateOneDeveloper(@PathVariable("id") Integer id ,
                                        @RequestParam("age") Integer age){
        Developer developer =new Developer();
        developer.setId(id);
        developer.setAge(age);
        return  developerRepository.save(developer);
    }

    /**
     * 删除一个开发者
     * @param id
     */
    @DeleteMapping(value = "/developer/{id}")
    public void deleteOneDeveloper(@PathVariable("id") Integer id ){
        developerRepository.delete(id);
    }

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    @GetMapping(value = "/developers/age/{age}")
    public List<Developer> getDevelopersByAge(@PathVariable("age") Integer age ){
        return  developerRepository.findByAge(age);
    }

    /**
     * 批量插入（事务管理）
     */
    @PostMapping(value = "/batchInsert")
    public void batchInsert(){
        developerService.batchInsert();
    }

    /**
     * （含表单验证）增加一个开发者
     * @param developer
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "addAGirl")
    public BaseResult<Developer> addAGirl(@Valid Developer developer, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            throw new CommonException(ExceptionEnum.EXCEPTION_FAIL.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(developerRepository.save(developer));
    }
}
