package co.com.heison_test.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {

    private Navigate() {}

    public static Performable theHeisonPage(){
        return Task.where("{0} Opens the Heison page",
                Open.browserOn().thePageNamed("Heison"));
    }
}
