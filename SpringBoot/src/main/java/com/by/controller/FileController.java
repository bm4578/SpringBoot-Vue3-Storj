package com.by.controller;

import com.by.utils.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白也
 * @title
 * @date 2023/2/15 1:57 下午
 */
@Api(value = "/api", tags = {"接口转换"})
@RestController
@RequestMapping("/api")
public class FileController {
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "url", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "newName", value = "", required = true)
    })
    @ApiOperation(value = "传入接口", notes = "", httpMethod = "POST")
    @PostMapping
    public ResultModel URL(String url ,String newName){

        String newURL = url+"?download=1 -O " + newName;
        return ResultModel.ok(newURL);
    }
}
