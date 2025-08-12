package com.info.configdemo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BuildInfoController {

//    @Value("${build.id:default}")
//    private String buildId;
//
//    @Value("${build.version:default}")
//    private String buildVersion;
//
//    @Value("${build.name:default}")
//    private String buildName;

    private BuildInfo buildInfo;

    @GetMapping("/build-info")
    public String getBuildInfo(){
//        return "Build Id: "+ buildId + ", Version: "+ buildVersion + ", Name: " + buildName;
        return "Build Id: "+ buildInfo.getId() + ", Version: "+ buildInfo.getVersion() + ", Name: " + buildInfo.getName();
    }

}
