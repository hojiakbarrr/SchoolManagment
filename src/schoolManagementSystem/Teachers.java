package schoolManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teachers implements Serializable {
    /////////////////////////////////параметры
    private int salary;
    private String name;
    private String titleOFLesson;
    private int id;
    private int bankDetails;
    private static List<Teachers> teachers = new ArrayList<>();
    private int experience;
    private String loginn;
    private String passwordd;
    private int schet = 0;
    //////////////////////////////////////////конструктор
    public Teachers(int salary, String name, String titleOFLesson, int bankDetails, int experience, String loginn, String passwordd) {

        this.experience = experience;
        this.salary = salary;
        this.name = name;
        this.titleOFLesson = titleOFLesson;
//        this.id = Schooll.genUniqueId();
        this.bankDetails = bankDetails;
        this.loginn = loginn;
        this.passwordd = passwordd;
        this.schet = getSchet();
    }
    ////////////////////////////////геттеры и сеттеры
    public int getSchet() {
        return schet;
    }
    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitleOFLesson() {
        return titleOFLesson;
    }
    public String getLoginn() {
        return loginn;
    }
    public int getId() {
        return id;
    }
    public int getBankDetails() {
        return bankDetails;
    }
    public int getExperience() {
        return experience;
    }
////////////////////////////////////////////перечисление зп
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
    ///////////////////////////////////////////////////////////////////////инфо поисковика
    public static void infoTeach() {
        for (int i = 0; i < SchoolMain.aikol.getTeachers().size(); i++) {
            System.out.println("----------------------------------");
            System.out.println("Имя преподавателя:" + SchoolMain.aikol.getTeachers().get(i).getName()
                    + "\n" + "предмет:" + SchoolMain.aikol.getTeachers().get(i).getTitleOFLesson()
                    + "\n" + "зарплата:" + SchoolMain.aikol.getTeachers().get(i).getSalary()
                    + "\n" + "банковские реквизиты: " + SchoolMain.aikol.getTeachers().get(i).getBankDetails()
                    + "\n" + "персональный номер:" + SchoolMain.aikol.getTeachers().get(i).getId()
                    + "\n" + "стаж работы:" + SchoolMain.aikol.getTeachers().get(i).getExperience()
                    + "\n" + "логин : " + SchoolMain.aikol.getTeachers().get(i).getLoginn()
                    + "\n" + "банковский счет: " + SchoolMain.aikol.getTeachers().get(i).getSchet());
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
                        SchoolMain.Vyhod();;
                        break;
                }
            } catch (Exception exception) {
                System.out.println("^*^*^*^*^*^*^_____введите число а не букву_____*^*^*^*^*^" + "\n");
            }
        }

    }
/////////////////////////////////////////////////////инфо про всех учителей
    public void infoTeachers() {
        System.out.println("----------------------------------");
        System.out.println("Имя преподавателя:" + name
                + "\n" + "предмет: " + titleOFLesson
                + "\n" + "зарплата: " + salary
                + "\n" + "банковские реквизиты: " + bankDetails
                + "\n" + "персональный номер:" + id
                + "\n" + "стаж работы:" + experience
                + "\n" + "логин : " + loginn
                + "\n" +"банковский счет: " + schet);

    }
///////////////////////////////////////////////добавление нового препода
    static void addNewteach() {
        String name = "";

        while (name == null || name.isEmpty()) {
            System.out.println("----------------------------------Введите имя нового преподавателя----------------------------------");
            System.out.println("_______Вернуться назад_____{нажмите_-_-_-_----> [0]");

            name = Sotrudnik.chekString(SchoolMain.scanner.nextLine());
        }
        if (name.equals("0")) {
            SchoolMain.glavnoemenuy();
        }

        String titleOFLesson = "";
        while (titleOFLesson == null || titleOFLesson.isEmpty()) {

            System.out.println("----------------------------------Предмет преподавателя----------------------------------");
            System.out.println("Вернуться назад  {нажмите_-_-_-_----> [0]");
            titleOFLesson = Sotrudnik.chekString(SchoolMain.scanner.nextLine());

        }
        if (titleOFLesson.equals("0")) {
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

        System.out.println("----------------------------------Придумать свой логин----------------------------------");
        System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
        String loginn = SchoolMain.scanner.nextLine();
        if (loginn.equals("0")) {
            SchoolMain.glavnoemenuy();
        }

        System.out.println("----------------------------------Придумайте пароль----------------------------------");
        System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
        String passwordd = SchoolMain.scanner.nextLine();
        if (passwordd.equals("0")) {
            SchoolMain.glavnoemenuy();
        }

        Teachers teachers1 = new Teachers(salary, name, titleOFLesson, bankDetails, experience, loginn, passwordd);
        SchoolMain.aikol.getTeachers().add(teachers1);

        System.out.println("----------------------------------Добавлен новый преподаватель----------------------------------");

        while (true) {
            System.out.println("Вы находитесь в разделе добавления нового преподавателя");
            System.out.println("_______Вернуться назад______{нажмите_-_-_-_----> [0]");
            System.out.println("_______Завершить процесс________{нажмите_-_-_-_----> [9]");
            System.out.println("________Добавить еще одного ментора________{нажмите_-_-_-_----> [6]");

            try {
                int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                if (x == 0) {
                    SchoolMain.glavnoemenuy();
                    break;
                } else if (x == 9) {
                    SchoolMain.Vyhod();

                    break;
                }else if (x == 6){
                    addNewteach();
                }
            } catch (Exception e) {
                System.err.println("____Следуйте инструкциям_____");

            }

        }
    }
}
