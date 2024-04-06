package com.quintus.controller;

import com.quintus.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController注解 标注类是一个RESTFul风格的控制器Controller，它将控制器中的方法的返回值直接序列化为json或其他格式的数据，而不是渲染为视图页面
@RestController
// @RequestingMapping注解 会将HTTP请求映射到MVC和Rest控制器的处理方法上
// 简单来讲就是将路径url（参数设置的）映射到MVC上
@RequestMapping("user")
public class UserController {

    // @GetMapping参数 GET请求的路径映射
    @GetMapping
    // @RequestParam注解 指定绑定的请求参数名、要求请求参数是否必须传递、为请求参数提供默认值
    public List<User> page(@RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false,defaultValue = "10") int size){
        System.out.println("page = " + page + ", size = " + size);
        return null;
    }

    @PostMapping
    // @RequestBody注解 表示接受json数据，并赋值给方法参数
    public User save(@RequestBody User user){
        return user;
    }

    // {id} 表示路径参数由向查询的{id}决定
    @GetMapping("{id}")
    // @PathVariable 表示接受路径参数，方法参数与路径参数名一致（都是id），所以接受的参数名可以省略
    public User detail(@PathVariable Integer id){
        return null;
    }

    @PutMapping
    public User update(@RequestBody User user){
        return user;
    }

    @DeleteMapping("{id}")
    public User delete(@PathVariable Integer id){
        return null;
    }

    @GetMapping("search")
    public List<User> search(String keyword,
                             @RequestParam(required = false,defaultValue = "1") int page,
                             @RequestParam(required = false,defaultValue = "10") int size){
        return null;
    }
}
