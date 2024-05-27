package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *留言墙：(MessageWall)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MessageWall")
public class MessageWall implements Serializable {

    //MessageWall编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_wall_id")
    private Integer message_wall_id;
   // 留言标题
   @Basic
    private String message_title;
   // 留言时间
   @Basic
    private Timestamp message_time;
   // 留言人
   @Basic
    private Integer message_person;
   // 留言内容
   @Basic
    private String message_content;
   // 封面
   @Basic
    private String cover;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
