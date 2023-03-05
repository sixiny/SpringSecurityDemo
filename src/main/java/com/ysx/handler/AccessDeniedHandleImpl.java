package com.ysx.handler;

import com.alibaba.fastjson.JSON;
import com.ysx.utils.ResponseResult;
import com.ysx.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/04/17:32
 * @Description: 验证权限不足异常处理
 */
@Component
public class AccessDeniedHandleImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        // 统一返回方式
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "您没有权限");
        String ans = JSON.toJSONString(result);
        WebUtils.renderString(httpServletResponse, ans);

    }
}
