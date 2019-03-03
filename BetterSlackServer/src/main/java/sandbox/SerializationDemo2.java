package sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SerializationDemo2 {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("John","Smith",12);
        Purchase purchase = new Purchase("laptop",5234.99);
        Purchase purchase2 = new Purchase("tablet",99994.99);
        Purchase purchase3 = new Purchase("smartfon",1124.99);
        person.addPurchase(purchase);
        //message.addPurchase(purchase2);
        //message.addPurchase(purchase3);
        for (int i = 0; i <3 ; i++) {
            person.addInteger(i+1);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        //objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        //objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        String serialized = objectMapper.writeValueAsString(person);
        System.out.println(serialized);
    }
}