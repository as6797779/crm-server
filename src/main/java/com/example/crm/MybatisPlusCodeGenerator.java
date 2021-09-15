package com.example.crm;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * 基于mybatisplus的代码生成类
 * 只使用一次
 */
@Deprecated
public class MybatisPlusCodeGenerator {


    public static void main(String[] args) {

        // 1、数据源配置
        DataSourceConfig.Builder dsc = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/crm","root","6797779");
        DataSourceConfig dataSourceConfig = dsc.build();

        // 2、创建代码生成器
        AutoGenerator mpg = new AutoGenerator(dataSourceConfig);


        // 3、全局配置
        GlobalConfig.Builder gc = new GlobalConfig.Builder();
        String projectPath = System.getProperty("user.dir");
        gc.outputDir(projectPath + "/src/main/java").author("lonely-top").openDir(false)
                .dateType(DateType.ONLY_DATE);
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor("zwq");
//        gc.setOpen(false); //生成后是否打开资源管理器
//        gc.setFileOverride(false); //重新生成时文件是否覆盖
//        gc.setServiceName("%sService"); //去掉Service接口的首字母I
//        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
//        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
//        gc.setSwagger2(false);//开启Swagger2模式
//
//        mpg.setGlobalConfig(gc);
        mpg.global(gc.build());



        // 4、包配置
        PackageConfig.Builder pc = new PackageConfig.Builder();
        pc.moduleName(null).parent("com.example.crm").controller("controller").entity("entity")
                .service("service").serviceImpl("service.impl").mapper("mapper");
//        pc.setModuleName(null); //模块名
//        pc.setParent("cn.zwq.mybatis-plus");
//        pc.setController("controller");
//        pc.setEntity("entity");
//        pc.setService("service");
//        pc.setMapper("mapper");
        mpg.packageInfo(pc.build());



        // 5、策略配置
        StrategyConfig.Builder strategy = new StrategyConfig.Builder();
        strategy.enableCapitalMode().enableSkipView()
                .entityBuilder().enableTableFieldAnnotation().naming(NamingStrategy.underline_to_camel).columnNaming(NamingStrategy.underline_to_camel)
                .controllerBuilder().enableHyphenStyle().enableRestStyle().build();
//        strategy.setInclude("user");//对那一张表生成代码
//        strategy.enableTableFieldAnnotation() 实体类添加表名注解
//        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
//
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
//        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
//
//        strategy.setRestControllerStyle(true); //restful api风格控制器
//        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.strategy(strategy.build());

        // 6、执行
        mpg.execute();
    }

}
