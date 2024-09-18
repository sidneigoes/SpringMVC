package br.com.springmvc.loja.conf;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]
                {"br.com.casadocodigo.loja.models"});
        JpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl
                ("jdbc:mysql://localhost:3306/casadocodigo");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }
}
