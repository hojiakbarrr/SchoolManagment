package schoolManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students implements Serializable {
    ///////////////////////////////////////параметры
    private int contract;
    private String name;
    private int course;
//    private int id = Schooll.genUniqueId();
    private String login;
    private String password;
    private int payed = 0;
    private List<Students> students = new ArrayList<>();

    //////////////////////////////////////////////////////////////////конструктор
    public Students(String name, int course, String login, String password, int contract) {
        this.contract = contract;
        this.name = name;
        this.course = course;
        this.login = login;
        this.password = password;
        this.payed = getPayed();
//        this.id = Schooll.genUniqueId();
    }

    //////////////////////////////////добавление нового студента
    static void addNewStudent() {


        String names = "";
        while (names == null || names.isEmpty()) {
            System.out.println("----------------------------------Введите имя нового студента----------------------------------");
            System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");
            names = Sotrudnik.chekString(SchoolMain.scanner.nextLine());
        }
        if (names.equals("0")) {
            SchoolMain.glavnoemenuy();
        }


        System.out.println("----------------------------------Придумайте логин----------------------------------");
        System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");
        String login = SchoolMain.scanner.nextLine();
        if (login.equals("0")) {
            SchoolMain.glavnoemenuy();
        }

        System.out.println("----------------------------------Придумайте пароль----------------------------------");
        System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");
        String password = SchoolMain.scanner.nextLine();
        if (password.equals("0")) {
            SchoolMain.glavnoemenuy();
        }
        int course;
        while (true) {
            try {
                System.out.println("----------------------------------Укажите курс струдента----------------------------------");
                System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");
                course = Integer.parseInt(SchoolMain.scanner.nextLine());

                if (course == 0)
                    SchoolMain.glavnoemenuy();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }

        }

        int contract;
        while (true) {
            try {
                System.out.println("----------------------------------Укажите стоимость контракта----------------------------------");
                System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
                contract = Integer.parseInt(SchoolMain.scanner.nextLine());
                if (contract == 0)
                    SchoolMain.glavnoemenuy();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }
        }

        Students student1 = new Students(names, course, login, password, contract);
        SchoolMain.aikol.getStudents().add(student1);

        System.out.println("----------------------------------Добавлен новый студент----------------------------------");

        while (true) {
            System.out.println("Вы находитесь в разделе добавления нового cтудента");
            System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
            System.out.println("_______Завершить процесс________{нажмите_-_-_-_----> [9]");
            System.out.println("________Добавить еще одного студента________{нажмите_-_-_-_----> [6]");

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
                        addNewStudent();

                }
            } catch (Exception e) {
                System.err.println("____Следуйте инструкциям_____");

            }

        }
    }

    //////////////////////////////////////информация о студентах
    public static void infoStudents() {

        for (int i = 0; i < SchoolMain.aikol.getStudents().size(); i++) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Имя учащегося: " + SchoolMain.aikol.getStudents().get(i).getName()
                    + "\n" + "курс: " + SchoolMain.aikol.getStudents().get(i).getCourse()
                    + "\n" + "логин: " + SchoolMain.aikol.getStudents().get(i).getLogin()
                    + "\n" + "контаркт за обучение составляет:" + SchoolMain.aikol.getStudents().get(i).getContract()
                    + "\n" + "сколько внесено оплаты: " + SchoolMain.aikol.getStudents().get(i).getPayed()
                    + "\n" + "долг по учебе " + SchoolMain.aikol.getStudents().get(i).getDolgPoUchebe());
        }
        while (true) {
            System.out.println();
            System.out.println("_____Вернуться в главное меню нажмите - 1 _____");
            System.out.println("_____Желаете завершить процесс нажмите - 0 _____");

            try {
                int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                switch (x) {
                    case 1:
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

    /////////////////////////////////////////инфо о студентах с помощью поисковика
    public void infostud() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Имя учащегося: " + name
                + "\n" + "курс: " + course
                + "\n" + "логин: " + login
                + "\n" + "контракт за обучение составляет:" + contract
                + "\n" + "сколько внесено оплаты: " + payed
                + "\n" + "долг по учебе " + this.getDolgPoUchebe()
                + "\n" + "персональный номер :");
    }

    /////////////////////////////////////////////////геттеры и сеттеры
    public int getContract() {
        return contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public String getLogin() {
        return login;
    }

    public int getPayed() {
        return payed;
    }

    public int getDolgPoUchebe() {
        return contract - payed;
    }

    ///////////////////////////////////////////////поисковик
    public static void Search() {

        boolean temp = true;
        int count = 0;
        String dobro = "Добро пожаловать";

        System.out.println("------------------------------------------------Кого желаете найти----------------------------------------------------");
        System.out.println("_____Вернуться в главное меню нажмите - 1 _____");
        System.out.println("_____Желаете завершить процесс нажмите - 0 _____");
        while (temp) {
            if (dobro.equals("правильно")) {
                System.out.println("--------------------------------------найден пользователь-------------------------------------------");
                break;

            }
            count++;

            String poisk = SchoolMain.scanner.nextLine();
            String da = "0";
            String net = "1";

            if (poisk.equals(net)) {
                SchoolMain.glavnoemenuy();
            } else if (poisk.equals(da)) {
                SchoolMain.Vyhod();
                break;
            }

            for (int i = 0; i < SchoolMain.aikol.getSotrudniks().size(); i++) {
                if (SchoolMain.aikol.getSotrudniks().get(i).getName().equals(poisk)) {
                    SchoolMain.aikol.getSotrudniks().get(i).infoSotrudnik();
                    dobro = "правильно";
                }
            }

            for (int i = 0; i < SchoolMain.aikol.getStudents().size(); i++) {
                if (SchoolMain.aikol.getStudents().get(i).getName().equals(poisk)) {
                    SchoolMain.aikol.getStudents().get(i).infostud();
                    dobro = "правильно";
                }
            }

            for (int i = 0; i < SchoolMain.aikol.getTeachers().size(); i++) {
                if (SchoolMain.aikol.getTeachers().get(i).getName().equals(poisk)) {
                    SchoolMain.aikol.getTeachers().get(i).infoTeachers();
                    dobro = "правильно";
                }
            }

            for (int i = 0; i < SchoolMain.aikol.getBuhgalters().size(); i++) {
                if (SchoolMain.aikol.getBuhgalters().get(i).getName().equals(poisk)) {
//                    SchoolMain.aikol.getBuhgalters().get(i).infoBu();
                    dobro = "правильно";
                }
            }
            if (count >= 1) {
                if (dobro.equals("правильно")) {
                } else {
                    System.out.println(("------------------------------------такого человека нет в базе данных-----------------------------------------"));
                    System.out.println("----------------------------Попробуйте найти еще раз------------------------------");
                    System.out.println("_____Вернуться в главное меню нажмите - 1 _____");
                    System.out.println("_____Желаете завершить процесс нажмите - 0 _____");
                }
            }
        }
        while (true) {

            System.out.println("Вы находитесь в разделе поиск");
            System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
            System.out.println("_______Завершить процесс________{нажмите_-_-_-_----> [9]");
            System.out.println("________Повторить поиск________{нажмите_-_-_-_----> [6]");

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
                        Students.Search();
                }
            } catch (Exception e) {
                System.err.println("____Следуйте инструкциям_____");

            }

        }
    }

    /////////////////////////////////////////////процесс оплаты контракта
    void infoPayed(int contract, int payed, int dolgPoUchebe) {

        while (true) {
            int x = Integer.valueOf(SchoolMain.scanner.nextLine());
            if ((x == 0)) {
                break;
            }

            if (x > this.getDolgPoUchebe()) {
                System.out.println("------Вы пытаетесь оплатить больше чем надо-------"
                        + "\n" + "-------------------введите еще раз--------------------"
                        + "\n" + "_-_-_-_-_-_-_-_-_-_хотите выйти с этого раздела нажмите: 0");
            } else if (x == this.getDolgPoUchebe()) {
                this.payed += x;
                System.out.println("Вы оплатити полностью контракт ");
                break;
            } else if (x < this.getDolgPoUchebe()) {
                this.payed += x;
                System.out.println("вы не полностью оплатили контракт" + "\n" + "ваша задолженность:" + this.getDolgPoUchebe()
                        + "\n" + "_-_-_-_-_-_-_-_-_-_хотите выйти с этого раздела нажмите: 0");

            }
        }
    }
}
