import lib.MyDate;
import school.*;
import diary.Diary;

public class Homework4 {

    public static void main (String [] args){


        /*Доделать для калькулятора классы деления (не забудьте про 0), умножения и вычитания.
        * сделано в Itmo_study/Lessons/Lessons4/src/*/

        /*1. Представьте себе школу, подумайте, как можно спроектировать эту систему на классах,
        выделите основные сущности и подумайте, какие у них будут возможности.
        На основе этого опишите классы и методы (Сколько успеете!)*/
/*
        School school = new School("Школа № 1","СПб, проспект Ленина", 2, 4,20);

        // учителя и ученики
        Teacher t = new Teacher("Томара Ивановна", new MyDate("02.09.1988"), "Учитель", false,"Математика");
        Teacher t1 = new Teacher("Марья Ивановна", new MyDate("15.03.1984"), "Учитель", false,"Русский язык");
        Teacher t2 = new Teacher("Елена Влодимировна", new MyDate("11.10.1971"), "Учитель", false,"Физика");
        Teacher t3 = new Teacher("Людмила Григорьевна", new MyDate("20.12.1990"), "Учитель", false,"Информатика");
        Pupil pupil1 = new Pupil("Иван", new MyDate("10.03.2012"), "Ученик", true);
        Pupil pupil2 = new Pupil("Катя", new MyDate("15.07.2006"), "Ученик", false);
        Pupil pupil3 = new Pupil("Женя", new MyDate("25.10.2007"), "Ученик", true);

        // регистрация учеников
        school.enroll(pupil1);
        school.enroll(pupil2);
        school.enroll(pupil3);
        //приём учителей
        school.getTeacher(t);
        school.getTeacher(t1);
        school.getTeacher(t2);
        school.getTeacher(t3);

        //сождание классов и назначение классных руководителей
        school.setGroup("1В",t1);
        school.setGroup("5А",t2);
        school.setGroup("10Б",t3);
        school.setGroup("4Б",t);
        school.setGroup("8Б",t);

        //распределение детей в классы

        school.enrollInGroup(pupil1);
        school.enrollInGroup(pupil2);
        school.enrollInGroup(pupil3);
*/
        /*
        2. Мы будем делать ежедневник. Для начала также нужно выдельть основные классы и методы и описать их.
        Классы и медоты выделяйте и описывайте на свое усмотрение, потом обсудим!
        Не забывайте про наследование и модификаторы доступа
         */

        Diary diary = new Diary("Мой первый ежедневник");
        diary.newNote(new MyDate("01.03.2018 16:30"), "Сегодня замечательный весенний день", true);
        diary.newNote(new MyDate("01.04.2018 15:00"), "Первое апреля, никому не вею", false);
        diary.newNote(new MyDate("15.03.2018 10:45"), "Сегодня хуже чем вчера, всё задом на перёд", true);
        diary.newNote(new MyDate("10.02.2018 09:00"), "Ура, скоро зарплата, будем жить", false);
        diary.newNote(new MyDate("10.02.2018 11:00"), "Деловая встреча", true);
        diary.newNote(new MyDate("10.02.2018 21:00"), "Бар с друзьями", false);

//        diary.bookmarkNote();
//        diary.getName();
//        diary.getTimeNote(new MyDate("15.03.2018 10:45"));
        diary.showAllNote();
//        diary.getDateNote(new MyDate("10.02.2018"));



    }

}
