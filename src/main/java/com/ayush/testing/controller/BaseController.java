package com.ayush.testing.controller;

import com.ayush.testing.enums.ResponseStatus;
import com.ayush.testing.utils.CustomMessageSource;
import com.ayush.testing.utils.GlobalApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    private ResponseStatus SUCCESS_RESPONSE = ResponseStatus.SUCCESS;
    private ResponseStatus ERROR_RESPONSE = ResponseStatus.FAIL;

    @Autowired
    protected CustomMessageSource customMessageSource;

    public GlobalApiResponse successMessage(String message, Object data) {
        GlobalApiResponse response = new GlobalApiResponse();
        response.setStatus(SUCCESS_RESPONSE);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public GlobalApiResponse errorMessage(String message, Object data) {
        GlobalApiResponse response = new GlobalApiResponse();
        response.setStatus(ResponseStatus.FAIL);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
