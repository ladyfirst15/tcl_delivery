package TCL_20200831;

import TCL_20200831.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }



    @Autowired
    DeliveryRepository deliveryRepository;
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCooked_Ship(@Payload Cooked cooked){

        if(cooked.isMe()){
            System.out.println("##### listener Accept : " + cooked.toJson());

            Delivery delivery = new Delivery();
            delivery.setOrderId(cooked.getOrderId());
            delivery.setStatus("SHIPPED");

            deliveryRepository.save(delivery);
        }
    }

}
