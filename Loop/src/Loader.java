public class Loader {
    public static void main(String[] args) {

//        for(int i=200000; i<235001; i++){
//            if(i<210001 || i>219999){
//                System.out.println("Билет №" + i);
//            }
//        }

        int i=200000;
        while (i<235001) {
            if(i<210001 || i>219999){
                System.out.println("Билет №" + i);
            }
            i++;
        }
    }
}
