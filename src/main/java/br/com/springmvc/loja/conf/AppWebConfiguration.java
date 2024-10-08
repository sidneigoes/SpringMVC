package br.com.springmvc.loja.conf;

import br.com.springmvc.loja.controllers.HomeController;
import br.com.springmvc.loja.daos.ProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses= {HomeController.class, ProductDao.class})
public class AppWebConfiguration {
    @Bean
    public InternalResourceViewResolver
    internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
