/**
 * Abstract vehicle that emits CO2 proportional to its travel distance.
 * Uses efficiency (kg CO2 per km) as the emission factor and annual distance
 * in km as the activity data.
 */
public abstract class Vehicle extends Emission {
    /** Identifier for the vehicle (e.g., registration or internal id). */
    private final String id;
    /** Fuel type description (e.g., petrol, diesel, electric). */
    private final String fuelType;
    /** Efficiency in kg CO2 per km (emission factor). */
    private final double efficiency;

    /**
     * Create a vehicle emission source.
     * @param id identifier for the vehicle
     * @param fuelType fuel type description
     * @param efficiency kg CO2 per km
     * @param distanceKm annual distance in km
     */
    protected Vehicle(String id, String fuelType, double efficiency, double distanceKm) {
        super(efficiency, distanceKm); // emissionFactor = efficiency; activityData = distanceKm
        this.id = id;
        this.fuelType = fuelType;
        this.efficiency = efficiency;
    }

    /** @return vehicle identifier. */
    public String getId() { return id; }
    /** @return fuel type string. */
    public String getFuelType() { return fuelType; }
    /** @return efficiency in kg CO2 per km. */
    public double getEfficiency() { return efficiency; }

    /**
     * Update the annual distance driven (km), used as activity data.
     * @param distanceKm new annual distance in km
     */
    public void setDistanceKm(double distanceKm) { this.activityData = distanceKm; }

    /** Base emission calculation: distance * efficiency. */
    @Override
    public double calculateEmission() { return activityData * emissionFactor; }
}
