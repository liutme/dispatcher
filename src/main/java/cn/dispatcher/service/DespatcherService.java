package cn.dispatcher.service;

import cn.dispatcher.vo.ConfigVo;

public class DespatcherService {

    public static void run(ConfigVo configVo) {
        System.out.println("自动执行");
        System.out.println(configVo);
    }
}
