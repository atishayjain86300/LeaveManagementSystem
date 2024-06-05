import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String email;
    private int leaveBalance;

    public Employee(String name, String email, int leaveBalance) {
        this.name = name;
        this.email = email;
        this.leaveBalance = leaveBalance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}

class LeaveRequest {
    private Employee employee;
    private int leaveDays;
    private boolean approved;

    public LeaveRequest(Employee employee, int leaveDays) {
        this.employee = employee;
        this.leaveDays = leaveDays;
        this.approved = false;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}

public class LeaveManagementSystem {
    private List<Employee> employees;
    private List<LeaveRequest> leaveRequests;

    public LeaveManagementSystem() {
        this.employees = new ArrayList<>();
        this.leaveRequests = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void submitLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequests.add(leaveRequest);
    }

    public void approveLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequest.setApproved(true);
        Employee employee = leaveRequest.getEmployee();
        employee.setLeaveBalance(employee.getLeaveBalance() - leaveRequest.getLeaveDays());
    }

    public void rejectLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequest.setApproved(false);
    }

    public void displayLeaveBalances() {
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName() + ", Leave Balance: " + employee.getLeaveBalance());
        }
    }

    public static void main(String[] args) {
        LeaveManagementSystem system = new LeaveManagementSystem();

        Employee employee1 = new Employee("Atishay Jain", "atishay@gmail.com", 20);
        Employee employee2 = new Employee("Ashish Jain",  "ashish@gmail.com", 15);

        system.addEmployee(employee1);
        system.addEmployee(employee2);

        LeaveRequest leaveRequest1 = new LeaveRequest(employee1, 5);
        LeaveRequest leaveRequest2 = new LeaveRequest(employee2, 3);

        system.submitLeaveRequest(leaveRequest1);
        system.submitLeaveRequest(leaveRequest2);

        system.approveLeaveRequest(leaveRequest1);
        system.rejectLeaveRequest(leaveRequest2);

        system.displayLeaveBalances();
}
}
