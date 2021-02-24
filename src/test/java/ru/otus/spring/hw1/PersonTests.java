package ru.otus.spring.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.hw1.dao.Person;
import ru.otus.spring.hw1.dao.PersonImpl;

@DisplayName("Класс Person")
public class PersonTests {

    @DisplayName("Проверка работы конструктора.")
    @Test
    public void checkConstructor() {
        Person person = new PersonImpl("Ivan");
        Assertions.assertEquals("Ivan", person.getName());
    }
}
