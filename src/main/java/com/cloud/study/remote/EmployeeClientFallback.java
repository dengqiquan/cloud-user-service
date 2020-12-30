package com.cloud.study.remote;

import com.cloud.study.domain.EmployeeDto;
import com.cloud.study.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: dqq
 * @date: 2020/9/29 8:54
 */
@Slf4j
@Component
public class EmployeeClientFallback implements EmployeeClient {

    @Override
    public Response<EmployeeDto> getEpUserByName(Integer id) {
        Response response = new Response();
        response.failure("服务已熔断");
        System.out.println("**********************************************");
        return response;
    }
}
