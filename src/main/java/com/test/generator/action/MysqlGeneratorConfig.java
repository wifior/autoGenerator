package com.test.generator.action;

import java.io.File;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.test.generator.model.GenerateVo;
import com.test.util.StringUtil;
import com.test.util.ToolUtil;

public class MysqlGeneratorConfig extends AbstractGeneratorConfig {

    private GenerateVo generateVo;

    public MysqlGeneratorConfig(GenerateVo generateVo) {
        this.generateVo = generateVo;
    }

    @Override
    protected void config() {
        globalConfig();
        dataSourceConfig();
        strategyConfig();
        packageConfig();
        contextConfig();
    }

    protected void globalConfig() {
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+File.separator+ "src"+File.separator+"main"+File.separator+"java");
        globalConfig.setAuthor(generateVo.getAuthor());
        globalConfig.setOpen(false);
        globalConfig.setEnableCache(false);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setActiveRecord(false);
    }

    protected void dataSourceConfig() {
        // 数据源配置
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(generateVo.getUrl());
        dataSourceConfig.setDriverName(generateVo.getDriverClass());
        dataSourceConfig.setUsername(generateVo.getUserName());
        dataSourceConfig.setPassword(generateVo.getPassword());
    }

    protected void strategyConfig() {
        if(generateVo.getIgnoreTabelPrefix()!=null){
            strategyConfig.setTablePrefix(new String[]{generateVo.getIgnoreTabelPrefix()});
        }
        strategyConfig.setInclude(new String[]{generateVo.getTableName()});
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategyConfig.setSuperEntityClass("com.baomidou.mybatisplus.samples.generator.common.BaseEntity");
        //strategyConfig.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
    }

    protected void packageConfig() {
        packageConfig.setParent(null);
        //packageConfig.setParent("com.nineteen.modular");
        packageConfig.setEntity(generateVo.getProjectPackage()+".modular."+generateVo.getModuleName()+".model");
        packageConfig.setMapper(generateVo.getProjectPackage()+".modular."+generateVo.getModuleName()+".dao");
        packageConfig.setXml(generateVo.getProjectPackage()+".modular."+generateVo.getModuleName()+".mapping");
        packageConfig.setService(generateVo.getProjectPackage()+".modular."+generateVo.getModuleName()+".service");
        packageConfig.setServiceImpl(generateVo.getProjectPackage()+".modular."+generateVo.getModuleName()+".service.impl");
        packageConfig.setController(generateVo.getProjectPackage()+".modular."+generateVo.getModuleName()+".controller");
    }

    protected void contextConfig(){
        contextConfig.setProPackage(generateVo.getProjectPackage());
        contextConfig.setCoreBasePackage("");
        contextConfig.setBizChName(generateVo.getBizName());
        if(ToolUtil.isEmpty(generateVo.getIgnoreTabelPrefix())){
            String entityName = StringUtil.toCamelCase(generateVo.getTableName());
            contextConfig.setEntityName(StringUtil.firstCharToUpperCase(entityName));
            contextConfig.setBizEnName(StringUtil.firstCharToUpperCase(entityName));
        }else {
            String entityName = StringUtil.toCamelCase(StringUtil.removePrefix(generateVo.getTableName(),generateVo.getIgnoreTabelPrefix()));
            contextConfig.setEntityName(StringUtil.firstCharToUpperCase(entityName));
            contextConfig.setBizEnName(StringUtil.firstCharToUpperCase(entityName));
        }

        contextConfig.setControllerSwitch(generateVo.getControllerSwitch());
        contextConfig.setServiceSwitch(generateVo.getServiceSwitch());
        contextConfig.setEntitySwitch(generateVo.getEntitySwitch());
        contextConfig.setDaoSwitch(generateVo.getDaoSwitch());

    }
}
