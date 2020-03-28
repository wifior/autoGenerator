package com.test.generator.config;

/**
 * 全局配置
 */
public class ContextConfig {

    private String templatePrefixPath = "";
    private String projectPath = "";//模板输出的项目目录
    private String bizChName;   //业务名称
    private String bizEnName;   //业务英文名称
    private String bizEnBigName;//业务英文名称(大写)
    private String moduleName = "system";  //模块名称

    private String proPackage = "com.test";
    private String coreBasePackage = "com.test.core";
    private String modelPackageName = "com.test.model";        //model的包名
    private String modelMapperPackageName = "com.test.mapper";    //model的dao
    private String entityName;              //实体的名称

    private Boolean controllerSwitch = true;    //是否生成控制器代码开关
    private Boolean daoSwitch = true;           //dao
    private Boolean serviceSwitch = true;       //service
    private Boolean entitySwitch = true;        //生成实体的开关
    private Boolean sqlSwitch = true;           //生成sql的开关

    public void init() {
        if (entityName == null) {
            entityName = bizEnBigName;
        }
        modelPackageName = proPackage + ".modular."+ this.moduleName +".model";
        modelMapperPackageName = proPackage + ".modular."+ this.moduleName+".mapper";
    }

    public String getTemplatePrefixPath() {
        return templatePrefixPath;
    }

    public void setTemplatePrefixPath(String templatePrefixPath) {
        this.templatePrefixPath = templatePrefixPath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getBizChName() {
        return bizChName;
    }

    public void setBizChName(String bizChName) {
        this.bizChName = bizChName;
    }

    public String getBizEnName() {
        return bizEnName;
    }

    public void setBizEnName(String bizEnName) {
        this.bizEnName = bizEnName;
    }

    public String getBizEnBigName() {
        return bizEnBigName;
    }

    public void setBizEnBigName(String bizEnBigName) {
        this.bizEnBigName = bizEnBigName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getProPackage() {
        return proPackage;
    }

    public void setProPackage(String proPackage) {
        this.proPackage = proPackage;
    }

    public String getCoreBasePackage() {
        return coreBasePackage;
    }

    public void setCoreBasePackage(String coreBasePackage) {
        this.coreBasePackage = coreBasePackage;
    }

    public String getModelPackageName() {
        return modelPackageName;
    }

    public void setModelPackageName(String modelPackageName) {
        this.modelPackageName = modelPackageName;
    }

    public String getModelMapperPackageName() {
        return modelMapperPackageName;
    }

    public void setModelMapperPackageName(String modelMapperPackageName) {
        this.modelMapperPackageName = modelMapperPackageName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Boolean getControllerSwitch() {
        return controllerSwitch;
    }

    public void setControllerSwitch(Boolean controllerSwitch) {
        this.controllerSwitch = controllerSwitch;
    }

    public Boolean getDaoSwitch() {
        return daoSwitch;
    }

    public void setDaoSwitch(Boolean daoSwitch) {
        this.daoSwitch = daoSwitch;
    }

    public Boolean getServiceSwitch() {
        return serviceSwitch;
    }

    public void setServiceSwitch(Boolean serviceSwitch) {
        this.serviceSwitch = serviceSwitch;
    }

    public Boolean getEntitySwitch() {
        return entitySwitch;
    }

    public void setEntitySwitch(Boolean entitySwitch) {
        this.entitySwitch = entitySwitch;
    }

    public Boolean getSqlSwitch() {
        return sqlSwitch;
    }

    public void setSqlSwitch(Boolean sqlSwitch) {
        this.sqlSwitch = sqlSwitch;
    }
}