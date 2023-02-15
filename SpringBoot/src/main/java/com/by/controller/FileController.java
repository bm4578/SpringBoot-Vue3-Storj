package com.by.controller;

import com.by.utils.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白也
 * @title
 * @date 2023/2/15 1:57 下午
 */
@Api(value = "/api", tags = {""})
@RestController
@RequestMapping("/api")
public class FileController {
    @ApiOperation(value = "测试", notes = "", httpMethod = "GET")
    @GetMapping
    public String test(){
        return "hello";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "url", value = "", required = true)
    })
    @ApiOperation(value = "传入接口", notes = "", httpMethod = "POST")
    @PostMapping
    public ResultModel URL(String url){
        return ResultModel.ok(url);
    }
}
