package com.oh.record.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文档实体类
 */
public class Record implements Serializable {

    private Long id;
    /**
     * 网址名
     */
    private String name;
    /**
     * 文档类型
     */
    private String type;
    /**
     * 文档内容
     */
    private String content;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 状态（0：正常状态，1：异常状态）
     */
    private Integer status;
    /**
     * 逻辑删除（0：未删除，1：已删除）
     */
    private Integer delFlag;

    public Record() {
    }

    public Record(Long id, String name, String type, String content, LocalDateTime createTime, Integer status, Integer delFlag) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.content = content;
        this.createTime = createTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
