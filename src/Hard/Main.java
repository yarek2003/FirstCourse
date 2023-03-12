package Hard;

public class  Main {

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook(10);
        book.addEmployee("Калашников", "Сергей", "Владимирович", 1, 65000);
        book.addEmployee("Пякина", "Екатерина", "Дмитриевна", 2, 38200);
        book.addEmployee("Волков", "Сергей", "Федорович", 3, 47100);
        book.addEmployee("Шишкова", "Светлана", "Геннадиевна", 2, 61000);
        book.addEmployee("Зуева", "Марина", "Игоревна", 2, 37000);
        book.addEmployee("Филатова", "Анна", "Александровна", 1, 57000);
        book.addEmployee("Шабалина", "Алена", "Алексеевна", 4, 34000);
        book.addEmployee("Пудавов", "Роман", "Игоревич", 3, 60000);
        book.addEmployee("Волошкова", "Эллона", "Рамазановна", 3, 49000);

        book.toPrint();
        System.out.println("Сумма затрат на зарплаты в месяц в компании:" + book.sumPerMonth());
        System.out.println();
        book.minSalary();
        book.maxSalary();
        System.out.println("Средняя зарплата в компании: " + book.averageSalary());
        System.out.println();
        book.toPrintFio();
        System.out.println();
        book.boostSalary(2);
        System.out.println();
        book.minSalaryInDepartment(3);
        book.maxSalaryInDepartment(3);
        book.averageSalaryInDepartment(2);
        System.out.println();
        book.boostSalaryInDepartment(3,3);
        System.out.println();
        book.toPrintDepartment(3);
        System.out.println();
        book.toPrintSalaryLess(50000);
        System.out.println();
        book.toPrintSalaryMore(50000);
        System.out.println();
        book.delEmployee( 3);
        book.changeEmployee("Зуева", "Марина", "Игоревна",5, 25000);
        book.toPrint();
        book.printEmployeesDep();
    }


}