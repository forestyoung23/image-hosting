package com.forest.image.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dongyang
 * @date 2021年01月23日 18:18
 */
@Data
@TableName("order_table")
public class OrderModel {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String orderName;

    private BigDecimal price;

    private Date orderDate;
}
