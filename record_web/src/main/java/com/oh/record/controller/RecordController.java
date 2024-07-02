package com.oh.record.controller;

import com.alibaba.fastjson2.JSONArray;
import com.oh.record.domain.Record;
import com.oh.record.domain.bo.RecordPagingToGetDataBo;
import com.oh.record.domain.bo.WordUrlBo;
import com.oh.record.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

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
     *
     * @param wordUrl
     * @return
     */
    @GetMapping(value ="/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ApiOperation("下载文档")
    public ResponseEntity<byte[]> download(@RequestParam String wordUrl) throws IOException {

        File file = new File("d:\\Desktop\\show\\template\\" + wordUrl);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        wordUrl = URLEncoder.encode(wordUrl, "UTF-8");
        headers.setContentDispositionFormData("attachment", wordUrl);

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);

//        return recordService.getWord(wordUrl);
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
    public String generate(@RequestBody Record record) throws IOException {
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

