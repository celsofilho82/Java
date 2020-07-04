package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Classe responsável por armazenar nossas configurações do banco de dados

// Para o Spring gerenciar as transações para nós, adicione a anotação 
@EnableTransactionManagement
public class JPAConfiguration {

	// Método será a responsável por configurar o framework, passando informações
	// relevantes como o banco a ser utilizado, seu usuário e senha, e assim por
	// diante:
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("job1034");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaProperties(properties);
		factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");

		return factoryBean;
	}

	// Método que criará o TransactionManager para que assim ele possa gerenciar as
	// transações de nossas entidades.
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
