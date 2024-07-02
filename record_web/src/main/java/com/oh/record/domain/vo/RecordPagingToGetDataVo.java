package com.oh.record.domain.vo;

import java.io.Serializable;
import java.util.List;

public class RecordPagingToGetDataVo implements Serializable {

    private List<RecordPagingToDataVo> list;
    private Integer count;

    public RecordPagingToGetDataVo() {
    }

    public RecordPagingToGetDataVo(List<RecordPagingToDataVo> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<RecordPagingToDataVo> getList() {
        return list;
    }

    public void setList(List<RecordPagingToDataVo> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RecordPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
