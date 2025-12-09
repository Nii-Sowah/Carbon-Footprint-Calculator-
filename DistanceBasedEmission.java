public class DistanceBasedEmission extends Emission {
    private double distanceKm;

    public DistanceBasedEmission(double emissionFactor, double distanceKm) {
        super(emissionFactor,distanceKm);
        this.distanceKm = distanceKm;
    }

    @Override
    public double calculateEmission() {
        return distanceKm * emissionFactor;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
        this.activityData = distanceKm;
    }
}


