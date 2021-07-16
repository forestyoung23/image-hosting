package com.forest.image;

import com.forest.image.service.OSSFileService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author dongyang
 * @date 2021年01月23日 22:22
 */
@SpringBootTest
class ImageApplicationTest {
    @Resource
    private OSSFileService ossFileService;

    @Test
    void contextLoads() {
        ossFileService.query();
    }

}