package cn.dispatcher.config;

import cn.dispatcher.service.DespatcherService;
import cn.dispatcher.vo.ConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties({ConfigVo.class})
@ComponentScan(basePackages = {"cn.dispatcher.*"})
public class DispatcherConfiguration {

    @Autowired
    private ConfigVo configVo;

    @PostConstruct
    public void init() {
        DespatcherService.run(configVo);
    }
}
