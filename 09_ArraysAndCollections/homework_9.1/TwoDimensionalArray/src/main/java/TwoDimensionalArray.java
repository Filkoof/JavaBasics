public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] cross = new char[7][7];

        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < cross[i].length; j++) {
                if (j == i || j == cross.length - 1 - i) {
                    cross[i][j] = symbol;
                } else {
                    cross[i][j] = ' ';
                }
            }
        }

        return cross;

    }
}



