package schoolManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sotrudnik implements Serializable {
    /////////////////////////////////параметра
    private int salary;
    private String name;
//    private int id= Schooll.genUniqueId();
    private String profession;
    private int bankDetails;
    private List<Sotrudnik> sotrudniks = new ArrayList<>();
    private int experience;
    private String login;
    private String passwordd;
    private int schet = 0;
    //////////////////////////////////////////////геттеры и сеттеры
    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    public int getId() {
//        return id;
//    }
    public String getProfession() {
        return profession;
    }
    public int getBankDetails() {
        return bankDetails;
    }
    public String getLogin() {
        return login;
    }
    public int getExperience() {
        return experience;
    }
    public int getSchet() {
        return schet;
    }
    ////////////////////////////////////////////////////////констурктор
    public Sotrudnik(int salary, String name, String profession, int bankDetails, int experience, String loginn, String passwordd) {
        this.salary = salary;
        this.name = name;
//        this.id = Schooll.genUniqueId();
        this.profession = profession;
        this.bankDetails = bankDetails;
        this.experience = experience;
        this.login = loginn;
        this.passwordd = passwordd;
        this.schet = getSchet();
    }

    //////////////////////////////////////инфо про всех сотрудников
    public void infoSotrudnik() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Имя сотрудника: " + this.name
                + "\n" + "должность: " + this.profession
                + "\n" + "банковские реквизиты: " + this.bankDetails
//                + "\n" + "персональный номер: " + this.id
                + "\n" + "стаж работы ->" + this.experience
                + "\n" + "логин -> " + this.login
                + "\n" + "оклад --> " + this.salary
                + "\n" + "банковский счет --> " + this.schet);
    }
////////////////////////////////////////////инфо сотрудника при поиске
    public static void infoSotrudn() {

        for (int i = 0; i < SchoolMain.aikol.getSotrudniks().size(); i++) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Имя сотрудника: " + SchoolMain.aikol.getSotrudniks().get(i).getName()
                    + "\n" + "должность " + SchoolMain.aikol.getSotrudniks().get(i).getProfession()
                    + "\n" + "банковские реквизиты: " + SchoolMain.aikol.getSotrudniks().get(i).getBankDetails()
//                    + "\n" + "персональный номер: " + SchoolMain.aikol.getSotrudniks().get(i).getId()
                    + "\n" + "стаж работы -> " + SchoolMain.aikol.getSotrudniks().get(i).getExperience()
                    + "\n" + "логин -> " + SchoolMain.aikol.getSotrudniks().get(i).getLogin()
                    + "\n" + "оклад --> " + SchoolMain.aikol.getSotrudniks().get(i).getSalary()
                    + "\n" + "банковский счет --> " + SchoolMain.aikol.getSotrudniks().get(i).getSchet());
        }
        while (true) {
            System.out.println();
            System.out.println("_____Вернуться в главное меню нажмите_-_-_-_----> [1]");
            System.out.println("_____Желаете завершить процесс нажмите_-_-_-_----> [0]");

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
    ///////////////////////////////////////////////проверка на цифр
    static String chekString(String name) {


        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == '1'
                    || name.charAt(i) == '2'
                    || name.charAt(i) == '3'
                    || name.charAt(i) == '4'
                    || name.charAt(i) == '5'
                    || name.charAt(i) == '6'
                    || name.charAt(i) == '7' || name.charAt(i) == '8' || name.charAt(i) == '9' || name.charAt(i) == ' ') {
                System.err.println("____Вы вводите цифру в поле имя____");
                return null;
            }
        }
        for (int i = 0; i < name.length(); i++) {
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
        return name;
    }
    ///////////////////////////////////////////////добавление нового сотрудника
    static void addNewSotrud() {

        String name = "";

        while (name == null || name.isEmpty()) {
            System.out.println("----------------------------------Введите имя нового сотрудника----------------------------------");
            System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");

            name = chekString(SchoolMain.scanner.nextLine());
        }
        if (name.equals("0")) {
            SchoolMain.glavnoemenuy();        }

        String profession = "";
        while (profession == null || profession.isEmpty()) {
            System.out.println("----------------------------------Укажите специальность----------------------------------");
            System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");

            profession = chekString(SchoolMain.scanner.nextLine());

        }
        if (profession.equals("0")) {
            SchoolMain.glavnoemenuy();
        }
        System.out.println("----------------------------------Придумайте логин----------------------------------");
        System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
        String loginnn = SchoolMain.scanner.nextLine();
        if (loginnn.equals("0")) {

        }

        System.out.println("----------------------------------Придумайте пароль----------------------------------");
        System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
        String paroll = SchoolMain.scanner.nextLine();;
        if (paroll.equals("0")) {
            SchoolMain.glavnoemenuy();
        }
        int salary;
        while (true) {
            try {
                System.out.println("----------------------------------Введите его зарабатную плату----------------------------------");
                System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
                salary = Integer.parseInt(SchoolMain.scanner.nextLine());

                if (salary == 0)
                    SchoolMain.glavnoemenuy();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }
        }
        int bankDetails;
        while (true) {
            try {
                System.out.println("----------------------------------Укажите банковские реквизиты нового сотрудника----------------------------------");
                System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
                bankDetails = Integer.parseInt(SchoolMain.scanner.nextLine());

                if (bankDetails == 0)
                    SchoolMain.glavnoemenuy();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }
        }
        int experience;
        while (true) {
            try {
                System.out.println("----------------------------------Укажите какой стаж у сотрудника----------------------------------");
                System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");

                experience = Integer.parseInt(SchoolMain.scanner.nextLine());

                if (experience == 0)
                    SchoolMain.glavnoemenuy();
                break;

            } catch (Exception exception) {
                System.err.println("____Введите цифры а не буквы____");
            }
        }

        Sotrudnik sotrudnik1 = new Sotrudnik(salary, name, profession, bankDetails, experience, loginnn, paroll);
        SchoolMain.aikol.getSotrudniks().add(sotrudnik1);

        System.out.println("----------------------------------Добавлен новый сотрудник----------------------------------");
        while (true) {

            System.out.println("Вы находитесь в разделе добавления нового сотрудника");
            System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
            System.out.println("_______Завершить процесс________{нажмите_-_-_-_----> [9]");
            System.out.println("________Добавить еще одного сотрудника________{нажмите_-_-_-_----> [6]");

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
                        addNewSotrud();
                }
            } catch (Exception e) {
                System.err.println("____Следуйте инструкциям_____");

            }

        }

    }
////////////////////////////////////////////////////перечисление зп
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
//            System.out.println(this.salary + " " + a1);
        } else if (experience > b && experience <= c) {
            this.schet = salary += salary + b1;
        } else if (experience > c) {
            this.schet = salary += salary + d;
        }

    }


}
