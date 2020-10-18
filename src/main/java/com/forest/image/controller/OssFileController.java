package com.forest.image.controller;

import com.forest.image.base.ResultData;
import com.forest.image.dto.FileLinkDTO;
import com.forest.image.service.OSSFileService;
import com.forest.image.util.ResultDataUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 文件服务前端控制器
 *
 * @author Forest
 * @date 2020年03月21日 04:33
 */
@Api("文件接口")
@RestController
@RequestMapping("/ossfile")
public class OssFileController {
    @Autowired
    private OSSFileService ossFileService;

    /**
     * 文件上传
     *
     * @param request,file
     * @return
     * @author Forest
     * @date 2020/3/21 4:51 上午
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public ResultData<FileLinkDTO> upload(HttpServletRequest request, @RequestParam MultipartFile file) {
        return ResultDataUtils.getSuccessResult(ossFileService.upload(file, request.getRemoteAddr()));
    }

    /**
     * 删除文件
     *
     * @param map
     * @return
     * @author Forest
     * @date 2020/4/4 6:40 下午
     */
    @PostMapping("/delete")
    public ResultData delete(@RequestBody Map map) {
        ossFileService.delete(map);
        return ResultDataUtils.getSuccessResult();
    }

    /**
     * 文件查询
     * 
     * @param 
     * @return 
     * @author Forest
     * @date 2020/7/10 11:39
     */
    @PostMapping("/query")
    public ResultData query() {
        return ResultDataUtils.getSuccessResult(ossFileService.query());
    }
}
