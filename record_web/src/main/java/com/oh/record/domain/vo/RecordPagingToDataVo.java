package com.oh.record.domain.vo;

import java.io.Serializable;

public class RecordPagingToDataVo implements Serializable {

    /**
     * 文档名
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


    public RecordPagingToDataVo() {
    }

    public RecordPagingToDataVo(String name, String type, String content) {
        this.name = name;
        this.type = type;
        this.content = content;
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

    @Override
    public String toString() {
        return "RecordPagingToDataVo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
