package co.com.heison_test.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_USER_TXT = Target.the("Input for user")
            .located(By.id("login:username"));

    public static final Target INPUT_PASSWORD_TXT = Target.the("Input for password")
            .located(By.id("login:password"));

    public static final Target BUTTON_LOGIN = Target.the("Button for login")
            .located(By.id("login:loginId"));

    public static final Target Ejemplo = Target.the("Ejemplo")
            .locatedBy("input[@id='input']/following-sibling::label");

    public static final Target Ejemplo_dos = Target.the("Ejemplo 2")
            .locatedBy("//*[@id='tbl_stations']//td[text()=' {0} ']//following::td[1]");
}
