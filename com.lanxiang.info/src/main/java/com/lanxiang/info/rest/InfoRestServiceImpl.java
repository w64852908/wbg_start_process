package com.lanxiang.info.rest;

import com.lanxiang.info.model.SystemInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanxiang on 2016/11/15.
 */

@Slf4j
@Singleton
@Path("info")
@Api(value = "info", description = "各种信息")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class InfoRestServiceImpl {

    private SimpleDateFormat format;

    @PostConstruct
    public void init() {
        format = new SimpleDateFormat("yyyy-MM-dd");
        log.info("InfoRestServiceImpl constructed.");
    }

    @GET
    @Path("now")
    @ApiOperation("获取当前时间")
    public String getCurrentTime() {
        return format.format(new Date());
    }

    @GET
    @Path("system")
    @ApiOperation("获取系统环境")
    public SystemInfo getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setEnvironmentMap(System.getenv());
        Map<String, String> propertyMap = new HashMap<>();
        for (Object key : System.getProperties().keySet()) {
            String value = System.getProperties().get(key).toString();
            propertyMap.put(key.toString(), value);
        }
        systemInfo.setPropertyMap(propertyMap);
        return systemInfo;
    }
}
