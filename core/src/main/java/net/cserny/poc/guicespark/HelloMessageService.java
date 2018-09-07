package net.cserny.poc.guicespark;

import com.google.inject.Singleton;

import java.time.LocalDateTime;

@Singleton
public class HelloMessageService {

    public HelloMessage sayHello() {
        return new HelloMessage("Hello Spark!", LocalDateTime.now());
    }
}
