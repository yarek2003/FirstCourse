package Hard;

public class EmployeeBook {
    private final Employee[] employees;
    public EmployeeBook(int size){
        this.employees = new Employee[size];
    }

    public void toPrint(){
        System.out.println("Книга сотрудников компании:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public float sumPerMonth(){
        float sumPerMonth = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sumPerMonth = sumPerMonth + employee.getSalary();
            }
        }
        return sumPerMonth;
    }
    public void minSalary(){
        float minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) minSalary = employee.getSalary();
        }
        System.out.println("Самая низкая зарплата в компании: " + minSalary);
    }
    public void maxSalary(){
        float maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) maxSalary = employee.getSalary();
        }
        System.out.println("Самая высокая зарплата в компании: " + maxSalary);
    }
    public float averageSalary(){
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) count++;
        }
        return sumPerMonth()/count;
    }
    public void toPrintFio(){
        System.out.println("ФИО сотрудников компании:");
        String toPrintFio = "";
        for (Employee employee : employees) {
            if (employee != null) {
                toPrintFio = employee.getFirstName() + " " + employee.getLastName() + " " + employee.getMiddleName();
                System.out.println(toPrintFio);
            }
        }
    }
    public void boostSalary(float coefficient){
        System.out.println("Зарплата после индексации на " + coefficient + "%:");
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(coefficient / 100 * employee.getSalary() + employee.getSalary());
                System.out.println(employee);
            }
        }
    }
    public void minSalaryInDepartment(int department){
        float minSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalary == 0 || employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                }
            }
        }
        System.out.println("Самая низкая зарплата в отделе: " + department + " - " + minSalary);
    }
    public void maxSalaryInDepartment(int department){
        float maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary && employee.getDepartment() == department)
                maxSalary = employee.getSalary();
        }
        System.out.println("Самая высокая зарплата в отделе: " + department + " - " + maxSalary);
    }
    public void averageSalaryInDepartment(int department){
        float averageSalary = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                count++;
                averageSalary = averageSalary + employee.getSalary();
            }
        }
        System.out.println("Средняя зарплата в отделе: " + department + " - " + averageSalary / count);
    }


    public void boostSalaryInDepartment(float coefficient, int department){
        System.out.println("Зарплата после индексации на " + coefficient + "% в отделе :" + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(coefficient/100*employee.getSalary() + employee.getSalary());
                System.out.println(employee);}
        }
    }
    public void toPrintDepartment( int department){
        System.out.println("Список сотрудников отдела " + department + ":");
        String toPrintDepartment = "";
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                toPrintDepartment = employee.getLastName() + " " +  employee.getFirstName() +
                        " " + employee.getMiddleName() + ", " + employee.getSalary() + " рублей, id:" + employee.getId();
                System.out.println(toPrintDepartment);}
        }
    }
    public void toPrintSalaryLess(float salary){
        System.out.println("Список сотрудников с зарплатой меньше, чем " + salary + " рублей:");
        String toPrintSalaryLess = "";
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                toPrintSalaryLess = employee.getLastName() + " " +  employee.getFirstName() +
                        " " + employee.getMiddleName() + ", " + employee.getSalary() + " рублей, id:" + employee.getId();
                System.out.println(toPrintSalaryLess);}
        }
    }
    public void toPrintSalaryMore(float salary){
        System.out.println("Список сотрудников с зарплатой больше, чем " + salary + " рублей:");
        String toPrintSalaryMore = "";
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                toPrintSalaryMore = employee.getLastName() + " " +  employee.getFirstName() +
                        " " + employee.getMiddleName() + ", " + employee.getSalary() + " рублей, id:" + employee.getId();
                System.out.println(toPrintSalaryMore);
            }
        }
    }


    public void addEmployee(String lastName, String firstName, String middleName, int department, float salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(lastName, firstName, middleName, department, salary);
                System.out.println("Сотрудник " + employees[i].toString()+ " принят на работу");
                return;
            }
        }
        System.out.println("В компании нет вакансий");
    }
    public boolean delEmployee(int id){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId() ) {
                System.out.println("Сотрудник " + employees[i].toString()+ " уволен");
                employees[i] = null;
            }
        }
        return true;
    }

    public void changeEmployee(String lastName, String firstName, String middleName, int department, float salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName() == lastName && employees[i].getFirstName() == firstName && employees[i].getMiddleName() == middleName) {
                employees[i].setDepartment(department);
                employees[i].setSalary(salary);
                return;
            }
        }
    }
    public void printEmployeesDep() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("отдел" + i);
            for (int j = 0; j < employees.length; j++) {
                if (employees[j] != null && employees[j].getDepartment() == i) {
                    System.out.println(employees[j].getLastName() + " " + employees[j].getFirstName() + " " + employees[j].getMiddleName());
                }
            }
        }
    }
}
