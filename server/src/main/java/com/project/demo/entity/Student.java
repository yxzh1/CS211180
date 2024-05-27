package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *学生：(Student)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Student")
public class Student implements Serializable {

    //Student编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer student_id;
   // 性别
   @Basic
    private String gender;
   // 个人简介
   @Basic
    private String personal_profile;
   // 姓名
   @Basic
    private String full_name;
   // 证书
   @Basic
    private String certificate;
   // 年龄
   @Basic
    private String age;
   // 专业
   @Basic
    private String major;
   // 户籍地
   @Basic
    private String registered_residence;
   // 民族
   @Basic
    private String nation;
   // 学历
   @Basic
    private String education;
   // 毕业学校
   @Basic
    private String graduation_school;
   // 身份证号
   @Basic
    private String id_number;
   // 获奖情况
   @Basic
    private String awards;
   // 就业意向
   @Basic
    private String employment_intention;
   // 社会实践
   @Basic
    private String social_practice;
    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
