package org.TraveLency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.TraveLency")
public class WebConfig {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(TilesView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    @Bean(name = "tilesConfigurer")
//    public TilesConfigurer getTilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//
//        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
//
//        return tilesConfigurer;
//    }
}
