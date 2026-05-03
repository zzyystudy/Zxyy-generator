package com.Zxyy.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.Zxyy.generator.DynamicGenerator;
import com.Zxyy.generator.StaticGenerator;
import com.Zxyy.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "generate", mixinStandardHelpOptions = true,
        description = "拷贝文件命令")
@Data
public class GenerateCommand implements Callable<Integer> {
    /**
     * 模板作者空位
     */
    @CommandLine.Option(names = {"-a", "--author"},
            description = "作者信息",arity = "0..1",prompt = "请输入作者姓名: ",
            interactive = true,echo = true)
    private String author;
    /**
     * 模板是否循环空位
     */
    @CommandLine.Option(names = {"-l", "--loop"},
            description = "是否循环",arity = "0..1",prompt = "请输入程序是否循环: ",
            interactive = true,echo = true)
    private boolean loop;


    @Override
    public Integer call() throws Exception {
        String Path = System.getProperty("user.dir");
        String srcPath = Path + File.separator + "yuzi-generator-demo-projects"+ File.separator +"acm-template";
        String destPath = Path + File.separator +"Zxyy-generator-basic";
        StaticGenerator.copyFilesByHutool(srcPath,destPath);
        String inputPath = Path + "/Zxyy-generator-basic/src/main/resources/template/MainTemplate.java.ftl";
        String outputPath = Path + "/Zxyy-generator-basic/acm-template/src/com/yupi/acm/MainTemplate.java";
        MainTemplateConfig model = new MainTemplateConfig();
        BeanUtil.copyProperties(this,model);
        /*model.setLoop(loop);
        model.setAuthor(author);*/
        DynamicGenerator.doGenerator(inputPath,outputPath,model);
        return 0;
    }
}
