public class Hospital {

    private static final float MIN_TEMPERATURE = 36.2f;
    private static final float MAX_TEMPERATURE = 36.9f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] patientTemperature = new float[patientsCount];

        for(int i = 0; i < patientsCount; i++){
            float value = ((float) (Math.random() * ((40 - 32) + 1)) + 32);
            patientTemperature[i] = value;
        }

        return patientTemperature;
    }

    public static String getReport(float[] temperatureData) {

        float sumTemperature = 0;
        float temperatures;
        int healthCount = 0;
        String temperaturesPatients = "";

        for(int i = 0; i< temperatureData.length; i++) {
            sumTemperature += temperatureData[i];
            temperaturesPatients = temperaturesPatients.concat
                    (String.valueOf((float) (Math.round((temperatureData[i]) *
                    Math.pow(10, 1)) / Math.pow(10, 1)))).concat(" ");
            temperatures = (float) (Math.round((temperatureData[i]) * Math.pow(10, 1)) / Math.pow(10, 1));
            if(temperatures >= MIN_TEMPERATURE && temperatures <= MAX_TEMPERATURE) {
                healthCount++;
            }
        }

        float averageTemperature = (float) (Math.round((sumTemperature / temperatureData.length)
                * Math.pow(10, 2)) / Math.pow(10, 2));

        String averageTemperaturePatients = Float.toString(averageTemperature);
        String healthCountPatients = Integer.toString(healthCount);

        String report =
                "Температуры пациентов: " + temperaturesPatients.trim()  +
                        "\nСредняя температура: " + averageTemperaturePatients +
                        "\nКоличество здоровых: " + healthCountPatients;

        return report;
    }
}
