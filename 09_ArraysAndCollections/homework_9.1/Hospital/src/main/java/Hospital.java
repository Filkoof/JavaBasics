public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] patientTemperature = new float[patientsCount];

        for(int i = 0; i < patientsCount; i++){
            patientTemperature[i] = Math.round((float) (Math.random() * ((40 - 32) + 1)) + 32);
        }

        return patientTemperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        String report =
                "Температуры пациентов: " + 0 +
                        "\nСредняя температура: " + 0 +
                        "\nКоличество здоровых: " + 0;

        return report;
    }
}
