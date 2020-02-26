package jp.gihyo.wbpress.advance.lib.activemq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class ActiveMQConfig {

  public static final String QUEUE_HATENA = "request-hatena-queue";
  
  public static final String QUEUE_QIITA = "request-qiita-queue";

  @Bean
  public JmsOperations jmsOperations( //
      ConnectionFactory connectionFactory, //
      MessageConverter jacksonJmsMessageConverter) {
    JmsTemplate template = new JmsTemplate();
    template.setConnectionFactory(connectionFactory);
    template.setMessageConverter(jacksonJmsMessageConverter);
    return template;
  }

  @Bean
  public JmsListenerContainerFactory<?> listenerContainerFactory( //
      ConnectionFactory connectionFactory, //
      MessageConverter jacksonJmsMessageConverter) { //
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(jacksonJmsMessageConverter);
    return factory;
  }
}
