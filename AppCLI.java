public class AppCLI {
    public static void banner() {
        
        System.out.println("   Carbon Footprint Calculator (CLI)   ");
        
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("  1) Add vehicle");
        System.out.println("  2) Set home usage");
        System.out.println("  3) Set diet");
        System.out.println("  4) Show summary");
        System.out.println("  5) Exit");
        System.out.print("Choose [1-5]: ");
    }
}
