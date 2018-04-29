package command;

abstract public class Command {

//    abstract boolean undo(); // отметить/повторить
//    abstract boolean rendo();

    abstract boolean execute(); //метод который выполняет команды

    // На каждую команду свой класс, которые наследуют этот класс и реализуют метод execute()

}
