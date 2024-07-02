package com.oh.record.service;

import com.oh.record.domain.Record;
import com.oh.record.domain.bo.RecordPagingToGetDataBo;
import com.oh.record.domain.vo.ResponseVo;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * 向导接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:40
 */
public interface RecordService {


    /**
     * 分页查询生成的文档
     * @param recordPagingToGetDataBo
     * @return
     */
    ResponseVo queryByPage(RecordPagingToGetDataBo recordPagingToGetDataBo);

    /**
     * 生成文档
     * @param record
     * @return
     */
    ResponseVo insert(Record record) throws IOException;

    /**
     * 删除Record数据
     * @param id
     * @return
     */
    ResponseVo deleteById(Long id);

    /**
     * 文档下载
     *
     * @param wordUrl
     * @return
     */
    ResponseEntity<byte[]> getWord(String wordUrl) throws IOException;
}
