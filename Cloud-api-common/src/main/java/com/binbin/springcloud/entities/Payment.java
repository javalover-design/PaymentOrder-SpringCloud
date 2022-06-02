package com.binbin.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author binbin
 * @date 2022年06月02日  上午12:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable { //添加序列化接口

    private Long id;
    private String serial;

}
