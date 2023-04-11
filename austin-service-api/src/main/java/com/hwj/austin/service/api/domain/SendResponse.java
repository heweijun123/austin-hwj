package com.hwj.austin.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @Author: hwj
 * @CreateTime: 2023-04-11  16:28
 * @Version: 1.0
 * @Description: 发送接口返回值
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SendResponse {
    /**
     * 响应状态
     */
    private String code;

    /**
     * 响应编码
     */
    private String msg;

}
