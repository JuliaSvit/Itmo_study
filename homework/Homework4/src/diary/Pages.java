package diary;
import lib.MyDate;

class Pages {

    private MyDate dateNote;
    private String note;

    protected Pages(MyDate dateNote, String note){
        this.dateNote = dateNote;
        this.note = note;
    }

    protected MyDate getDateNote() {
        return dateNote;
    }

    protected String getNote() {
        return note;
    }

    protected int compare(Pages pages){
        if (this.getDateNote().getYear() > pages.getDateNote().getYear()){
            return 1;
        } else if(this.getDateNote().getYear() < pages.getDateNote().getYear()){
            return -1;
        } else if(this.getDateNote().getMonth() > pages.getDateNote().getMonth()){
            return 1;
        } else if(this.getDateNote().getMonth() < pages.getDateNote().getMonth()){
            return -1;
        } else if(this.getDateNote().getDay() > pages.getDateNote().getDay()){
            return 1;
        } else if(this.getDateNote().getDay() < pages.getDateNote().getDay()){
            return -1;
        } else if(this.getDateNote().getHour() > pages.getDateNote().getHour()){
            return 1;
        } else if(this.getDateNote().getHour() < pages.getDateNote().getHour()){
            return -1;
        } else if(this.getDateNote().getMinute() > pages.getDateNote().getMinute()){
            return 1;
        } else if(this.getDateNote().getMinute() < pages.getDateNote().getMinute()){
            return -1;
        }
            return 0;
    }


}




