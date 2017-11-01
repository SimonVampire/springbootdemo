package com.sevendream.springbootdemo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class myAspect {
    /*  @Before("execution(public * com.sevendream.springbootdemo.controller.*.*(..))")
      public void doBefore(){
          System.out.println("myAspect.....before ");
      }

      @After("execution(public * com.sevendream.springbootdemo.controller.*.*(..))")
      public void doAfter(){
          System.out.println("myAspect.....After ");
      }*/
    @Pointcut("execution(public * com.sevendream.springbootdemo.controller.*.*(..))")
    public void doCut() {}

    @Before("doCut()")
    public void doBefore() {
        System.out.println("myAspect.....before ");
    }

    @After("doCut()")
    public void doAfter() {
        System.out.println("myAspect.....After ");
    }
}
