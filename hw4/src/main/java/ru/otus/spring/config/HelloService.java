package ru.otus.spring.config;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String helloTo(String name) {
        return String.format("Hello %s !!!", name);
    }
}
