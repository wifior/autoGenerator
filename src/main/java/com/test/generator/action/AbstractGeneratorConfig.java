package com.test.generator.action;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.test.generator.config.ContextConfig;

import java.util.List;

public abstract class AbstractGeneratorConfig {
    public AbstractGeneratorConfig() {
    }

    //mybatis-plus代码生成配置
    GlobalConfig globalConfig = new GlobalConfig();

    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    StrategyConfig strategyConfig = new StrategyConfig();

    PackageConfig packageConfig = new PackageConfig();

    TableInfo tableInfo = null;

    ContextConfig contextConfig = new ContextConfig();

    protected abstract void config();
    public void init(){
        config();
    }

    public void destory(){
        String outputDir = globalConfig.getOutputDir()+"/TTT";
        // FileUtil
    }

    public void doMpGeneration(){
        init();
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
        destory();

        List<TableInfo> tableInfoList = autoGenerator.getConfig().getTableInfoList();
        if(tableInfoList!=null&&tableInfoList.size()>0){
            this.tableInfo = tableInfoList.get(0);
        }
    }

    public void doWebGeneration(){

    }
}
