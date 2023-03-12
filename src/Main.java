public class  Main {
    static Employee[] employees = new Employee[10];
    public static void main(String[] args) {

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



        toPrint();
        System.out.println("Сумма затрат на зарплаты в месяц в компании:" + sumPerMonth());
        System.out.println();
        minSalary();
        maxSalary();
        System.out.println("Средняя зарплата в компании: " + averageSalary());
        System.out.println();
        toPrintFio();
        System.out.println();
        boostSalary(2);
        System.out.println();
        minSalaryInDepartment(3);
        maxSalaryInDepartment(3);
        averageSalaryInDepartment(2);
        System.out.println();
        boostSalaryInDepartment(3,3);
        System.out.println();
        toPrintDepartment(3);
        System.out.println();
        toPrintSalaryLess(50000);
        System.out.println();
        toPrintSalaryMore(50000);
    }
    public static void toPrint(){
        System.out.println("Книга сотрудников компании:");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static float sumPerMonth(){
        float sumPerMonth = 0;
        for (Employee employee : employees) {
            sumPerMonth = sumPerMonth + employee.getSalary();
        }
        return sumPerMonth;
    }
    public static void minSalary(){
        float minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) minSalary = employee.getSalary();
        }
        System.out.println("Самая низкая зарплата: " + minSalary);
    }
    public static void maxSalary(){
        float maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) maxSalary = employee.getSalary();
        }
        System.out.println("Самая высокая зарплата в компании: " + maxSalary);
    }
    public static float averageSalary(){
        return sumPerMonth()/employees.length;
    }
    public static void toPrintFio(){
        System.out.println("ФИО сотрудников компании:");
        String toPrintFio = "";
        for (Employee employee : employees) {
            toPrintFio = employee.getFirstName() + " " + employee.getLastName() + " " + employee.getMiddleName();
            System.out.println(toPrintFio);
        }
    }
    public static void boostSalary(float coefficient){
        System.out.println("Зарплата после индексации на " + coefficient + "%:");
        for (Employee employee : employees) {
            employee.setSalary(coefficient/100*employee.getSalary()+ employee.getSalary());
            System.out.println(employee);
        }
    }
    public static void minSalaryInDepartment(int department){
        float minSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (minSalary == 0 || employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                }
            }
        }
        System.out.println("Самая низкая зарплата в отделе " + department + ": " + minSalary);
    }
    public static void maxSalaryInDepartment(int department){
        float maxSalary = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary && employee.getDepartment() == department)
                maxSalary = employee.getSalary();
        }
        System.out.println("Самая высокая зарплата в отделе " + department + ": " + maxSalary);
    }
    public static void averageSalaryInDepartment(int department){
        float averageSalary = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                count++;
                averageSalary = averageSalary + employee.getSalary();
            }
        }
        System.out.println("Средняя зарплата в отделе " + department + ": " + averageSalary / count);
    }


    public static void boostSalaryInDepartment(float coefficient, int department){
        System.out.println("Зарплата после индексации на " + coefficient + "% в отделе :" + department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary(coefficient/100*employee.getSalary() + employee.getSalary());
                System.out.println(employee);}
        }
    }
    public static void toPrintDepartment( int department){
        System.out.println("Список сотрудников отдела " + department + ":");
        String toPrintDepartment = "";
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                toPrintDepartment = employee.getFirstName() + " " + employee.getLastName()  +
                        " " + employee.getMiddleName() + ", " + employee.getSalary() + " рублей, id:" + employee.getId();
                System.out.println(toPrintDepartment);}
        }
    }
    public static void toPrintSalaryLess(float salary){
        System.out.println("Список сотрудников с зарплатой меньше, чем " + salary + " рублей:");
        String toPrintSalaryLess = "";
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                toPrintSalaryLess = employee.getFirstName() + " " + employee.getLastName()  +
                        " " + employee.getMiddleName() + ", " + employee.getSalary() + " рублей, id:" + employee.getId();
                System.out.println(toPrintSalaryLess);}
        }
    }
    public static void toPrintSalaryMore(float salary){
        System.out.println("Список сотрудников с зарплатой больше, чем " + salary + " рублей:");
        String toPrintSalaryMore = "";
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                toPrintSalaryMore = employee.getFirstName() + " " + employee.getLastName()  +
                        " " + employee.getMiddleName() + ", " + employee.getSalary() + " рублей, id:" + employee.getId();
                System.out.println(toPrintSalaryMore);
            }
        }
    }


}