package com.forest.image.controller;

import cn.hutool.core.util.IdUtil;
import com.forest.image.base.ResultData;
import com.forest.image.biz.OrderBiz;
import com.forest.image.mapper.CommonFileMapper;
import com.forest.image.model.OrderModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author dongyang
 * @date 2021年01月23日 22:23
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private OrderBiz orderBiz;
    @Resource
    private CommonFileMapper commonFileMapper;
    @PostMapping("/test")
    public ResultData test() {
        Date date = new Date();
        BigDecimal bigDecimal = new BigDecimal("19");
        ArrayList<OrderModel> list = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        for (int i = 0; i < 4000000; i++) {
            OrderModel model = new OrderModel();
            calendar.setTime(date);
            calendar.add(Calendar.SECOND, i);
            model.setPrice(bigDecimal);
            model.setOrderName(IdUtil.simpleUUID());
            model.setOrderDate(calendar.getTime());
            list.add(model);

        }
        orderBiz.saveBatch(list);
//        CommonFileModel model = new CommonFileModel();
//        model.setCreateTime(new Date());
//        model.setFileId("234");
//        model.setFileUrl("123");
//        model.setIp("123");
//        model.setCreator("123");
//        model.setFileName("23");
//        model.setFileType("23");
//        commonFileMapper.insert(model);
        return null;
    }
}
