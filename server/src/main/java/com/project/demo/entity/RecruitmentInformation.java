package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *招聘信息：(RecruitmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RecruitmentInformation")
public class RecruitmentInformation implements Serializable {

    //RecruitmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_information_id")
    private Integer recruitment_information_id;
   // 企业名称
   @Basic
    private String enterprise_name;
   // 企业地址
   @Basic
    private String business_address;
   // 企业行业
   @Basic
    private String enterprise_industry;
   // 企业图片
   @Basic
    private String enterprise_picture;
   // 负责人
   @Basic
    private Integer person_in_charge;
   // 企业简介
   @Basic
    private String company_profile;
   // 专业要求
   @Basic
    private String professional_requirements;
   // 年龄要求
   @Basic
    private String age_requirements;
   // 性格
   @Basic
    private String character;
   // 学历要求
   @Basic
    private String educational_requirements;
   // 毕业学校要求
   @Basic
    private String graduation_school_requirements;
   // 招聘职业
   @Basic
    private String recruitment_occupation;
   // 证书要求
   @Basic
    private String certificate_requirements;
   // 职业类别
   @Basic
    private String occupational_category;
   // 工作类型
   @Basic
    private String type_of_work;
   // 工作省份
   @Basic
    private String working_province;
   // 工作年限
   @Basic
    private String working_years;
   // 月薪
   @Basic
    private String a_monthly_salary;
   // 是否包住
   @Basic
    private String is_it_wrapped;
   // 工作时间
   @Basic
    private String working_hours;
   // 薪酬福利
   @Basic
    private String compensation_and_benefits;
   // 职业描述
   @Basic
    private String job_description;
    // 点击数
    @Basic
    private Integer hits;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
