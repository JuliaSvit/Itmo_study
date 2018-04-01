package lib;

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
}
