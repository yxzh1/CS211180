package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *学生工作省份：(StudentWorkProvince)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "StudentWorkProvince")
public class StudentWorkProvince implements Serializable {

    //StudentWorkProvince编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_work_province_id")
    private Integer student_work_province_id;
   // 省份名称
   @Basic
    private String province_name;
   // 学生数量
   @Basic
    private Integer number_of_students;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
