package ru.otus.spring.shell;

import org.springframework.context.annotation.Import;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.service.TestingService;
import ru.otus.spring.service.TestingServiceImp;

@Import(TestingServiceImp.class)
@ShellComponent
public class TestingServiceShell {
    private final TestingService testingServiceImpl;

    public TestingServiceShell(TestingService testingServiceImpl) {
        this.testingServiceImpl = testingServiceImpl;
    }

    @ShellMethod(key = "register", value = "Please, enter register to start user registration.")
    public void  registerUser() {
        testingServiceImpl.registerUser();
    }

    @ShellMethod(key = "start", value = "Enter to start exam.")
    public void startExam() {
        testingServiceImpl.startExam();
    }

    @ShellMethod(key = "results", value = "Enter command to show exam results.")
    public void showResults() {
        testingServiceImpl.showResults();
    }
}