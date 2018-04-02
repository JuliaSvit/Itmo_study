package diary;

import lib.MyDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Diary {

    private String name;
    private ArrayList <Pages> pages = new ArrayList<>();
    private ArrayList<MyDate> bookmark = new ArrayList<>(); // закладки

    public Diary(String name){
        this.name = name;
    }

    public void newNote (MyDate dateNote, String note, boolean bookmark){ // добавляем новую запись
        this.pages.add(new Pages(dateNote, note));
        if(bookmark){
            this.bookmark.add(dateNote);
        }
        if (pages.size() > 0){
            Collections.sort(pages, new Comparator<Pages>() {
                public int compare(Pages o1, Pages o2) {
                    return o1.compare(o2);
                }
            });
        }
    }

    public void getTimeNote (MyDate dateTimeNote){ // просмотр записи за определённую дату и время
        System.out.println("Ищем запись за " + dateTimeNote.getDate());
        boolean tr = true;
        for (Pages p: this.pages){
            if (p.getDateNote().equals(dateTimeNote)) {
                System.out.println(p.getNote());
                tr = false;
            }
        }
        if (tr){
            System.out.println ("На эту дату записей нет");
        }
    }

    public void getDateNote (MyDate dateDateNote){ //просмотреть записи за день
        System.out.println("Ищем запись за " + dateDateNote.getDate());
        boolean tr = true;
        for (Pages p: this.pages){
            if (p.getDateNote().getDay() == dateDateNote.getDay()&&
                    p.getDateNote().getMonth() == dateDateNote.getMonth()&&
                    p.getDateNote().getYear() == dateDateNote.getYear()) {
                System.out.println(p.getDateNote().getDate() + "\n" + p.getNote());
                tr = false;
            }
        }
        if (tr){
            System.out.println ("На эту дату записей нет");
        }

    }

    public void getName() {  // получить название ежедневника
        System.out.println(name);
    }

    public void showAllNote(){ //просмотреть все записи
        System.out.println(this.name);
        for (Pages p: this.pages){
            System.out.println(p.getDateNote().getDate() + "\n" + p.getNote());
        }
    }

    public void bookmarkNote(){ //посмотреть все закладки
        System.out.println("Закладки:");
        for (MyDate str: this.bookmark){
            for (Pages p: this.pages){
                if (p.getDateNote().equals(str)){
                    System.out.println(p.getDateNote().getDate() + "\n" + p.getNote());
                    break;
                }
            }
        }
    }

    public void delNote(MyDate myDate){ //удаление записи
        for (Pages p: this.pages){
            if (p.getDateNote().equals(myDate)){
                this.pages.remove(p);
                break;
            }
        }
    }

}
