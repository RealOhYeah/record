package com.oh.record.domain.bo;

import com.oh.record.domain.Record;

import java.io.Serializable;

public class RecordPagingToGetDataBo implements Serializable {

    /**
     * 开始坐标
     */
    private Long start;
    /**
     * 每页显示长度
     */
    private Integer size;

    private Record record;


    public RecordPagingToGetDataBo() {
    }

    public RecordPagingToGetDataBo(Long start, Integer size, Record record) {
        this.start = start;
        this.size = size;
        this.record = record;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "RecordPagingToGetDataBo{" +
                "start=" + start +
                ", size=" + size +
                ", record=" + record +
                '}';
    }
}
