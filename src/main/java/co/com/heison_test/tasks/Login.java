package co.com.heison_test.tasks;

import co.com.heison_test.models.Employee;
import static co.com.heison_test.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


public class Login implements Task {
    private final Employee employee;

    public Login(Employee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(employee.getEmail()).into(INPUT_USER_TXT),
                WaitUntil.the(INPUT_PASSWORD_TXT, isEnabled()).forNoMoreThan(15).seconds(),
                Enter.theValue(employee.getPassword()).into(INPUT_PASSWORD_TXT),
                WaitUntil.the(BUTTON_LOGIN, isClickable()),
                Click.on(BUTTON_LOGIN)
        );
    }

    public static Login inTheApp(Employee employee){
        return Tasks.instrumented(Login.class, employee);
    }
}
