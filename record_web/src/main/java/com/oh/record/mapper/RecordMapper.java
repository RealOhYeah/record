package com.oh.record.mapper;

import com.oh.record.domain.Record;
import com.oh.record.domain.vo.RecordPagingToDataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.sl.draw.geom.Guide;

import java.util.List;

/**
 * 向导访问层
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:24
 */
@Mapper
public interface RecordMapper {

    /**
     * 新增数据
     *
     * @param record 实例对象
     */
    void insert(Record record);


    /**
     * 分页查询
     * @param start
     * @param size
     * @param record
     * @return
     */
    List<RecordPagingToDataVo> recordPagingToGetUserData(Long start, Integer size,@Param("params")  Record record);

    /**
     * 查询总数
     * @param record
     * @return
     */
    Long getCount(@Param("params") Record record);
}

