package core;

public class Car
{
    private String number; //Создание переменной
    private Integer height; //Создание переменной
    private Double weight; //Создание переменной
    private Boolean hasVehicle; //Создание переменной
    private Boolean isSpecial; //Создание переменной

    public Car(String carNumber, Integer carHeight, Double carWeight, Boolean carHasVehicle)
    {
        number = carNumber;
        height = carHeight;
        weight = carWeight;
        hasVehicle = carHasVehicle;
        isSpecial = false;
    }

    //=========================================================================

    public void setIsSpecial()
    {
        isSpecial = true;
    }

    //=========================================================================

    public String getNumber()
    {
        return number;
    }

    public Integer getHeight()
    {
        return height;
    }

    public Boolean isSpecial()
    {
        return isSpecial;
    }

    public Boolean hasVehicle()
    {
        return hasVehicle;
    }

    //=========================================================================

    Double getWeight()
    {
        return weight;
    }

    //=========================================================================

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}