package com.lanxiang.info.model;

import lombok.Data;
import java.util.Map;

/**
 * Created by lanxiang on 2016/11/25.
 */

@Data
public class SystemInfo {

    private Map<String, String> environmentMap;

    private Map<String, String> propertyMap;
}
