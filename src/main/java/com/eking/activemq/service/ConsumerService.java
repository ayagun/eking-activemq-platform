package com.eking.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

   /* @JmsListener(destination = "mytest.queue1", containerFactory="queueListenerFactory")
    @SendTo("out.queue1")
    public String receiveQueue1(String text) {
        System.out.println("Consumer收到的mytest.queue1队列为:"+text);
        return "return queue1 "+text;
    }
    @JmsListener(destination = "mytest.queue2", containerFactory="queueListenerFactory")
    @SendTo("out.queue2")
    public String receiveQueue2(String text) {
        System.out.println("Consumer收到的mytest.queue2队列为:"+text);
        return "return queue2 "+text;
    }

    @JmsListener(destination = "mytest.topic1", containerFactory="topicListenerFactory")
    @SendTo("out.topic1")
    public String receiveTopic1(String text) {
        System.out.println("Consumer收到的mytest.topic1主题为:"+text);
        return "return topic1 "+text;
    }

    @JmsListener(destination = "mytest.topic2", containerFactory="topicListenerFactory")
    @SendTo("out.topic2")
    public String receiveTopic2(String text) {
        System.out.println("Consumer收到的mytest.topic2主题为:"+text);
        return "return topic2 "+text;
    }*/
/*    @JmsListener(destination="Consumer.A.VirtualTopic.test", containerFactory="queueListenerFactory")
    public void consumerA1Topic(TextMessage text) throws JMSException {
        System.out.println("ConsumerA1收到的主题为:"+text.getText());
    }

    @JmsListener(destination="Consumer.A.VirtualTopic.test", containerFactory="queueListenerFactory")
    public void consumerA2Topic(TextMessage text) throws JMSException {
        System.out.println("ConsumerA2收到的主题为:"+text.getText());
    }

    @JmsListener(destination="Consumer.B.VirtualTopic.test", containerFactory="queueListenerFactory")
    public void consumerB1Topic(TextMessage text) throws JMSException {
        System.out.println("ConsumerB1收到的主题为:"+text.getText());
    }*/
   @JmsListener(destination = "mytest.queue1", containerFactory="queueListenerFactory")
    //@SendTo("out.queue1")    mytest.queue1
    public void receiveQueue1(String text) {
        System.out.println("Consumer收到的mytest.queue1队列为:"+text);
    }
/*      @JmsListener(destination = "mytest.queue2", containerFactory="queueListenerFactory")
     //@SendTo("out.queue1")
     public void receiveQueue2(String text) {
         System.out.println("Consumer收到的mytest.queue2队列为:"+text);
     }*/
    /*  @JmsListener(destination = "mytest.queue3", containerFactory="queueListenerFactory")
      //@SendTo("out.queue1")
      public void receiveQueue3(String text) {
          System.out.println("Consumer收到的mytest.queue3队列为:"+text);
      }*/
    @JmsListener(destination = "mytest.topic1", containerFactory="topicListenerFactory")
    //@SendTo("out.queue1")
    public void receiveTopic1(String text) {
        System.out.println("Consumer订阅的mytest.topic1主题为:"+text);
    }

/*    @JmsListener(destination = "IN.FSS2.FIDS", containerFactory="topicListenerFactory")
    //@SendTo("out.queue1")
    public void receiveTopic11(String text) {
        System.out.println("Consumer订阅的mytest.topic11主题为:"+text);
    }*/
}
