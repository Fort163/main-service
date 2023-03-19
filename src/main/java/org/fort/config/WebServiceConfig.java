package org.fort.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
class WebServiceConfig  extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }


    //http://localhost:8099/ws/applications.wsdl
    @Bean(name = "applications")
    public DefaultWsdl11Definition defaultWsdl11Definition(CommonsXsdSchemaCollection applicationSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.fort.org/shemas/application");
        wsdl11Definition.setSchemaCollection(applicationSchema);
        return wsdl11Definition;
    }

    @Bean
    public CommonsXsdSchemaCollection applicationSchema() {
        //Порядок чтения схем важен не менять
        ClassPathResource base = new ClassPathResource("xsd\\base.xsd");
        ClassPathResource work = new ClassPathResource("xsd\\work.xsd");
        ClassPathResource user = new ClassPathResource("xsd\\user.xsd");
        ClassPathResource application = new ClassPathResource("xsd\\application.xsd");
        return new CommonsXsdSchemaCollection(base,work,user,application);
    }

}
