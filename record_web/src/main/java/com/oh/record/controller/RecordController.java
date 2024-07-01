package com.oh.record.controller;

import com.alibaba.fastjson2.JSONArray;
import com.oh.record.domain.Record;
import com.oh.record.domain.bo.RecordPagingToGetDataBo;
import com.oh.record.domain.bo.recordDownloadBo;
import com.oh.record.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Record
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-1 17:35:24
 */
@RestController
@Api(value = "Record版块接口",tags = {"Record版块接口"})
@RequestMapping(value = "record", produces = "text/plain;charset=UTF-8")
public class RecordController {
    /**
     * 服务对象
     */
    @Resource
    private RecordService recordService;

    /**
     * 下载文档
     * @param recordDownloadBo
     * @return
     */
    @PostMapping("/download")
    @ApiOperation("下载Record数据")
    public String download(@RequestBody recordDownloadBo recordDownloadBo) {

        return JSONArray.toJSONString(recordService.download(recordDownloadBo));
    }

    /**
     * 分页查询生成的文档
     * @param recordPagingToGetDataBo
     * @return
     */
    @PostMapping("/queryByPage")
    @ApiOperation("分页查询Record数据")
    public String queryByPage(@RequestBody RecordPagingToGetDataBo recordPagingToGetDataBo) {

        return JSONArray.toJSONString(recordService.queryByPage(recordPagingToGetDataBo));
    }

    /**
     * 生成文档
     * @param record
     * @return
     */
    @PostMapping("/generate")
    @ApiOperation("新增Record数据")
    public String generate(@RequestBody Record record) {
        return JSONArray.toJSONString(recordService.insert(record));
    }


    /**
     * 删除Record数据
     * @param id
     * @return
     */
    @PostMapping("/deleteById")
    @ApiOperation("根据id删除Record数据")
    public String deleteById(@RequestParam("id")  Long id) {
        return JSONArray.toJSONString(recordService.deleteById(id));
    }


}

