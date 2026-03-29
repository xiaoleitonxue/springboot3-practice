package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//@RequestMapping("/depts")
@RestController
public class DeptController {

    //public static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        //System.out.println("查询全部数据");
        log.info("查询全部数据");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }

    /*@DeleteMapping("/depts")
    public Result delete(HttpServletRequest request){
        String idst = request.getParameter("id");
        int id = Integer.parseInt(idst);
        System.out.println("删除数据" + id);
        return Result.success();
    }*/

    /*@DeleteMapping("/depts")
    public Result delete(@RequestParam(value = "id", required = false) Integer id){
        System.out.println("删除数据" + id);
        return Result.success();
    }*/

    @DeleteMapping("/depts")
    public Result delete(Integer id){
        //System.out.println("删除数据" + id);
        log.info("删除数据: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        //System.out.println("添加数据" + dept);
        log.info("添加数据: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /*@GetMapping("/depts/{id}")
    public Result get(@PathVariable Integer id){
        System.out.println("查询数据" + id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }*/

    @GetMapping("/depts/{id}")
    public Result get(@PathVariable("id") Integer deptid){
        //System.out.println("查询数据" + deptid);
        log.info("查询数据: {}", deptid);
        Dept dept = deptService.findById(deptid);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改数据" + dept);
        log.info("修改数据: {}", dept);
        deptService.update(dept);
        return Result.success();
    }



}
