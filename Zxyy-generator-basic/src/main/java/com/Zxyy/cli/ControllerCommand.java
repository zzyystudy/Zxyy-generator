package com.Zxyy.cli;


import com.Zxyy.cli.command.ConfigCommand;
import com.Zxyy.cli.command.GenerateCommand;
import com.Zxyy.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "controller", mixinStandardHelpOptions = true, version = "Zxyy 4.0",
        description = "全局命令控制")
public class ControllerCommand implements Callable<Integer> {
    private final CommandLine commandLine;

    //如果每次都要初始化的内容可以写在这个代码块中进行初始化
    {
      commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public Integer call() throws Exception {
        //不输入命令时给出提示
        System.out.println("请输入命令 或者使用--help获取帮助");
        return 0;
    }

    public Integer doExcute(String[] args) {
        return commandLine.execute(args);
    }
}
