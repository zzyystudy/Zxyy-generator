package com.Zxyy.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.Zxyy.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

@Command(name = "config", mixinStandardHelpOptions = true,
        description = "输出类中的信息")
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        //利用反射动态获取类中字段信息
        //使用hutool获取
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称:" + field.getName()+" 字段类型:" + field.getType());
        }
    }
}
