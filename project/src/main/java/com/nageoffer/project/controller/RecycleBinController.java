package com.nageoffer.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nageoffer.admin.common.convention.result.Result;
import com.nageoffer.admin.common.convention.result.Results;
import com.nageoffer.project.dto.req.RecycleBinSaveReqDTO;
import com.nageoffer.project.dto.req.ShortLinkPageReqDTO;
import com.nageoffer.project.dto.resp.ShortLinkPageRespDTO;
import com.nageoffer.project.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站管理控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam){
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }
    /**
     * 分页查询回收站短链接
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return Results.success(recycleBinService.pageShortLink(requestParam));
    }
}