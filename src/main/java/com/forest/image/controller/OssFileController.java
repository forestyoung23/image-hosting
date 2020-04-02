package com.forest.image.controller;

import com.forest.image.base.ResultData;
import com.forest.image.service.OSSFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务前端控制器
 *
 * @author Forest
 * @date 2020年03月21日 04:33
 */
@RestController
@RequestMapping("/ossfile")
public class OssFileController {
    @Autowired
    private OSSFileService ossFileService;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @author Forest
     * @date 2020/3/21 4:51 上午
     */
    @PostMapping("/upload")
    public ResultData upload(@RequestParam MultipartFile file) {
        return ossFileService.upload(file);
    }
}
