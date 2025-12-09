import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AppCLI.banner();
            System.out.print("Enter user ID (default: u001): ");
            String userId = sc.nextLine().trim();

            if (userId.isEmpty()) userId = "u001";
            System.out.print("Enter user name (default: Alex): ");
            String name = sc.nextLine().trim();
            
            if (name.isEmpty()) name = "Alex";
            User user = new User(userId, name);

            boolean running = true;
            while (running) {
                AppCLI.showMenu();
                int choice = safeInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("Add vehicle");
                        System.out.print("Type (car/bus/motorbike) [default: car]: ");
                        String type = sc.nextLine().trim().toLowerCase();
                        if (type.isEmpty()) type = "car";
                        System.out.print("Fuel type [default: petrol]: ");
                        String fuel = sc.nextLine().trim();
                        
                        if (fuel.isEmpty()) fuel = "petrol";
                        System.out.print("Efficiency (kg CO2/km) [default: 0.18]: ");
                        double eff = safeDouble(sc.nextLine());
                        
                        if (eff <= 0.0) eff = 0.18;
                        System.out.print("Annual distance (km) [default: 8000]: ");
                        double dist = safeDouble(sc.nextLine());
                        
                        if (dist <= 0.0) dist = 8000.0;
                        String id = type + "-" + (user.getVehicles().size() + 1);
                        Vehicle v = switch (type) {
                        
                            case "bus" -> new Bus(id, fuel, eff, dist);
                        
                            case "motorbike" -> new Motorbike(id, fuel, eff, dist);
                        
                            default -> new Car(id, fuel, eff, dist);
                        };
                        user.addVehicle(v);
                        System.out.println("Vehicle added: " + type + "(" + id + ")");
                    }
                    case 2 -> {
                        System.out.println("Set home usage");
                        System.out.print("Monthly electricity (kWh) [default: 150]: ");
                        double monthlyKWh = safeDouble(sc.nextLine());
                        
                        if (monthlyKWh <= 0.0) monthlyKWh = 150.0;
                        System.out.print("Grid emission factor (kg CO2/kWh) [default: 0.233]: ");
                        double kgCo2PerKWh = safeDouble(sc.nextLine());
                        
                        if (kgCo2PerKWh <= 0.0) kgCo2PerKWh = 0.233;
                        user.setHome(new Home(kgCo2PerKWh, monthlyKWh));
                        System.out.println("Home set.");
                    }
                    case 3 -> {
                        System.out.println("Set diet");
                        System.out.print("Diet factor (kg CO2/unit) [default: 1.2]: ");
                        double dietFactor = safeDouble(sc.nextLine());
                        
                        if (dietFactor <= 0.0) dietFactor = 1.2;
                        System.out.print("Annual diet units [default: 365]: ");
                        double dietUnits = safeDouble(sc.nextLine());

                        if (dietUnits <= 0.0) dietUnits = 365.0;
                        user.setDiet(new Diet(dietFactor, dietUnits));
                        System.out.println("Diet set.");
                    }
                    case 4 -> {
                        double total = CalculationEngine.computeTotal(user);
                        System.out.println();
                        System.out.println(" Carbon Footprint Summary ");
                        System.out.println("User: " + user.getName() + " (" + user.getUserId() + ")");
                        System.out.printf("Vehicles: %.2f kg CO2\n", user.vehiclesEmission());
                        System.out.printf("Home: %.2f kg CO2\n", user.homeEmission());
                        System.out.printf("Diet: %.2f kg CO2\n", user.dietEmission());
                        System.out.printf("Total annual: %.2f kg CO2\n", total);
                        Map<String, Double> b = CalculationEngine.breakdown(user);
                        System.out.println("Breakdown map: " + b);
                    }
                    case 5 -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please enter 1-5.");
                }
            }
        }
    }

    private static int safeInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    private static double safeDouble(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
