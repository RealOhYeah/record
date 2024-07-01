package com.oh.record.service.impl;

import com.oh.record.domain.Record;
import com.oh.record.domain.bo.RecordPagingToGetDataBo;
import com.oh.record.domain.bo.recordDownloadBo;
import com.oh.record.domain.vo.ResponseVo;
import com.oh.record.mapper.RecordMapper;
import com.oh.record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 向导实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:43
 */
@Service("guideService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    /**
     * 下载文档
     * @param recordDownloadBo
     * @return
     */
    @Override
    public ResponseVo download(recordDownloadBo recordDownloadBo) {
        return null;
    }

    /**
     * 分页查询生成的文档
     * @param recordPagingToGetDataBo
     * @return
     */
    @Override
    public ResponseVo queryByPage(RecordPagingToGetDataBo recordPagingToGetDataBo) {
        return null;
    }

    /**
     * 生成文档
     * @param record
     * @return
     */
    @Override
    public ResponseVo insert(Record record) {

        return null;
    }

    /**
     * 删除Record数据
     * @param id
     * @return
     */
    @Override
    public ResponseVo deleteById(Long id) {
        return null;
    }
}
