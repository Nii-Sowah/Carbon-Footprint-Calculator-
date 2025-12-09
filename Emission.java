/**
 * Base abstraction for a carbon-emitting activity or source.
 * Emission is modeled as: emission = emissionFactor * activityData.
 *
 * emissionFactor: how much CO2 per unit of activity (e.g., kg CO2 per km/kWh).
 * activityData: the amount of activity performed (e.g., km driven, kWh used).
 */
public abstract class Emission {
    /** kg CO2 emitted per unit of activity (e.g., per km, per kWh). */
    protected double emissionFactor;
    /** Quantity of the activity performed (distance, energy, calories, etc.). */
    protected double activityData;

    /**
     * Construct an emission source.
     * @param emissionFactor kg CO2 per unit
     * @param activityData amount of activity performed
     */
    protected Emission(double emissionFactor, double activityData) {
        this.emissionFactor = emissionFactor;
        this.activityData = activityData;
    }

    /** @return current emission factor (kg CO2 per unit). */
    public double getEmissionFactor() { return emissionFactor; }
    /** Set a new emission factor.
     * @param emissionFactor kg CO2 per unit
     */
    public void setEmissionFactor(double emissionFactor) { this.emissionFactor = emissionFactor; }

    /** @return activity amount used to compute emissions. */
    public double getActivityData() { return activityData; }
    /** Set activity amount used to compute emissions.
     * @param activityData quantity of activity (km, kWh, etc.)
     */
    public void setActivityData(double activityData) { this.activityData = activityData; }

    /**
     * Compute emissions in kg CO2 for this source.
     * Subclasses may override to add domain-specific logic.
     */
    public abstract double calculateEmission();
}


