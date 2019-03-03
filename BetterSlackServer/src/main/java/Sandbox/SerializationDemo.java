package Sandbox;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;

import java.io.IOException;

public class SerializationDemo{
    public static void main(String[] args) throws IOException {
        Message message = new Message("Hello");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        //objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        String serialized = objectMapper.writeValueAsString(message);
        System.out.println(serialized);


        Message deserialized = objectMapper.readValue(serialized,Message.class);
        System.out.println(deserialized.getTimestamp());
        System.out.println(deserialized.getTimestamp());
    }

}
