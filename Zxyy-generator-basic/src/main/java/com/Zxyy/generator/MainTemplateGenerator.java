package com.Zxyy.generator;

import com.Zxyy.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainTemplateGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String Path = System.getProperty("user.dir");
        String srcPath = Path + File.separator + "yuzi-generator-demo-projects"+ File.separator +"acm-template";
        String destPath = Path + File.separator +"Zxyy-generator-basic";
        StaticGenerator.copyFilesByHutool(srcPath,destPath);
        String inputPath = Path + "/Zxyy-generator-basic/src/main/resources/template/MainTemplate.java.ftl";
        String outputPath = Path + "/Zxyy-generator-basic/acm-template/src/com/yupi/acm/MainTemplate.java";
        MainTemplateConfig model = new MainTemplateConfig();
        model.setAuthor("Zxyy");
        model.setLoop(false);
        DynamicGenerator.doGenerator(inputPath,outputPath,model);

    }
}
