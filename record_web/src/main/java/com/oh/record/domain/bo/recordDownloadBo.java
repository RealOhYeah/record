package com.oh.record.domain.bo;

import java.io.Serializable;

public class recordDownloadBo implements Serializable {

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
    private String context;

    public recordDownloadBo() {
    }


    public recordDownloadBo(String name, String type, String context) {
        this.name = name;
        this.type = type;
        this.context = context;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "recordDownloadBo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}

