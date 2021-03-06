import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.spring.service.QuestionsLoaderService;
import ru.otus.spring.service.QuestionsLoaderServiceImpl;

@SpringBootTest(
        classes = {QuestionsLoaderServiceImpl.class},
        properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class ApplicationTests {

    @Test
    void contextLoads() {
        Resource resource = new DefaultResourceLoader().getResource("classpath:/questions.csv");
        QuestionsLoaderService questionsLoaderService = new QuestionsLoaderServiceImpl(resource);
        Assertions.assertEquals(5, questionsLoaderService.getRawQuestions().size());
    }

}
