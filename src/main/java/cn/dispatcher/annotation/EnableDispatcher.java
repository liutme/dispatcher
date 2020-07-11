package cn.dispatcher.annotation;

import cn.dispatcher.config.DispatcherConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherConfiguration.class})
public @interface EnableDispatcher {

}
