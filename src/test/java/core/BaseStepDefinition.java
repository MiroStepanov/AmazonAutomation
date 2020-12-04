package core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.time.LocalTime;


@ExtendWith(CustomParameterResolver.class)
public class BaseStepDefinition {
    protected WebApp webApp;

    @BeforeAll
    public void setup() {
        webApp = new WebApp();
        webApp.startBrowser(System.getProperty("browser"));
    }

    @AfterAll
    public void tearDown(ExtensionContext extensionContext) {
        if (System.getProperty("take.screenshots.enabled").equalsIgnoreCase("true")) {
            Method testMethod = extensionContext.getRequiredTestMethod();
            Boolean testFailed = extensionContext.getExecutionException().isPresent();
            if (testFailed) {
                webApp.takeScreenshot(testMethod.getDeclaringClass().getSimpleName(), testMethod.getName(), LocalTime.now());
            }
        }
        webApp.quit();
    }
}
