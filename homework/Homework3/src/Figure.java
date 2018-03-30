
/* Задание № 2 */

import java.util.ArrayList;

public class Figure {

    private int[][]coord;
    private ArrayList <Double> side = new ArrayList<>();

    //  записываем координаты и сразу считаем длины сторон
    public Figure(int[][]coord){

        this.coord = new int[coord.length][];
        System.arraycopy(coord, 0, this.coord, 0, coord.length);

        for(int i = 0; i < coord.length; i++){
            if (i == coord.length-1 && coord.length > 2){
                side.add(distance(coord[i], coord[0]));
            } else if (coord.length > 2){
                side.add(distance(coord[i], coord[i+1]));
            } else {
                side.add(distance(coord[i], coord[i+1]));
                break;
            }
        }
    }

    //расстояние между двумя точками заданными координатами
    private double distance(int[]a,int[]b){
        double d;
        int x1, x2, y1, y2;
        x1 = a[0];
        y1 = a[1];
        x2 = b[0];
        y2 = b[1];
        d = Math.sqrt(Math.pow((x2 - x1), 2)+ Math.pow((y2 - y1), 2));
        return d;
    }

    //рачсёт периметра фигуры
    public double perimeter(){
        double p = 0;
        if (this.side.size() > 1){
            for(double s: side){
                p += s;
            }
        } else {
            p = 2 * 3.14 * side.get(0);
        }
        return p;
    }

    //Расчёт площади фигуры
    public double area(){
        double s = 0;
        for(int i = 0; i < this.coord.length; i++){
            if (i == this.coord.length-1 && coord.length > 2){
                s += forArea(this.coord[i], this.coord[0]);
            }else if (this.coord.length > 2){
                s += forArea(this.coord[i], this.coord[i+1]);
            } else {
                s = 3.14 * Math.pow(this.side.get(i), 2);
                return s;
            }
        }

        return Math.abs(s/2);
    }

    //доп метод для расчёта площади фигуры
    private double forArea(int[]a,int[]b){
        double s;
        int x1, x2, y1, y2;
        x1 = a[0];
        y1 = a[1];
        x2 = b[0];
        y2 = b[1];
        s = (x1 + x2) * (y2 - y1);
        return s;
    }

}
