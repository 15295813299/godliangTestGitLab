package com.tzf.micro_student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzf.entity.Student;
import com.tzf.micro_student.dao.StudentDao;
import com.tzf.micro_student.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * ClassName:StudentServiceImpl
 * Function:
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:
 * @Date: Create in 下午 6:03 2020/11/24 0024
 */
@Service("StudentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}
