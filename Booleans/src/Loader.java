
public class Loader
{
    public static void main(String[] args)
    {
        Integer milkAmount = 200; // ml
        Integer powderAmount = 300; // g
        Integer eggsCount = 5; // items
        Integer sugarAmount = 5; // g
        Integer oilAmount = 30; // ml
        Integer appleCount = 8;

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (powderAmount >=400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30)
            System.out.println("U can make pancakes");
        else
            System.out.println("U cannot make pancakes");

        //milk - 300 ml, powder - 5 g, eggs - 5
        if (powderAmount >=5 && milkAmount >= 300 && eggsCount >= 5)
            System.out.println("U can make omelet");
        else
            System.out.println("U cannot make omelet");

        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        if (appleCount >=3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4)
            System.out.println("U can make apple pie");
        else
            System.out.println("U cannot make apple pie");
    }
}