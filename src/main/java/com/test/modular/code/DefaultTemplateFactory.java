package com.test.modular.code;

import com.test.App;
import com.test.generator.model.GenerateVo;
import com.test.util.ToolUtil;

public class DefaultTemplateFactory {
    /**
     * 获取默认的参数
     */
    public static GenerateVo getDefaultParams(){
        GenerateVo generateVo = new GenerateVo();
        generateVo.setProjectPath(ToolUtil.getWebRootPath(null));
        generateVo.setAuthor("Think");
        generateVo.setProjectPackage(App.class.getPackage().getName());
        generateVo.setIgnoreTabelPrefix("pro_");
        generateVo.setModuleName("system");
        return generateVo;
    }
}
