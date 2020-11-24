package com.tzf.micro_student.controller;

import com.tzf.entity.Student;
import com.tzf.micro_student.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:StudentController
 * Function:
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:
 * @Date: Create in 下午 5:14 2020/11/24 0024
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/save")
    public String save(Student student){
        if (student!=null){
            boolean save = studentService.save(student);
        }
        return null;
    }

}
