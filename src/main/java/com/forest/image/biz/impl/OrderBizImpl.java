package com.forest.image.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forest.image.biz.OrderBiz;
import com.forest.image.mapper.OrderMapper;
import com.forest.image.model.OrderModel;
import org.springframework.stereotype.Service;

/**
 * @author dongyang
 * @date 2021年01月23日 21:50
 */
@Service
public class OrderBizImpl extends ServiceImpl<OrderMapper, OrderModel> implements OrderBiz {
}
