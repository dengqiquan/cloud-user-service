package com.cloud.study.remote;

import com.cloud.study.domain.EmployeeDto;
import com.study.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cloud-employee-service",fallback = EmployeeClientFallback.class,url = "http://localhost:9004")
public interface EmployeeClient {

    @GetMapping("find/employee/{id}")
    Response<EmployeeDto> getEpUserByName(@PathVariable("id") Integer id);
}
