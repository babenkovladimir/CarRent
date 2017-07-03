package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Владимир on 28.06.2017.
 */
@Configuration
public class JspConfig {

    @Bean
    public InternalResourceViewResolver getViewResolwer(){
        // Где искать jsp файлы
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
