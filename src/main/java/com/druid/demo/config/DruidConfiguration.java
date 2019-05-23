package com.druid.demo.config;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {

  @Bean
  public ServletRegistrationBean druidStatViewServlet() {
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
        new StatViewServlet(), "/druid/*");
    // ������(Ϊ�ձ�ʾ,���еĶ����Է���,���IP��ʱ���ö��Ÿ���)
    servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
    // IP������ (���ڹ�ͬʱ��deny������allow)
    servletRegistrationBean.addInitParameter("deny", "127.0.0.2");
    // ���õ�¼���û���������
    servletRegistrationBean.addInitParameter("loginUsername", "pancm");
    servletRegistrationBean.addInitParameter("loginPassword", "123456");
    // �Ƿ��ܹ���������.
    servletRegistrationBean.addInitParameter("resetEnable", "false");
    return servletRegistrationBean;
  }


  @Bean
  public FilterRegistrationBean druidStatFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(
        new WebStatFilter());
    // ��ӹ��˹���
    filterRegistrationBean.addUrlPatterns("/*");
    // ��Ӳ���Ҫ���Եĸ�ʽ��Ϣ
    filterRegistrationBean.addInitParameter("exclusions",
        "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    System.out.println("druid��ʼ���ɹ�!");
    return filterRegistrationBean;

  }
}
