import java.util.ArrayList;
import java.util.List;

/**
 * User aggregates all sources of emissions for a person:
 * - A list of vehicles (0..n)
 * - One home (optional)
 * - One diet (optional)
 * Provides helpers to compute per-source and total emissions.
 */
public class User {
    /** Immutable user identifier (e.g., provided by the GUI). */
    private final String userId;
    /** Display name for the user. */
    private String name;
    /** Vehicles owned by the user (may be empty). */
    private final List<Vehicle> vehicles = new ArrayList<>();
    /** Home energy usage (optional). */
    private Home home;
    /** Diet emissions model (optional). */
    private Diet diet;

    /** Construct a new user with id and name. */
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    /** @return user id. */
    public String getUserId() { return userId; }
    /** @return user name. */
    public String getName() { return name; }
    /** Set a new display name. */
    public void setName(String name) { this.name = name; }

    /** @return modifiable list of vehicles. */
    public List<Vehicle> getVehicles() { return vehicles; }
    /** Add a vehicle to the list (ignored if null). */
    public void addVehicle(Vehicle v) { if (v != null) vehicles.add(v); }

    /** @return current home model or null. */
    public Home getHome() { return home; }
    /** Set/replace the home model. */
    public void setHome(Home home) { this.home = home; }

    /** @return current diet model or null. */
    public Diet getDiet() { return diet; }
    /** Set/replace the diet model. */
    public void setDiet(Diet diet) { this.diet = diet; }

    /** @return total emissions from all vehicles. */
    public double vehiclesEmission() {
        double sum = 0.0;
        for (Vehicle v : vehicles) sum += v.calculateEmission();
        return sum;
    }

    /** @return emissions from home or 0 if not set. */
    public double homeEmission() { return home == null ? 0.0 : home.calculateEmission(); }
    /** @return emissions from diet or 0 if not set. */
    public double dietEmission() { return diet == null ? 0.0 : diet.calculateEmission(); }

    /** @return sum of vehicles, home, and diet emissions. */
    public double getTotalCarbonFootprint() {
        return vehiclesEmission() + homeEmission() + dietEmission();
    }
}