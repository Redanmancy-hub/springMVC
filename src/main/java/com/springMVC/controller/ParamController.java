package com.springMVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springMVC.pojo.User;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
public class ParamController {

    @GetMapping("/param8")
    public String param8(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request+" "+response);
        return "spring_mvc.jsp";
    }

    //文件上传
    @PostMapping("/param7")
    public String param7(@RequestBody MultipartFile myFile) throws Exception {
        System.out.println(myFile);
        //将上传的文件进行保存--文件复制
        //1.获得当前上传文件的输入流
        InputStream inputStream = myFile.getInputStream();
        //2.获得上传文件位置的输出流
        OutputStream outputStream = new FileOutputStream("C:\\Users\\86135"+myFile.getOriginalFilename());
        //3.执行文件拷贝
        IOUtils.copy(inputStream,outputStream);
        //4.关闭流资源
        inputStream.close();
        outputStream.close();
        return "spring_mvc.jsp";
    }

    //http://localhost:8080/user/100 =>根据id查询
    @GetMapping("/user/{id}/{username}")
    public String findUserById(
            @PathVariable("id") String id,
            @PathVariable("username") String username
    ) {
        System.out.println("id=>"+id);
        System.out.println("username=>"+username);
        return "spring_mvc.jsp";
    }

    @PostMapping("/param6")
    //如果要封装成集合，需要加上@RequestParam，数组不需要
    public String param6(@RequestBody User user) {
        //使用Jackson进行转换，将json格式的字符串转换成User对象
        System.out.println(user);
        return "spring_mvc.jsp";
    }

    //http://localhost:8080/param5?username=zhangsan&age=18&hobbies=zq&hobbies=pq&hobbies=ppq&birthday=2023/7/11&address.city=cq&address.area=sj
    @GetMapping("/param5")
    //如果要封装成集合，需要加上@RequestParam，数组不需要
    public String param5(User user){
        System.out.println(user);
        return "spring_mvc.jsp";
    }

    //http://localhost:8080/param4?username=zhangsan&age=18
    @GetMapping("/param4")
    //如果要封装成集合，需要加上@RequestParam，数组不需要
    public String param4(@RequestParam Map<String,Object> map){
      map.forEach((k,v)->{
          System.out.println(k+"==>"+v);
      });
        return "spring_mvc.jsp";
    }

    //http://localhost:8080/param3?hobby=zq&hobby=pq&hobby=ppq
    @GetMapping("/param3")
    //如果要封装成集合，需要加上@RequestParam，数组不需要
    public String param3(@RequestParam List<String> hobby){
        for (String s : hobby) {
            System.out.println(s);
        }
        return "spring_mvc.jsp";
    }

    //http://localhost:8080/param2?hobby=zq&hobby=pq&hobby=ppq
    @GetMapping("/param2")
    public String param2(String[] hobby){
        for (String s:hobby){
            System.out.println(s);
        }
        return "spring_mvc.jsp";
    }

    //http://localhost:8080/param1?username=zhangsan&age=10
    @GetMapping("/param1")
    public String param1(@RequestParam("username") String name, int age){
        System.out.println("username:"+name+"==="+"age:"+age);
        return "forward:spring_mvc.jsp";
    }
}
