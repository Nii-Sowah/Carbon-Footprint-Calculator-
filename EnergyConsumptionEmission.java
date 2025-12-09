public class EnergyConsumptionEmission extends Emission {
    private double energyKWh;

    public EnergyConsumptionEmission(double emissionFactor,double activityData , double energyKWh) {
        super(emissionFactor, activityData);
        this.energyKWh = energyKWh;
    }

    @Override
    public double calculateEmission() {
        return energyKWh * emissionFactor;
    }

    public double getEnergyKWh() {
        return energyKWh;
    }

    public void setEnergyKWh(double energyKWh) {
        this.energyKWh = energyKWh;
        this.activityData = energyKWh;

        }
    }


