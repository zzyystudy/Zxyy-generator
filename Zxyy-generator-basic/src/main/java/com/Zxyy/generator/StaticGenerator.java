package com.Zxyy.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.file.Path;

/**
 * 静态文件生成器
 */
public class StaticGenerator {

    public static void main(String[] args) {
        String Path = System.getProperty("user.dir");
        String srcPath = Path + File.separator + "yuzi-generator-demo-projects"+ File.separator +"acm-template";
        String destPath = Path + File.separator +"Zxyy-generator-basic";
        copyFilesByHutool(srcPath,destPath);
    }

    public static void copyFilesByHutool(String srcPath, String destPath){
        FileUtil.copy(srcPath, destPath, true);
    }
}
