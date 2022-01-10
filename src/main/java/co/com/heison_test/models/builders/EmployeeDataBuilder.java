package co.com.heison_test.models.builders;
import co.com.heison_test.models.Employee;

public class EmployeeDataBuilder implements Builder<Employee> {

    private String email;
    private String password;

    @Override
    public Employee build() {
        return new Employee(this);
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public EmployeeDataBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public EmployeeDataBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public Employee victor(){
        withEmail("vflorez@tcs.com");
        withPassword("10071020062000");
        return build();
    }

    public static EmployeeDataBuilder withEmployeeCalled(){
        return new EmployeeDataBuilder();
    }
}
