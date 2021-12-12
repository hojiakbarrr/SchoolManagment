package schoolManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SchoolMain {

//    static Schoollist schoollist;
    public static Schooll aikol;
//        = new Schooll("Высшая школа - 'Айкол'", "Ул. Манаса 95",900000, "Aikol_highschool @mail.ru", 1234567);;
    static Scanner scanner;

    public static void main(String[] args) {


//////////////////////////////////start

        ArrayList<Schooll> schoolls = new ArrayList<>();
        schoolls.add(aikol);

////////////////////////////////////////////////////////////////
        Buhgalter hamza = new Buhgalter("Хамза_бей_Орхан_оглы", "r", "r", 12345678, 6, 37000, 0);
        ArrayList<Buhgalter> buhgalters = new ArrayList<>();
        buhgalters.add(hamza);
        for (Buhgalter man : buhgalters) {
        }
/////////////////////////////////////////////////////////
        Sotrudnik bema = new Sotrudnik(7800, "Бермет_Мырзаковна", "повар", 212322, 12, "bema", "bema");
        Sotrudnik liam = new Sotrudnik(7850, "Лиам_Страйкер", "повар", 22700, 3, "liam", "liam");
        Sotrudnik martin = new Sotrudnik(12350, "Martin_Смит", "охранник", 85437, 4, "martin", "martin");
        Sotrudnik oliver = new Sotrudnik(9850, "Oliver_Джонсон", "дворник", 2103647, 3, "oliver", "oliver");
        Sotrudnik jorj = new Sotrudnik(11850, "George_Уилсон", "медбрат", 987654, 0, "jorj", "jorj");

        ArrayList<Sotrudnik> sotrudniks = new ArrayList<>();
        sotrudniks.add(bema);
        sotrudniks.add(liam);
        sotrudniks.add(martin);
        sotrudniks.add(oliver);
        sotrudniks.add(jorj);

        for (Sotrudnik tr : sotrudniks) {
        }

/////////////////////////////////////////////////
        Students bob = new Students("Bob_Marlie", 2, "bob85", "bob8558 ", 30000);
        Students charlie = new Students("Charlie_Pink", 1, "charlii", "charlie95 ", 30000);
        Students peter = new Students("Peter_Parker", 3, "parker", "parkker ", 30000);
        Students rozza = new Students("Roza_Namajunas", 1, "роза", "trevor ", 30000);
        Students kamaru = new Students("Kamaru_Usman", 2, "night", "mare ", 30000);
        Students justin = new Students("Justin_Volkanovski", 3, "onlyjust", "wolf ", 30000);

        ArrayList<Students> students = new ArrayList<>();
        students.add(bob);
        students.add(charlie);
        students.add(peter);
        students.add(rozza);
        students.add(kamaru);
        students.add(justin);
        for (Students stu : students) {
        }
////////////////////////////////////////////////


        Teachers nargiza = new Teachers(12000, "Наргиза", "информатика", 212313, 5, "nargiza", "nargiza");
        Teachers zarina = new Teachers(13500, "Зарина_Лелеко", "математика", 123231, 10, "zarina", "zarina");
        Teachers karina = new Teachers(12400, "Карина_Сабитова", "русский язык", 432543, 3, "karina", "karina");
        Teachers roza = new Teachers(13100, "Роза_Рамильевна", "математика", 543678, 12, "roza", "roza");
        Teachers umid = new Teachers(15800, "Умид_Каликов", "физкультура", 987654, 0, "umid", "umid");
        Teachers timur = new Teachers(17580, "Тимур_Нагибин", " физика", 740982, 4, "timur", "timur");

        ArrayList<Teachers> teachers = new ArrayList<>();
        teachers.add(nargiza);
        teachers.add(zarina);
        teachers.add(karina);
        teachers.add(roza);
        teachers.add(umid);
        teachers.add(timur);

        for (Teachers teacher : teachers) {

        }

//        schoollist = new Schoollist(sotrudniks,students,schoolls,buhgalters,teachers);
        aikol = new Schooll("Высшая школа - 'Айкол'", "Ул. Манаса 95",900000, "Aikol_highschool @mail.ru", 1234567,sotrudniks,students,buhgalters,teachers);

        try {

            ObjectInputStream rar = new ObjectInputStream(new FileInputStream("school"));
            aikol = (Schooll) rar.readObject();
            rar.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Что то пошло не так при сохранении");
        }

        scanner = new Scanner(System.in);
//////////////////////////////////////////////////////

//////////////////////////////////////////////
//        Sotrudnik.addNewSotrud(sotrudniks); ////добавление новых сотрудников +8
//        Students.infoStudents(students);  ////инфо про студентов + 4
//        Teachers.addNewteach(teachers);  ///добавление нового преподас + 9
//        Students.addNewStudent(students); ///добавление нового струдента + 10
//        Students.Search(sotrudniks,students,teachers); /// поиск всех + 5
//        Teachers.infoTeach(teachers); ////инфо про учителей + 2
//        Sotrudnik.infoSotrudn(sotrudniks);//инфо про всех сотрудников + 3
//        Students.infoStudents(students);  ////инфо про студентов +6
//        Schooll.aboutSchool(schoolls);  // о школе  + 1
        ///////////////////////////////////////////////
//        Human.avtorization(humans);  // авторизация - 1
//        Human.AddNewAccountant(humans);/// добавление нового сотрудника - 1
        ///////////////////////////////////////////////////////////////////////////
//        Human.VyborNaOplatu(teachers,sotrudniks,students,humans); //// оплата контракт и перевод зп и инфо про бухгалтера + 7

///////////////////////////////////////
        menyu();
//        glavnoemenuy(teachers,students,sotrudniks,buhgalters,schoolls);

    }


    public static void menyu() {


        boolean temp = false;
        boolean temp11 = false;

        while (true) {
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_Авторизация_-_-_-_-_-{нажмите_-_-_-_-_-_----> [1]");
            System.out.println("_-_-_-_-_-_-_-_Добавить нового пользователя_-_-_-_-_-{нажмите_-_-_-_-_-_----> нажмите [2]");
            try {
                int x = Integer.parseInt(scanner.nextLine());
                switch (x) {
                    case 1:
                        Buhgalter.avtorization();
                        temp = true;
                        break;
                    case 2:
                        Buhgalter.AddNewAccountant();
                        temp11 = true;
                        break;

                }
            } catch (NumberFormatException exception) {
                System.err.println("^*^*^*^*^*^*^_____Следуйте инструкциям_____*^*^*^*^*^" + "\n");
            }
            if (temp) {
                glavnoemenuy();
            }
            if (temp11){
                menyu();
            }
        }
    }

    public static void glavnoemenuy() {

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_Добро пожаловать в систему управления школы -'Айкол'_-_-_-_-_-_-_-_-_-_-_-_" + "\n");
        while (true) {

            System.out.println("Информация о школе {нажмите_-_-_-_----> [1]");
            System.out.println();

            System.out.println("Информация про всех преподавателях {нажмите_-_-_-_-_-_----> [2]");
            System.out.println();

            System.out.println("Информация про всех сотрудников школы {нажмите_-_-_-_-_----> [3]");
            System.out.println();

            System.out.println("Информация про всех студентов {нажмите_-_-_-_-_-_----> [4]");
            System.out.println();

            System.out.println("Поиск человека по базе школы {нажмите_-_-_-_-_-_----> [5]");
            System.out.println();

            System.out.println("Управление бюджетом школы(контракт и зп) {нажмите_-_-_-_----> [6]");
            System.out.println();

            System.out.println("Добавить нового сотрудника {нажмите_-_-_-_-_----> [7]");
            System.out.println();

            System.out.println("Добавить нового преподавателя {нажмите_-_-_-_----> [8]");
            System.out.println();

            System.out.println("Добавить нового студента {нажмите_-_-_-_----> [9]");
            System.out.println();

            System.out.println("Выход из системы {нажмите_-_-_-_-_----> [0]");
            System.out.println();
            try {

                int x = Integer.parseInt(scanner.nextLine());

                switch (x) {
                    case 1:
                        Schooll.aboutSchool();
                        break;
                    case 2:
                        Teachers.infoTeach();
                        break;
                    case 3:
                        Sotrudnik.infoSotrudn();
                        break;
                    case 4:
                        Students.infoStudents();
                        break;
                    case 5:
                        Students.Search();
                        break;
                    case 6:
                        Buhgalter.VyborNaOplatu();
                        break;
                    case 7:
                        Sotrudnik.addNewSotrud();
                        break;
                    case 8:
                        Teachers.addNewteach();
                        break;
                    case 9:
                        Students.addNewStudent();
                        break;
                    case 0:
                       Vyhod();
                        break;
                }

            } catch (Exception exception) {
                System.err.println("^*^*^*^*^*^*^_____Следуйте инструкциям_____*^*^*^*^*^" + "\n");
            }

        }
    }

    public static void Vyhod() {
        System.out.println();
        System.out.println("-----> Изменения сохранены <-----");
        System.out.println("...............Bye.............");
        try {
            ObjectOutputStream rfr = new ObjectOutputStream(new FileOutputStream("school"));

            rfr.writeObject(aikol);
            rfr.close();


        } catch (IOException e) {
            System.out.println("Данные не сохранились !!!");
        }

        System.exit(0);
    }



}
