package com.Zxyy.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicGenerator {

    public static void main(String[] args) throws TemplateException, IOException {

        String Path = System.getProperty("user.dir");
        String inputPath = Path + "/Zxyy-generator-basic/src/main/resources/template/myweb.html.ftl";
        String outputPath = Path + "/Zxyy-generator-basic/src/main/resources/template/myweb.html";
        Map model = new HashMap();
        model.put("name","Zxyy");
        model.put("title","Zxyy");
        model.put("currentYear",2026);
        List<Map<String,String>> menuItems = new ArrayList<>();
        Map menuItem = new HashMap();
        menuItem.put("url","https://www.baidu.com");
        menuItem.put("label","百度");
        menuItems.add(menuItem);
        Map menuItem2 = new HashMap();
        menuItem2.put("url","https://www.google.com");
        menuItem2.put("label","谷歌");
        menuItems.add(menuItem2);
        model.put("menuItems",menuItems);

        doGenerator(inputPath,outputPath,model);

    }

    public static void doGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        //创建freemaker Configuration对象 参数为FreeMaker版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        //指定数字的显示
        cfg.setNumberFormat("0.######");

        //指定模板文件所在根路径
        File templateDir = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateDir);

        //设置字符集
        cfg.setDefaultEncoding("UTF-8");

        //创建模板对象加载指定模板
        String templateName = (new File(inputPath)).getName();
        Template template = cfg.getTemplate(templateName);

        Writer out = new FileWriter(outputPath);

        template.process(model,out);

        out.flush();
        out.close();
    }

}
