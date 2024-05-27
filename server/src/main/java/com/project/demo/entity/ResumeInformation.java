package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *简历信息：(ResumeInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ResumeInformation")
public class ResumeInformation implements Serializable {

    //ResumeInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_information_id")
    private Integer resume_information_id;
   // 企业名称
   @Basic
    private String enterprise_name;
   // 企业行业
   @Basic
    private String enterprise_industry;
   // 学生
   @Basic
    private Integer student;
   // 学生简历
   @Basic
    private String student_resume;
   // 负责人
   @Basic
    private Integer person_in_charge;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
