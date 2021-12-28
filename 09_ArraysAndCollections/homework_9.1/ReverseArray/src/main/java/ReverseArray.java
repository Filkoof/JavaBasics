public class ReverseArray {

    public static String[] reverse (String[] strings){

        int size = strings.length;

        for(int i = 0; i < size / 2; i++){
            String temp = strings[i];
            strings[i] = strings[size - 1 - i];
            strings[size - 1 - i] = temp;
        }

        return strings;
    }
}
