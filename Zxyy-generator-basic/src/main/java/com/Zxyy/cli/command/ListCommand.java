package com.Zxyy.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

@Command(name = "list", mixinStandardHelpOptions = true,
        description = "打印所有需要拷贝的文件")
public class ListCommand implements Runnable{
    @Override
    public void run() {
        String Path = System.getProperty("user.dir");
        String srcPath = Path + File.separator + "yuzi-generator-demo-projects"+ File.separator +"acm-template";
        List<File> files = FileUtil.loopFiles(srcPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
