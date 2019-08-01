import core.*;
import core.Camera;

public class RoadController
{
    public static Double passengerCarMaxWeight = 3500.0; // kg Создание переменной
    public static Integer passengerCarMaxHeight = 2000; // mm Создание переменной
    public static Integer controllerMaxHeight = 3500; // mm Создание переменной

    public static Integer passengerCarPrice = 100; // RUB Создание переменной
    public static Integer cargoCarPrice = 250; // RUB Создание переменной
    public static Integer vehicleAdditionalPrice = 200; // RUB Создание переменной

    public static Integer maxOncomingSpeed = 60; // km/h Создание переменной
    public static Integer speedFineGrade = 20; // km/h Создание переменной
    public static Integer finePerGrade = 500; // RUB Создание переменной
    public static Integer criminalSpeed = 160; // km/h Создание переменной

    public static void main(String[] args)
    {
        for(Integer i = 0; i < 10; i++)
        {
            Car car = Camera.getNextCar(); //Создание переменной (объекта класса Car)
            System.out.println(car);
            System.out.println("Скорость: " + Camera.getCarSpeed(car) + " км/ч");


            /**
             * Проверка на наличие номера в списке номеров нарушителей
             */
            Boolean policeCalled = false;
            for(String criminalNumber : Police.getCriminalNumbers())
            {
                String carNumber = car.getNumber();
                if(carNumber.equals(criminalNumber)) {
                    Police.call("автомобиль нарушителя с номером " + carNumber);
                    blockWay("не двигайтесь с места! За вами уже выехали!");
                    break;
                }
            }
            if(Police.wasCalled()) {
                continue;
            }


            /**
             * Пропускаем автомобили спецтранспорта
             */
            if(car.isSpecial()) {
                openWay();
                continue;
            }

            /**
             * Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
             */
            Integer carHeight = car.getHeight(); //Создание переменной
            Integer price = 0; //Создание переменной
            if(carHeight > controllerMaxHeight)
            {
                blockWay("высота вашего ТС превышает высоту пропускного пункта!");
                continue;
            }
            else if(carHeight > passengerCarMaxHeight)
            {
                Double weight = WeightMeter.getWeight(car); //Создание переменной
                //Грузовой автомобиль
                if(weight > passengerCarMaxWeight || weight > passengerCarMaxWeight)
                {
                    price = cargoCarPrice;
                    if(car.hasVehicle()) {
                        price = price + vehicleAdditionalPrice;
                    }
                }
                //Легковой автомобиль
                else {
                    price = passengerCarPrice;
                }
            }
            else {
                price = passengerCarPrice;
            }

            /**
             * Проверка скорости подъезда и выставление штрафа
             */
            Integer carSpeed = Camera.getCarSpeed(car); //Создание переменной
            if(carSpeed > criminalSpeed)
            {
                Police.call("cкорость автомобиля - " + carSpeed + " км/ч, номер - " + car.getNumber());
                blockWay("вы значительно превысили скорость. Ожидайте полицию!");
                continue;
            }
            else if(carSpeed > maxOncomingSpeed)
            {
                Integer overSpeed = carSpeed - maxOncomingSpeed; //Создание переменной
                Integer totalFine = finePerGrade * (1 + overSpeed / speedFineGrade); //Создание переменной
                System.out.println("Вы превысили скорость! Штраф: " + totalFine + " руб.");
                price = price + totalFine;
            }

            /**
             * Отображение суммы к оплате
             */
            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }

    }

    /**
     * Открытие шлагбаума
     */
    public static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    public static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}