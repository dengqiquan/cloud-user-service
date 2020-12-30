package com.cloud.study.controller;

import com.cloud.study.domain.EmployeeDto;
import com.cloud.study.domain.HrDto;
import com.cloud.study.domain.HrSearch;
import com.cloud.study.domain.Response;
import com.cloud.study.remote.EmployeeClient;
import com.cloud.study.service.HrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
*  generated by AddClassPlugin plugin
*/

@RestController
public class HrController extends BaseController {

    @Resource
    private HrService hrService;

    @Resource
    private EmployeeClient employeeClient;
    /**
    * 新增
    * @param hrDto
    * @return
    */
    @PostMapping("/add")
    public Response addHr(@RequestBody HrDto hrDto) {
        hrService.addHr(hrDto);
        return success(Boolean.TRUE);
    }

    /**
     * 新增
     * @param
     * @return
     */
    @GetMapping("/find/by/{id}")
    public Response addHr(@PathVariable("id") Integer id) {
        HrDto hrDto = hrService.findById(id);
        return success(hrDto);
    }

    @GetMapping("getUser/by/name")
    public <T> Response<T> getUserByName(@RequestParam("userName") String username){
        HrSearch hrSearch = new HrSearch();
        hrSearch.setUserName(username);
        List<HrDto> hrList = hrService.searchByHrSearch(hrSearch);
        return (Response<T>) success(hrList.isEmpty() ? null : hrList.get(0));

    }

    @GetMapping("remote/by/{id}")
    public Response getUserByName(@PathVariable("id") Integer id){
        Response<EmployeeDto> response = employeeClient.getEpUserByName(id);
        return  success(response.getData() == null ? null : response.getData());

    }

}