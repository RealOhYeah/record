package com.oh.record.service.impl;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.Texts;
import com.oh.record.domain.Record;
import com.oh.record.domain.bo.RecordPagingToGetDataBo;
import com.oh.record.domain.vo.RecordPagingToDataVo;
import com.oh.record.domain.vo.RecordPagingToGetDataVo;
import com.oh.record.domain.vo.ResponseVo;
import com.oh.record.mapper.RecordMapper;
import com.oh.record.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * 文档实现类
 *
 * @author Oh...Yeah!!!
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Value("${filePath}")
    private String path;


    /**
     * 分页查询生成的文档
     * @param recordPagingToGetDataBo
     * @return
     */
    @Override
    public ResponseVo queryByPage(RecordPagingToGetDataBo recordPagingToGetDataBo) {
        Record record = recordPagingToGetDataBo.getRecord();
        if (record == null){
            record = new Record();
        }

        List<RecordPagingToDataVo> fileList = recordMapper.recordPagingToGetUserData(recordPagingToGetDataBo.getStart(),recordPagingToGetDataBo.getSize(),record);
        Long count = recordMapper.getCount(record);

        return new ResponseVo("查询成功",new RecordPagingToGetDataVo(fileList,Math.toIntExact(count)),"0x200");
    }

    /**
     * 生成文档
     * @param record
     * @return
     */
    @Override
    public ResponseVo insert(Record record) throws IOException {

        File file = new File(path +"textTemplate.docx" );

        if (!file.exists() || file.length() == 0) {
            throw new FileNotFoundException("文件不存在或为空，请检查文件路径和内容");
        }
        //加载模板
        XWPFTemplate template = XWPFTemplate.compile(file);
        //填充数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("text1", Texts.of(record.getContent()).color("000000").bold().create());
        //渲染数据
        template.render(map);
        //以文件形式输出
        template.writeAndClose(new FileOutputStream(path + record.getName()+"."+record.getType()));

        //将数据插入数据库
        recordMapper.insert(record);

        return new ResponseVo("成功生成", record,"0x200");
    }

    /**
     * 根据Id删除Record数据
     * @param id
     * @return
     */
    @Override
    public ResponseVo deleteById(Long id) {
        Long numbersOfOpetion = recordMapper.deleteById(id);
        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");
    }

    /**
     * 文档下载
     *
     * @param wordUrl
     * @return
     */
    @Override
    public ResponseEntity<byte[]> getWord(String wordUrl) throws IOException {

        File file = new File("d:\\Desktop\\show\\template\\" + wordUrl);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());

        // 构建响应头，设置Content-Type为application/vnd.openxmlformats-officedocument.wordprocessingml.document
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", wordUrl);

        // 设置字符编码为UTF-8
        headers.set(HttpHeaders.CONTENT_ENCODING, "UTF-8");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
