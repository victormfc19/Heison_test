package co.com.heison_test.models;

import co.com.heison_test.models.builders.EmployeeDataBuilder;

public class Employee {

    private final String email;
    private final String password;

    public Employee(EmployeeDataBuilder employee){
        this.email = employee.getEmail();
        this.password = employee.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
