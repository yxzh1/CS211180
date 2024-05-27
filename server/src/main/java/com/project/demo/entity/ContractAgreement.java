package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *合同协议：(ContractAgreement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ContractAgreement")
public class ContractAgreement implements Serializable {

    //ContractAgreement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_agreement_id")
    private Integer contract_agreement_id;
   // 企业名称
   @Basic
    private String enterprise_name;
   // 学生
   @Basic
    private Integer student;
   // 企业行业
   @Basic
    private String enterprise_industry;
   // 负责人
   @Basic
    private Integer person_in_charge;
   // 合同协议
   @Basic
    private String contract_agreement;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
