package com.test.modular.code.controller;

import com.test.generator.action.MysqlGeneratorConfig;
import com.test.generator.model.GenerateVo;
import com.test.modular.code.DefaultTemplateFactory;
import com.test.modular.common.controller.BaseController;
import com.test.properties.DruidProperties;
import com.test.modular.code.service.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/code")
public class CodeController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String PREFIX = "web";

    @Autowired
    private TableService tableService;

    @Autowired
    private DruidProperties druidProperties;

    @RequestMapping("")
    public String code(Model model){
        model.addAttribute("tables",tableService.getAllTables());
        model.addAttribute("params", DefaultTemplateFactory.getDefaultParams());
        return PREFIX+"/code";
    }

    @RequestMapping("generate")
    @ResponseBody
    public Object generate(GenerateVo generateVo){

        logger.info("生成结构体");

        generateVo.setUrl(druidProperties.getUrl());
        generateVo.setUserName(druidProperties.getUsername());
        generateVo.setPassword(druidProperties.getPassword());
        generateVo.setDriverClass(druidProperties.getDriverClassName());
        generateVo.setServiceSwitch(true);
        generateVo.setDaoSwitch(true);
        generateVo.setEntitySwitch(true);
        generateVo.setControllerSwitch(true);

        MysqlGeneratorConfig mysqlGeneratorConfig = new MysqlGeneratorConfig(generateVo);
        mysqlGeneratorConfig.doMpGeneration();
        return SUCCESS_TIP;

    }
}
