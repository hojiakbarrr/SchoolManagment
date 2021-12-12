package schoolManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buhgalter implements Serializable {
    /////////////////////////////////////////////////////////////////////////////////   параметры
    private String name;
    private String login;
    private String password;
    private int id = Schooll.genUniqueId();
    private int bankDetails;
    private String profession = "бухгалтер";
    private int staj;
    private List<Buhgalter> buhgalters = new ArrayList<>();
    private int salary = 37000;
    private int schet = 0;
    ///////////////////////////////////
/////////////////////////////////////////////////////////////////////////////    геттеры и сеттеры
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public int getId() {
        return id;
    }
    public int getBankDetails() {
        return bankDetails;
    }
    public String getProfession() {
        return profession;
    }
    public int getStaj() {
        return staj;
    }
    public int getSalary() {
        return salary;
    }
    public int getSchet() {
        return schet;
    }
    ////////////////////////////////////////////////////////////////////////////////     конструктор
    public Buhgalter(String name, String login, String password, int bankDetails, int staj, int salary, int schet) {
        this.name = name;
        this.login = login;
        this.password = password;
//        this.id = Schooll.genUniqueId();
        this.bankDetails = bankDetails;
        this.profession = getProfession();
        this.staj = staj;
        this.salary = getSalary();
        this.schet = getSchet();
    }
    /////////////////////////////////////информация о бухгалтере
    public void infoBu() {
        System.out.println("----------------------------------");
        System.out.println("Имя преподавателя:" + name
                + "\n" + "должность: " + profession
                + "\n" + "зарплата: " + salary
                + "\n" + "банковские реквизиты: " + bankDetails
                + "\n" + "персональный номер:" + id
                + "\n" + "стаж работы:" + staj
                + "\n" + "логин : " + login);
    }
    //////////////////////////////информация выходящая только по поиску
    public static void infoBuhgalter() {
        for (int i = 0; i < SchoolMain.aikol.getBuhgalters().size(); i++) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Имя бухгалтера: " + SchoolMain.aikol.getBuhgalters().get(i).getName()
                    + "\n" + "должность: " + SchoolMain.aikol.getBuhgalters().get(i).getProfession() +
                    "\n" + "логин: " + SchoolMain.aikol.getBuhgalters().get(i).getLogin() +
                    "\n" + "банковские реквизиты: " + SchoolMain.aikol.getBuhgalters().get(i).getBankDetails()
                    + "\n" + "персональный номер: " + SchoolMain.aikol.getBuhgalters().get(i).getId()
                    + "\n" + "стаж работы " + SchoolMain.aikol.getBuhgalters().get(i).getStaj());
        }
        while (true) {
            System.out.println();
            System.out.println("Вернуться в главное меню нажмите__________1");
            System.out.println("Назад__________2");
            System.out.println("Желаете завершить процесс нажмите____________0");

            try {
                int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                switch (x) {
                    case 1:
                        SchoolMain.glavnoemenuy();
                        break;
                    case 0:
                        SchoolMain.Vyhod();

                        break;
                    case 2:
                        Buhgalter.VyborNaOplatu();
                }
            } catch (Exception exception) {
                System.out.println("^*^*^*^*^*^*^_____Следуйте инструкциям_____*^*^*^*^*^" + "\n");
            }
        }
    }
    //////////////////////////////////////////вычитывание зп
    void addSalary(int salary, int experience, int schet) {
        int a, b, c, d;

        a = 3;
        int a1 = (int) (this.salary * (3 / 100f));

        b = 10;
        int b1 = (int) (this.salary * (10 / 100f));

        c = 20;
        int c1 = (int) (this.salary * (20 / 100f));

        d = this.salary * (25 / 100);

        if (experience <= a) {
            this.schet = salary += salary;
        } else if (experience > a && experience <= b) {
            this.schet = salary += salary + a1;
        } else if (experience > b && experience <= c) {
            this.schet = salary += salary + b1;
        } else if (experience > c) {
            this.schet = salary += salary + d;
        }
    }
    ////////////////////////////////////////////////////////////////////////перевод зп сотрудникам
    static void payment() {
        boolean temp = true;
        boolean temp1 = true;

        System.out.println("----------------------------------Перечисление заработной платы---------------------------------------");

        while (temp) {

            System.out.println("---------------------->Ежемесячные выплаты всем сотрудникам нажмите 1<----------------------");
            System.out.println("---------------------->Выплата определенному сотруднику нажмите 2<----------------------");
            System.out.println("---------------------->Назад  нажмите 22<----------------------");
            try {
                int rd = Integer.parseInt(SchoolMain.scanner.nextLine());

                if (rd == 22) {
                    Buhgalter.VyborNaOplatu();
                }
                while (temp1) {
                    if (rd == 2) {
                        System.out.println("Введите имя кому надо перечислить зп");
                        String name = SchoolMain.scanner.nextLine();

                        String one = "11";
                        String two = "21";
                        String three = "31";

                        if (name.equals(two)) {
                            SchoolMain.glavnoemenuy();
                        } else if (name.equals(one)) {
                            payment();
                        } else if (name.equals(three)) {
                            SchoolMain.Vyhod();
                            break;
                        }
                        for (int i = 0; i < SchoolMain.aikol.getTeachers().size(); i++) {
                            if (SchoolMain.aikol.getTeachers().get(i).getName().equals(name)) {
                                SchoolMain.aikol.getTeachers().get(i).addSalary(SchoolMain.aikol.getTeachers().get(i).getSalary(), SchoolMain.aikol.getTeachers().get(i).getExperience(), SchoolMain.aikol.getTeachers().get(i).getSchet());
                                Schooll.minusBudget(SchoolMain.aikol.getTeachers().get(i).getSalary());
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("оклад -> " + SchoolMain.aikol.getTeachers().get(i).getName()
                                        + "\n" + "составляет -> " + SchoolMain.aikol.getTeachers().get(i).getSalary()
                                        + "\n" + "счет сотрудника стало -> " + SchoolMain.aikol.getTeachers().get(i).getSchet()
                                        + "\n" + "cтатус бюджета школы -> " + SchoolMain.aikol.getBudjet());
                                temp1 = false;
                            }
                        }
                        for (int j = 0; j < SchoolMain.aikol.getSotrudniks().size(); j++) {
                            if (SchoolMain.aikol.getSotrudniks().get(j).getName().equals(name)) {
                                SchoolMain.aikol.getSotrudniks().get(j).addSalary(SchoolMain.aikol.getSotrudniks().get(j).getSalary(), SchoolMain.aikol.getSotrudniks().get(j).getExperience(),SchoolMain.aikol.getSotrudniks().get(j).getSchet());
                                Schooll.minusBudget(SchoolMain.aikol.getSotrudniks().get(j).getSalary());
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("оклад -> " + SchoolMain.aikol.getSotrudniks().get(j).getName()
                                        + "\n" + "составляет -> " + SchoolMain.aikol.getSotrudniks().get(j).getSalary()
                                        + "\n" + "счет сотрудника стало -> " + SchoolMain.aikol.getSotrudniks().get(j).getSchet()
                                        + "\n" + "cтатус бюджета школы -> " + SchoolMain.aikol.getBudjet());
                                temp1 = false;
                            }
                        }
                        for (int i = 0; i < SchoolMain.aikol.getBuhgalters().size(); i++) {
                            if (SchoolMain.aikol.getBuhgalters().get(i).getName().equals(name)) {
                                SchoolMain.aikol.getBuhgalters().get(i).addSalary(SchoolMain.aikol.getBuhgalters().get(i).getSalary(), SchoolMain.aikol.getBuhgalters().get(i).getStaj(), SchoolMain.aikol.getBuhgalters().get(i).getSchet());
                                Schooll.minusBudget(SchoolMain.aikol.getBuhgalters().get(i).getSalary());
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("оклад -> " + SchoolMain.aikol.getBuhgalters().get(i).getName()
                                        + "\n" + "составляет -> " + SchoolMain.aikol.getBuhgalters().get(i).getSalary()
                                        + "\n" + "счет сотрудника стало -> " + SchoolMain.aikol.getBuhgalters().get(i).getSchet()
                                        + "\n" + "cтатус бюджета школы -> " + SchoolMain.aikol.getBudjet());
                                temp1 = false;
                            }
                        }
                        if (temp1) {
                            System.out.println("_____такого Сотрудника нет повторите ввод_____");
                            System.out.println("_____Вернуться в меню выбора перечисления зп нажмите -{ 11 }");
                            System.out.println("_____Вернуться в главное меню нажмите -{ 21 }");
                            System.out.println("_____Желаете завершить процесс нажмите -{ 31 }");
                        }
                    } else {
                        break;
                    }
                }
                /////////////////////////////всем перечисление зп

                if (rd == 1) {
                    System.out.println("Ежемесячные зарплаты");
                    for (int i = 0; i < SchoolMain.aikol.getTeachers().size(); i++) {

                        SchoolMain.aikol.getTeachers().get(i).addSalary(SchoolMain.aikol.getTeachers().get(i).getSalary(), SchoolMain.aikol.getTeachers().get(i).getExperience(), SchoolMain.aikol.getTeachers().get(i).getSchet());
                        Schooll.minusBudget(SchoolMain.aikol.getTeachers().get(i).getSalary());
                        System.out.println("-----------------------------------------------------");
                        System.out.println("оклад -> " + SchoolMain.aikol.getTeachers().get(i).getName()
                                + "\n" + "составляет -> " + SchoolMain.aikol.getTeachers().get(i).getSalary()
                                + "\n" + "счет сотрудника стало -> " + SchoolMain.aikol.getTeachers().get(i).getSchet()
                                + "\n" + "cтатус бюджета школы -> " + SchoolMain.aikol.getBudjet());
                    }
                    for (int i = 0; i < SchoolMain.aikol.getSotrudniks().size(); i++) {

                        SchoolMain.aikol.getSotrudniks().get(i).addSalary(SchoolMain.aikol.getSotrudniks().get(i).getSalary(), SchoolMain.aikol.getSotrudniks().get(i).getExperience(), SchoolMain.aikol.getSotrudniks().get(i).getSchet());
                        Schooll.minusBudget(SchoolMain.aikol.getSotrudniks().get(i).getSalary());
                        System.out.println("----------------------------------");
                        System.out.println("оклад -> " + SchoolMain.aikol.getSotrudniks().get(i).getName()
                                + "\n" + "составляет -> " + SchoolMain.aikol.getSotrudniks().get(i).getSalary()
                                + "\n" + "счет сотрудника стало -> " + SchoolMain.aikol.getSotrudniks().get(i).getSchet()
                                + "\n" + "cтатус бюджета школы ->  " + SchoolMain.aikol.getBudjet());

                    }
                    for (int i = 0; i < SchoolMain.aikol.getBuhgalters().size(); i++) {

                        SchoolMain.aikol.getBuhgalters().get(i).addSalary(SchoolMain.aikol.getBuhgalters().get(i).getSalary(), SchoolMain.aikol.getBuhgalters().get(i).getStaj(), SchoolMain.aikol.getBuhgalters().get(i).getSchet());
                        Schooll.minusBudget(SchoolMain.aikol.getBuhgalters().get(i).getSalary());
                        System.out.println("----------------------------------");
                        System.out.println("оклад -> " + SchoolMain.aikol.getBuhgalters().get(i).getName()
                                + "\n" + "составляет -> " + SchoolMain.aikol.getBuhgalters().get(i).getSalary()
                                + "\n" + "счет сотрудника стало -> " + SchoolMain.aikol.getBuhgalters().get(i).getSchet()
                                + "\n" + "cтатус бюджета школы -> " + SchoolMain.aikol.getBudjet());
                        temp = false;
                    }
                }
                if (!temp) {
                    payment();
                }
            } catch (Exception e) {
                System.err.println("Введите цифру а не букву");
            }
        }
    }
    /////////////////////////////////////////авторизация
    public static void avtorization() {

        int count = 0;
        boolean temp = true;

        System.out.println("----------------------------Войти в систему управления школы -'Айкол'-------------------------------------------" + "\n");

        while (temp) {
            count++;

            System.out.println("-------Ваш логин------");
            String login = SchoolMain.scanner.nextLine();

            System.out.println("-------Введите ваш пароль-------");
            String pfrol = SchoolMain.scanner.nextLine();
            for (int i = 0; i < SchoolMain.aikol.getBuhgalters().size(); i++) {
                if (SchoolMain.aikol.getBuhgalters().get(i).getLogin().equals(login) && SchoolMain.aikol.getBuhgalters().get(i).getPassword().equals(pfrol)) {
                    temp = false;
                }
                if (count >= 3) {
                    System.out.println("----Обратись к администраору----"
                            + "\n" + "----попыток войти в систему :" + count);
                    SchoolMain.Vyhod();
                    break;
                }
            }if (temp) {
                int x = 3 - count;
                System.out.println("------------Ваши данные не правильные, повторите ввод----------------"
                        + "\n" + "---------------попыток осталось --> " + x + " <----------------");
            }
        }
    }
    //////////////////////////////оплата контракта студентов
    static void payContract() {
        System.out.println("-------------------------Введите логин студента------------------------");
        boolean temp = true;

        while (temp) {
            System.out.println("_____Вернуться в главное меню нажмите - 1_____");
            System.out.println("_____Желаете завершить процесс нажмите - 0_____");
            System.out.println("_____Вернуться в раздел управления бюджетом - 2____");
            String login = SchoolMain.scanner.nextLine();
            String da = "0";
            String net = "1";

            if (login.equals(net)) {
                SchoolMain.glavnoemenuy();
                break;
            } else if (login.equals(da)) {
                SchoolMain.Vyhod();
                break;
            }else if (login.equals("2")){
                Buhgalter.VyborNaOplatu();
            }

            for (int i = 0; i < SchoolMain.aikol.getStudents().size(); i++) {
                if (SchoolMain.aikol.getStudents().get(i).getLogin().equals(login)) {
                    System.out.println("Контракт за обучение составляет --> " + SchoolMain.aikol.getStudents().get(i).getContract() + "\n" +
                            "\n" + "Ваша задолженность составляет --> " + (SchoolMain.aikol.getStudents().get(i).getContract() - SchoolMain.aikol.getStudents().get(i).getPayed()));
                    System.out.println("-------------------------------------------Сколько будет внесено оплаты--------------------------------------------");
                    SchoolMain.aikol.getStudents().get(i).infoPayed(SchoolMain.aikol.getStudents().get(i).getContract(), SchoolMain.aikol.getStudents().get(i).getPayed(), SchoolMain.aikol.getStudents().get(i).getDolgPoUchebe());
                    Schooll.addDudget(SchoolMain.aikol.getStudents().get(i).getPayed());
                    temp = false;
                }
            }
            if (temp) {
                System.out.println("_____такого логина нет повторите ввод_____");
            }
        }
        while (true) {

            System.out.println("Вы находитесь в разделе оплата контракта");
            System.out.println("_______Вернуться назад в главное меню______{нажмите_-_-_-_----> [0]");
            System.out.println("_______Выход из системы________{нажмите_-_-_-_----> [9]");
            System.out.println("________Повторить опалту контракта________{нажмите_-_-_-_----> [6]");
            System.out.println("________Вернуться в раздел управления бюджетом________{нажмите_-_-_-_----> [7]");

            try {
                int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                switch (x) {
                    case 0:
                        SchoolMain.glavnoemenuy();
                        break;
                    case 9:
                        SchoolMain.Vyhod();
                        break;
                    case 6:
                        Buhgalter.payContract();
                        break;
                    case 7:
                        Buhgalter.VyborNaOplatu();
                        break;
                }
            } catch (Exception e) {
                System.err.println("____Следуйте инструкциям_____");

            }
        }
    }
    /////////////////////////////////////////////////////////отдел управления бюджета
    public static void VyborNaOplatu() {
        System.out.println("\n" + "----------------------------Вы вошли в отдел управления бюджетом школы----------------------------");

        while (true) {
            System.out.println();
            System.out.println("Оплатить контракт_____нажмите___________________________1" +
                    "\n" + "Перечисление зп_____нажмите___________________________2"
                    + "\n" + "Информация о бухгалтере_____нажмите___________________________3"
                    + "\n" + "Вернуться в главное меню_____нажмите_______________4"
                    + "\n" + "Желаете завершить процесс_____нажмите__________0");

            try {
                int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                switch (x) {
                    case 1:
                        Buhgalter.payContract();
                        break;
                    case 2:
                        Buhgalter.payment();
                        break;
                    case 3:
                        Buhgalter.infoBuhgalter();
                        break;
                    case 4:
                        SchoolMain.glavnoemenuy();
                        break;
                    case 0:
                        SchoolMain.Vyhod();

                        break;
                }
            } catch (Exception exception) {
                System.out.println("^*^*^*^*^*^*^_____Следуйте инструкциям_____*^*^*^*^*^" + "\n");
            }
        }
    }
    ///////////////////////////////////////////////////добавление нового бухгалтера
    public static void AddNewAccountant() {


        String name = "";

        while (name == null || name.isEmpty()) {
            System.out.println("----------------------------------Введите имя нового бухгалтера----------------------------------");
            System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");

            name = Sotrudnik.chekString(SchoolMain.scanner.nextLine());
        }
        if (name.equals("0")) {
            SchoolMain.menyu();
        }

        System.out.println("----------------------------------Придумайте логин----------------------------------");
        System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
        String login = SchoolMain.scanner.nextLine();
        if (login.equals("0")) {
            SchoolMain.menyu();
        }

        System.out.println("----------------------------------Придумайте пароль----------------------------------");
        System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
        String password = SchoolMain.scanner.nextLine();
        if (password.equals("0")) {
            SchoolMain.menyu();
        }

        int staj;
        while (true) {
            try {
                System.out.println("----------------------------------Укажите какой стаж у сотрудника----------------------------------");
                System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");

                staj = Integer.parseInt(SchoolMain.scanner.nextLine());
                if (staj == 0)
                    SchoolMain.menyu();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }
        }
        int bankDetails;
        while (true) {
            try {
                System.out.println("----------------------------------Укажите банковские реквизиты нового бухгалтера----------------------------------");
                System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
                bankDetails = Integer.parseInt(SchoolMain.scanner.nextLine());

                if (bankDetails == 0)
                    SchoolMain.menyu();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }
        }

        int salary = 37000;
        int schet = 0;

        Buhgalter buhgalter1 = new Buhgalter(name, login, password, bankDetails, staj, salary, schet);/////////////String name, String login, String password, int bankDetails, String profession
        SchoolMain.aikol.getBuhgalters().add(buhgalter1);

        System.out.println("----------------------------------Создана новая учетная запись для бухгалтерского штаба----------------------------------");

        while (true) {

            System.out.println("Вы находитесь в разделе добавить нового бухгалтера");
            System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
            System.out.println("_______Завершить процесс________{нажмите_-_-_-_----> [9]");
            System.out.println("________Добавить еще одного пользователя________{нажмите_-_-_-_----> [6]");

            try {
                int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                switch (x) {
                    case 0:
                        SchoolMain.menyu();
                        break;
                    case 9:
                        SchoolMain.Vyhod();
                        break;
                    case 6:
                        Buhgalter.AddNewAccountant();
                        break;
                }
            } catch (Exception e) {
                System.err.println("____Следуйте инструкции_____");

            }
        }
    }
}


