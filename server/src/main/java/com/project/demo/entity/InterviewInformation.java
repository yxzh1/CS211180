package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *面试信息：(InterviewInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "InterviewInformation")
public class InterviewInformation implements Serializable {

    //InterviewInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_information_id")
    private Integer interview_information_id;
   // 学生
   @Basic
    private Integer student;
   // 企业名称
   @Basic
    private String enterprise_name;
   // 企业行业
   @Basic
    private String enterprise_industry;
   // 负责人
   @Basic
    private Integer person_in_charge;
   // 邀请信息
   @Basic
    private String invitation_information;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
