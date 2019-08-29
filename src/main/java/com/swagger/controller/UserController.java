package com.swagger.controller;

import com.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "用户模块",description = "用户模块的接口信息")
public class UserController {
    //模拟数据库
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User("张三","123456"));
        users.add(new User("李四","123456"));
    }
    //获取用户列表的方法
    @ApiOperation(value = "获取用户列表",notes = "获取所有的用户列表")
    @GetMapping("/user")
    public Object users(){
        Map<String,Object> map = new HashMap<>();
        map.put("users",users);
        return map;
    }
    @ApiOperation(value = "获取单个用户",notes = "根据Id查询某个用户的信息")
    @ApiImplicitParam(value = "用户Id",paramType = "path")
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return users.get(id);
    }
    @ApiOperation(value = "添加用户",notes = "根据传入用户信息添加用户")
    @ApiImplicitParam(value = "用户对象",paramType = "query")
    @PostMapping(value = "/user")
    public Object add(User user){
        return users.add(user);
    }
    @ApiOperation(value = "删除用户",notes = "根据传入用户Id删除用户")
    @ApiImplicitParam(value = "用户Id",paramType = "path")
    @DeleteMapping("/user/{id}")
    public Object delete(@PathVariable("id") int id){
        return users.remove(id);
    }
}
