package com.Zxyy;

import com.Zxyy.cli.ControllerCommand;

public class Main {
    public static void main(String[] args) {
        //args = new String[]{"config"};
        //args = new String[]{"generate","-a","-l"};
        //args = new String[]{"list"};
        ControllerCommand controllerCommand = new ControllerCommand();
        controllerCommand.doExcute(args);
    }
}
