package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *企业信息：(EnterpriseInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EnterpriseInformation")
public class EnterpriseInformation implements Serializable {

    //EnterpriseInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enterprise_information_id")
    private Integer enterprise_information_id;
   // 企业名称
   @Basic
    private String enterprise_name;
   // 企业地址
   @Basic
    private String business_address;
   // 企业行业
   @Basic
    private String enterprise_industry;
   // 企业简介
   @Basic
    private String company_profile;
   // 企业图片
   @Basic
    private String enterprise_picture;
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
