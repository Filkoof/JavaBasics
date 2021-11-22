import java.math.BigDecimal;

public class GeometryCalculator {
    private static double circleSquare;
    private static double sphereVolume;
    private static double triangleSquare;

    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        Math.abs(radius);
        circleSquare = Math.PI * Math.pow(radius, 2);
        return circleSquare ;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        Math.abs(radius);
        sphereVolume = Math.PI * Math.pow(Math.abs(radius), 3) * 4 / 3;
        return sphereVolume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if (a + b > c && b + c > a && c + a > b) {
            return true;
        } else {
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        if(isTrianglePossible(a,b,c)) {
            triangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return triangleSquare;
        } else {
            System.out.println("Triangle is not possible ");
            return -1.0;
        }
    }
}
