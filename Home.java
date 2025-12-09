public class Home extends Emission {
    // activityData = monthly kWh; emissionFactor = kg CO2 per kWh
    public Home(double kgCo2PerKWh, double monthlyKWh) {
        super(kgCo2PerKWh, monthlyKWh);
    }

    @Override
    public double calculateEmission() {
        // Annualize: 12 * monthlyKWh * kgCO2/kWh
        return 12 * activityData * emissionFactor;
    }
}