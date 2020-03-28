package com.test.util;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ToolUtil {

    public static boolean isEmpty(Object o){
        if(o == null){
            return true;
        }
        if(o instanceof String){
            if(o.toString().trim().equals("")){
                return true;
            }
        }else if(o instanceof List){
            if(((List) o).size()==0){
                return true;
            }
        }else if(o instanceof Map){
            if(((Map) o).size()==0){
                return true;
            }
        }else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;

    }

    /**
     * 获取项目路径
     */
    public static String getWebRootPath(String filePath) {
        try {
            String path = ToolUtil.class.getClassLoader().getResource("").toURI().getPath();
            path = path.replace("/WEB-INF/classes/", "");
            path = path.replace("/target/classes/", "");
            path = path.replace("file:/", "");
            if (ToolUtil.isEmpty(filePath)) {
                return path;
            } else {
                return path + "/" + filePath;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}