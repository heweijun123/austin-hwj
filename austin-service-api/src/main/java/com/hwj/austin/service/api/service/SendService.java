package com.hwj.austin.service.api.service;

import com.hwj.austin.service.api.domain.BatchSendRequest;
import com.hwj.austin.service.api.domain.SendRequest;
import com.hwj.austin.service.api.domain.SendResponse;

/**
 * @Author: hwj
 * @CreateTime: 2023-04-11  16:28
 * @Version: 1.0
 * @Description: 发送接口
 */
public interface SendService {

    /**
     * 单文案发送接口
     *
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);


    /**
     * 多文案发送接口
     *
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);
}
