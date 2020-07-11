package cn.dispatcher.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "task.despatcher")
@Component
public class ConfigVo {

    private String name;

    private String link;

}
