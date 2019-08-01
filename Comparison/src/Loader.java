
public class Loader {
    public static void main(String[] args) {
        int dimaAge = 35;
        String dimaName = "Dima";
        int mishaAge = 2;
        String mishaName = "Misha";
        int vasyaAge = 10;
        String vasyaName = "Vasya";

        int oldest;
        String oldestName;
        int youngest;
        String youngName;
        int middle;
        String middleName;

        if (dimaAge >= mishaAge && dimaAge >= vasyaAge) {
            oldest = dimaAge;
            oldestName = dimaName;

        } else if (mishaAge >= dimaAge && mishaAge >= vasyaAge){
            oldest = mishaAge;
            oldestName = mishaName;
        } else {
            oldest = vasyaAge;
            oldestName = vasyaName;
        }
        System.out.println("Старший: " + oldest + " " + oldestName);

        if (dimaAge <= mishaAge && dimaAge >= vasyaAge||(dimaAge >= mishaAge && dimaAge <= vasyaAge)) {
            middle = dimaAge;
            middleName = dimaName;
        } else {
            if (mishaAge <= dimaAge && mishaAge >= vasyaAge||mishaAge >= dimaAge && mishaAge <= vasyaAge) {
                middle = mishaAge;
                middleName = mishaName;
            } else {
                middle = vasyaAge;
                middleName = vasyaName;
            }
        }
        System.out.println("Средний: " + middle + " " + middleName);

        if (dimaAge <= mishaAge && dimaAge <= vasyaAge) {
            youngest = dimaAge;
            youngName = dimaName;
        } else if (mishaAge <= dimaAge && mishaAge <= vasyaAge){
            youngest = mishaAge;
            youngName = mishaName;
        } else {
            youngest = vasyaAge;
            youngName = vasyaName;
        }
        System.out.println("Младший: " + youngest + " " + youngName);

    }
}
