package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *通知公告：(NoticeAnnouncement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "NoticeAnnouncement")
public class NoticeAnnouncement implements Serializable {

    //NoticeAnnouncement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_announcement_id")
    private Integer notice_announcement_id;
   // 公告标题
   @Basic
    private String announcement_title;
   // 公告编号
   @Basic
    private String announcement_no;
   // 发布时间
   @Basic
    private Timestamp release_time;
   // 公告内容
   @Basic
    private String announcement_content;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
