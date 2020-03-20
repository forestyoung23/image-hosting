package com.forest.image.controller;

import com.forest.image.dto.FileDTO;
import com.forest.image.service.CommonFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件服务前端控制器
 *
 * @author Forest
 * @date 2020年03月21日 04:33
 */
@RestController
@RequestMapping("/commonfile")
public class CommonFileController {
    @Autowired
    private CommonFileService commonFileService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/3/21 4:51 上午
     */
    @RequestMapping("/upload")
    public Object upload(@RequestBody FileDTO file) {
        return commonFileService.upload(file);
    }
}
