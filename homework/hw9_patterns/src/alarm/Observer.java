package alarm;

public class Observer {

    /*2. Реализовать сигнализации, реагирующие на повышение температуры (Observer).
    Класс Sensor инкрементально повышает температуру, и на каждое изменение температуры оповещает слушателей
            (сигнализации). Их должно быть три, соответствующие уровням тревоги: Green (100), Yellow (300), Red (600).

    Описываете интерфейс Alarm, имеющий метод void tempChanged(int temp),
    и подписываете три реализации к датчику на оповещения.

    Сигнализации сработают по преодолению определенного порога температуры:
            100 градусов - Green
    300 градусов - Green, Yellow
    600 градусов - Green, Yellow, Red

    Срабатывание - вывод в консоль сообщения.
    Если сигнализация сработала, то сообщение не повторяется на дальнейшее повышение температуры,
    но если опустится ниже порога, а потом опять преодолеет, то выведется снова.
    */

    public static void main(String[] args) throws InterruptedException {

        Sensor sensor = new Sensor();
        sensor.subscribe(new Green());
        sensor.subscribe(new Yellow());
        sensor.subscribe(new Red());

        sensor.genTemp();

    }

}
