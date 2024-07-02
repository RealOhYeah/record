package com.oh.record.service;

import com.oh.record.domain.Record;
import com.oh.record.domain.bo.RecordPagingToGetDataBo;
import com.oh.record.domain.bo.RecordDownloadBo;
import com.oh.record.domain.vo.ResponseVo;

import java.io.IOException;

/**
 * 向导接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:40
 */
public interface RecordService {

    /**
     * 下载文档
     * @param recordDownloadBo
     * @return
     */
    ResponseVo download(RecordDownloadBo recordDownloadBo);

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
}
