package com.atguigu.springboot06.controller;

import com.atguigu.springboot06.Sercvice.CitySolrService;
import com.atguigu.springboot06.bean.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Classname CitySolrController
 * @Description TODO
 * @Date 2020/3/2 0002 20:53
 * @Created by Administrator - liujinpeng
 */
@Controller
public class CitySolrController {

    @Resource
    private CitySolrService citySolrServiceImpl;

    @RequestMapping(value = {"/list"})
    public String list(){
        return "welcome";
    }

    @RequestMapping("/add")
    @ResponseBody
    public City add(@RequestBody City city){
        citySolrServiceImpl.add(city);




        return city;
    }


    @RequestMapping("/queryAll")
    @ResponseBody
    public List<City> queryAll(){
        return citySolrServiceImpl.queryAll();
    }


    @RequestMapping("/query")
    @ResponseBody
    public List<City> query(@RequestParam("query")String query){
        return citySolrServiceImpl.query(query);
    }
}
