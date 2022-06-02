package com.binbin.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author binbin
 * @date 2022年06月02日  上午12:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    /**可能存在只返回code和message，不返回信息*/
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
