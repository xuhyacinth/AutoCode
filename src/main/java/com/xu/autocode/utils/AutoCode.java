package com.xu.autocode.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**  
 * All rights Reserved, Designed By Hyacinth
 *
 * @Title: AutoCode.java   
 * @Package com.xu.myabtis.utils   
 * @Description: 
 * @author: hyacinth
 * @date: 2021年6月14日 上午10:17:41   
 * @version V1.0 
 * @Copyright: 
 */
public class AutoCode {
	
	public static void main(String[] args) {
		auto();
	}
	
	public static void auto() {

		// 1、创建代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 2、全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("F:\\MpGenenator");
		gc.setAuthor("hyacinth");
		gc.setOpen(true); //生成后是否打开资源管理器
		gc.setFileOverride(true); //重新生成时文件是否覆盖
		gc.setServiceName("%sService");	//去掉Service接口的首字母I
		//gc.setIdType(IdType.ID_WORKER_STR); //主键策略
		gc.setDateType(DateType.SQL_PACK);//定义生成的实体类中日期类型
		gc.setSwagger2(true);//开启Swagger2模式
		gc.setEnableCache(false);

		gc.setBaseColumnList(true);
		gc.setBaseResultMap(true);
		
		mpg.setGlobalConfig(gc);

		// 3、数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://192.168.0.6:3306/spring?allowPublicKeyRetrieval=true&useUnicode=true&useSSL=false&characterEncoding=utf8");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("123456");
		dsc.setDbType(DbType.MYSQL);
		mpg.setDataSource(dsc);

		// 4、包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.xu.eureka");
		pc.setModuleName("client");
		pc.setController("controller");
		pc.setEntity("entity");
		pc.setService("service");
		pc.setMapper("mapper");
		pc.setXml("mapper.xml");
		mpg.setPackageInfo(pc);

		// 5、策略配置
		StrategyConfig strategy = new StrategyConfig();
		//strategy.setInclude("user");//对那一张表生成代码
		strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
		strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
		
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
		strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

		strategy.setRestControllerStyle(true); //restful api风格控制器
		strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

		mpg.setStrategy(strategy);

		// 6、执行
		mpg.execute();
	}
}

