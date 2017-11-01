package com.sevendream.springbootdemo.respository;

import com.sevendream.springbootdemo.bean.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer,Integer>{
    /**
     * 根据年龄寻找
     * @param age
     * @return
     * @description 注意命名，遵循JPA规范，比如findByAge；会去Developer中寻找age属性
     */
    List<Developer> findByAge(Integer age);
}
