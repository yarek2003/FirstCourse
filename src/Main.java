public class  Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Калашников", "Сергей", "Владимирович", 1, 65000);
        employees[1] = new Employee("Пякина", "Екатерина", "Дмитриевна", 2, 38200);
        employees[2] = new Employee("Волков", "Сергей", "Федорович", 3, 47100);
        employees[3] = new Employee("Шишкова", "Светлана", "Геннадиевна", 2, 61000);
        employees[4] = new Employee("Зуева", "Марина", "Игоревна", 2, 37000);
        employees[5] = new Employee("Филатова", "Анна", "Александровна", 1, 57000);
        employees[6] = new Employee("Шабалина", "Алена", "Алексеевна", 1, 34000);
        employees[7] = new Employee("Пудавов", "Роман", "Игоревич", 3, 60000);
        employees[8] = new Employee("Волошкова", "Эллона", "Рамазановна", 3, 49000);
        employees[9] = new Employee("Ивлев", "Антон", "Алексеевич", 2, 28000);



        toPrint(employees);
        sumPerMonth(employees);
        minSalary(employees);
        maxSalary(employees);
        middleSalary(employees);
        toPrintFio(employees);
        boostSalary(employees,2);
        minSalaryInDepartment(employees,3);
        maxSalaryInDepartment(employees,3);
        boostSalaryInDepartment(employees,3,3);
        toPrintDepartment(employees, 3);
        toPrintSalaryLess(employees, 50000);
        toPrintSalaryMore(employees, 50000);
    }
    public static void toPrint(Employee[] employees){
        System.out.println("Книга сотрудников компании:");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static float sumPerMonth(Employee[] employees){
        System.out.println();
        float sumPerMonth = 0;
        for (Employee employee : employees) {
            sumPerMonth = sumPerMonth + employee.getSalary();
        }
        System.out.println("Общие расходы на зарплату: " + sumPerMonth);
        return sumPerMonth;
    }
    public static void minSalary(Employee[] employees){
        System.out.println();
        float minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) minSalary = employees[i].getSalary();
        }
        System.out.println("Самая низкая зарплата: " + minSalary);
    }
    public static void maxSalary(Employee[] employees){
        System.out.println();
        float maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) maxSalary = employees[i].getSalary();
        }
        System.out.println("Самая высокая зарплата в компании: " + maxSalary);
    }
    public static void middleSalary(Employee[] employees){
        System.out.println();
        float middleSalary = (float)sumPerMonth(employees)/employees.length;
        System.out.println("Средняя зарплата в компании: " + middleSalary);
    }
    public static void toPrintFio(Employee[] employees){
        System.out.println();
        System.out.println("ФИО сотрудников компании:");
        String toPrintFio = "";
        for (Employee employee : employees) {
            toPrintFio = employee.getFirstName() + " " + employee.getLastName() + " " + employee.getMiddleName();
            System.out.println(toPrintFio);
        }
    }
    public static void boostSalary(Employee[] employees, float coefficient){
        System.out.println();
        System.out.println("Зарплата после индексации на " + coefficient + "%:");
        for (Employee employee : employees) {
            employee.setSalary(coefficient/100*employee.getSalary()+ employee.getSalary());
            System.out.println(employee.toString());
        }
    }
    public static void minSalaryInDepartment(Employee[] employees, int department){
        System.out.println();
        float minSalary = employees[0].getSalary();
        for (int j=0; j< employees.length;j++){
            if (employees[j].getDepartment() == department)
                minSalary = employees[j].getSalary();
            break;
        }
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary && employee.getDepartment() == department)
                minSalary = employee.getSalary();
        }
        System.out.println("Самая низкая зарплата в отделе: " + department + " - " + minSalary);
    }
    public static void maxSalaryInDepartment(Employee[] employees, int department){
        float maxSalary = employees[0].getSalary();
        for (int j=0; j< employees.length;j++){
            if (employees[j].getDepartment() == department)
                maxSalary = employees[j].getSalary();
            break;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary && employees[i].getDepartment() == department) maxSalary = employees[i].getSalary();
        }
        System.out.println("Самая высокая зарплата в отделе: " + department + " - " + maxSalary);
    }
    public static void boostSalaryInDepartment(Employee[] employees, float coefficient, int department){
        System.out.println();
        System.out.println("Зарплата после индексации на " + coefficient + "%:");
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(coefficient/100*employee.getSalary()+ employee.getSalary());
                System.out.println(employee.toString());}
        }
    }
    public static void toPrintDepartment(Employee[] employees, int department){
        System.out.println();
        System.out.println("Список сотрудников отдела " + department + ":");
        String toPrintDepartment = "";
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                toPrintDepartment = employee.getFirstName() + " " + employee.getLastName() + "" +
                        " " + employee.getMiddleName() + " " + employee.getSalary() + " " + employee.getId();
                System.out.println(toPrintDepartment);}
        }
    }
    public static void toPrintSalaryLess(Employee[] employees, float salary){
        System.out.println();
        System.out.println("Список сотрудников с зарплатой меньше, чем " + salary + " рублей:");
        String toPrintSalaryLess = "";
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                toPrintSalaryLess = employee.getFirstName() + " " + employee.getLastName() + "" +
                        " " + employee.getMiddleName() + " " + employee.getSalary() + " " + employee.getId();
                System.out.println(toPrintSalaryLess);}
        }
    }
    public static void toPrintSalaryMore(Employee[] employees, float salary){
        System.out.println();
        System.out.println("Список сотрудников с зарплатой больше, чем " + salary + " рублей:");
        String toPrintSalaryMore = "";
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                toPrintSalaryMore = employee.getFirstName() + " " + employee.getLastName() + "" +
                        " " + employee.getMiddleName() + " " + employee.getSalary() + " " + employee.getId();
                System.out.println(toPrintSalaryMore);
            }
        }
    }


}