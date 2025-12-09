import java.util.Map;

/**
 * CalculationEngine centralizes computations so the UI (CLI/GUI)
 * doesn't need to know implementation details of {@link User}.
 */
public class CalculationEngine {
    /** Compute the user's total carbon footprint. */
    public static double computeTotal(User u) {
        if (u == null) return 0.0;
        return u.getTotalCarbonFootprint();
    }

    /**
     * Provide a simple labeled breakdown to display in reports.
     * Keys are human-readable category names.
     */
    public static Map<String, Double> breakdown(User u) {
        Map<String, Double> map = new java.util.LinkedHashMap<>();
        if (u == null) return map;
        map.put("Vehicles", u.vehiclesEmission());
        map.put("Home", u.homeEmission());
        map.put("Diet", u.dietEmission());
        map.put("Total", computeTotal(u));
        return map;
    }
}