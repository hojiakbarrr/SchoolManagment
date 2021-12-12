package schoolManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Schooll implements Serializable {
    //    private static int budget = 1000000;
//    private int budget;
    ///////////////////////////параметры
    private int budjet;
    private String name;
    private String address;
    private String сontactInformation;
    private int bankDetails;
    public static List<Integer> ids = new ArrayList<>();
    /////////////////////////////////////////////////////////////
    private ArrayList<Sotrudnik> sotrudniks;
    private ArrayList<Students> students;
    private ArrayList<Schooll> schoolls;
    private ArrayList<Buhgalter> buhgalters;
    private ArrayList<Teachers> teachers;


    public ArrayList<Sotrudnik> getSotrudniks() {
        return sotrudniks;
    }

    public void setSotrudniks(ArrayList<Sotrudnik> sotrudniks) {
        this.sotrudniks = sotrudniks;
    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }

    public ArrayList<Schooll> getSchoolls() {
        return schoolls;
    }

    public void setSchoolls(ArrayList<Schooll> schoolls) {
        this.schoolls = schoolls;
    }

    public ArrayList<Buhgalter> getBuhgalters() {
        return buhgalters;
    }

    public void setBuhgalters(ArrayList<Buhgalter> buhgalters) {
        this.buhgalters = buhgalters;
    }

    public ArrayList<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teachers> teachers) {
        this.teachers = teachers;
    }


    ///////////////////////////конструктор
    public Schooll(String name, String address, int budjet, String сontactInformation, int bankDetails, ArrayList<Sotrudnik> sotrudniks,
                   ArrayList<Students> students,
                   ArrayList<Buhgalter> buhgalters,
                   ArrayList<Teachers> teachers) {
        this.name = name;
        this.address = address;
        this.сontactInformation = сontactInformation;
        this.bankDetails = bankDetails;
        this.budjet = budjet;
        this.sotrudniks = sotrudniks;
        this.students = students;
        this.schoolls = schoolls;
        this.buhgalters = buhgalters;
        this.teachers = teachers;
    }

    ////////////////////////////////////////////////геттеры

    //////////////////////////////////////минус бюджета
    static void minusBudget(int salary) {
        while (true) {
            try {
                if (salary >= SchoolMain.aikol.getBudjet()) {
                    System.out.println();
                    System.out.println("_*_*_*_*_*_*_-_Денег не осталось_-_*_*_*_*_*_*_");
                    System.out.println("_*_*_*_*_*_*_-_Выйти  с этого раздела нажмите 0_-_*_*_*_*_*_*_");
                    int x = Integer.parseInt(SchoolMain.scanner.nextLine());
                    if (x == 0) {
                        Buhgalter.VyborNaOplatu();
                        break;
                    }
                } else {
                    SchoolMain.aikol.setBudjet(SchoolMain.aikol.getBudjet() - salary);
                }
                break;
            } catch (Exception e) {
                System.err.println("_*_*_*_*_*_*_*_Следуйте инструкциям_*_*_*_*_*_*_*_");
            }

        }

    }


    //////////////////////////добавление бюджета
    static void addDudget(int paycontractt) {
        SchoolMain.aikol.setBudjet(SchoolMain.aikol.getBudjet() + paycontractt);
    }

    ////////////////////////////////инфо про школу
    public static void aboutSchool() {
            System.out.println();
            System.out.println("Название учебного заведения -> " + SchoolMain.aikol.name
                    + "\n" + "Адрес -> " + SchoolMain.aikol.address
                    + "\n" + "Контактные данные -> " + SchoolMain.aikol.сontactInformation
                    + "\n" + "Банковские ревкизиты для оплаты контракта -> " + SchoolMain.aikol.bankDetails
                    + "\n" + "Бюджет -> " + SchoolMain.aikol.getBudjet());


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


    //////////////


    ///////////////////////////////уникальный код
    public static int genUniqueId() {
        int id;
        while (true) {
            id = (int) (Math.random() * 899) + 100;
            if (checkForDuplicates(id)) {
                ids.add(id);
                break;
            }
        }
        return id;
    }

    ///////////////////////////////////проверка кода
    private static boolean checkForDuplicates(int id) {
        for (int i : ids) {
            if (i == id) {
                return false;
            }
        }
        return true;


    }

    public int getBudjet() {
        return budjet;
    }

    public void setBudjet(int budjet) {
        this.budjet = budjet;
    }
}





