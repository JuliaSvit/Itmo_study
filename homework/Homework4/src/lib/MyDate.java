package lib;

import java.util.Objects;

public class MyDate {
    private String fullDate;
    private int day;
    private int month;
    private int year;

    private int hour;
    private int minute;

    public MyDate (String str) {
        this.fullDate = str;
        String [] nStr = str.split(" ");
        String [] nStr1 = nStr[0].split("\\.");
        this.day = Integer.parseInt(nStr1[0]);
        this.month = Integer.parseInt(nStr1[1]);
        this.year = Integer.parseInt(nStr1[2]);
        if (nStr.length == 2){
            String [] nStr2 = nStr[1].split(":");
            this.hour = Integer.parseInt(nStr2[0]);
            this.minute = Integer.parseInt(nStr2[1]);
        }


    }

    public String getDate(){
        return this.fullDate;
    }

    public int intervalDateYear(MyDate myDate){
        int minus = 0;
        int d = myDate.day - this.day - minus;
        minus = 0;
        if (d < 0) {minus++; d += 30;}
        int mo = myDate.month - this.month - minus;
        minus = 0;
        if (mo < 0) {minus++; mo += 12;}
        int y = myDate.year - this.year - minus;
        return y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.fullDate);
        hash = 59 * hash + this.day;
        hash = 59 * hash + this.month;
        hash = 59 * hash + this.year;
        hash = 59 * hash + this.hour;
        hash = 59 * hash + this.minute;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyDate other = (MyDate) obj;
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.hour != other.hour) {
            return false;
        }
        if (this.minute != other.minute) {
            return false;
        }
        if (!Objects.equals(this.fullDate, other.fullDate)) {
            return false;
        }
        return true;
    }

    public int getDay(){
        return this.day;

    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int compare (MyDate myDate){
        if (this.year > myDate.year){
            return 1;
        } else if(this.year < myDate.year){
            return -1;
        } else if(this.month > myDate.month){
            return 1;
        } else if(this.month < myDate.month){
            return -1;
        } else if(this.day > myDate.day){
            return 1;
        } else if(this.day < myDate.day){
            return -1;
        } else if(this.hour > myDate.hour){
            return 1;
        } else if(this.hour < myDate.hour){
            return -1;
        } else if(this.minute > myDate.minute){
            return 1;
        } else if(this.minute < myDate.minute){
            return -1;
        }
        return 0;
    }

}
