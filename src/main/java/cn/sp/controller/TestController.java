package cn.sp.controller;

import cn.sp.bean.Person;
import cn.sp.dao.PersonDao;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-04 15:25
 */
@RestController
@RequestMapping("person")
public class TestController {

    @Resource
    private PersonDao personDao;


    @PostMapping("add")
    public String addPerson(@RequestBody Person person){
        System.out.println("插入数据：" + person.toString());
        personDao.insert(person);
        return "ok";
    }

    @GetMapping("/{pId}")
    public Person find(@PathVariable int pId){
        return personDao.findByPId(pId);
    }

    @DeleteMapping("/{pId}")
    public String remove(@PathVariable int pId){
        personDao.delete(pId);
        return "ok";
    }

    @PostMapping("update")
    public String update(@RequestBody Person person){
        personDao.update(person);
        return "ok";
    }
}
