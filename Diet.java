public class Diet extends Emission {
    // activityData = annual calories or normalized units; emissionFactor = kg CO2 per unit
    public Diet(double kgCo2PerUnit, double annualUnits) {
        super(kgCo2PerUnit, annualUnits);
    }

    @Override
    public double calculateEmission() {
        return activityData * emissionFactor;
    }
}