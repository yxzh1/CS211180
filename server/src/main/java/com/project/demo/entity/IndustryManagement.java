package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *行业管理：(IndustryManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "IndustryManagement")
public class IndustryManagement implements Serializable {

    //IndustryManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "industry_management_id")
    private Integer industry_management_id;
   // 行业名称
   @Basic
    private String industry_name;
   // 行业编号
   @Basic
    private String industry_number;
   // 行业详情
   @Basic
    private String industry_details;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
