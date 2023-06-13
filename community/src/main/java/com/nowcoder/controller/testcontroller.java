package com.nowcoder.controller;

import com.nowcoder.entity.Page;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main")
public class testcontroller {
    @ResponseBody
    @RequestMapping("/hh")
    public String print(){
        return "helloworld";
    }

    @ResponseBody
    @RequestMapping(path="/mm",method = RequestMethod.GET)
    public void print1(
            @RequestParam(name="id", required = false, defaultValue = "10") int a,
            @RequestParam(name="name", required = true) String name){
        System.out.println(a);
        System.out.println(name);
    }
    @ResponseBody
    @RequestMapping("/testPage/{rows}")
    public void testpage(Page page){
        System.out.println(page.getRows());
    }


    @ResponseBody
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    public String student(@PathVariable("id") int id){
        return "student num" + id;
    }

    //Post
    @ResponseBody
    @RequestMapping(path="student")
    public String getstu(String name, int id){
        System.out.println(name);
        System.out.println(id);
        return "success";
    }

    //响应html数据
    @RequestMapping("/gets")
    public ModelAndView getStudent(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "zhangsan");
        mav.addObject("id", 3);
        mav.setViewName("/demo/student.html");
        return mav;
    }
    @RequestMapping("/gets1")
    public String getStudent(Model model){
        model.addAttribute("name", "东北大学");
        model.addAttribute("id", 333);
        return "/demo/student";
    }
    @RequestMapping("/emp")
    @ResponseBody
    public Map<String, Object> getEmp(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 3);
        return map;
    }
    @RequestMapping("/emps")
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 3);
        map.put("name", "lisi");
        map.put("age", 20);
        list.add(map);
        map = new HashMap<>();
        map.put("name", "zhaosi");
        map.put("age", 25);
        list.add(map);
        return list;
    }

}
