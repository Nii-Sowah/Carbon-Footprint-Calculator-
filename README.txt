PROJECT OVERVIEW

This is a command-line application that calculates a user's annual carbon 
footprint based on three main sources:
  1. Vehicles (cars, buses, motorbikes)
  2. Home electricity usage
  3. Diet

The program calculates total CO2 emissions in kilograms per year and provides
a detailed breakdown by category.


SYSTEM REQUIREMENTS

* Java Development Kit (JDK) 8 or higher
* Command line terminal (Windows Command Prompt, Mac Terminal, or Linux Shell)
* No external libraries required - uses only Java standard libraries


HOW TO COMPILE THE PROJECT

1. Open your command line terminal

2. Navigate to the project directory containing all .java files:
   cd path/to/your/project

3. Compile all Java files at once:
   javac *.java

   OR compile the main entry point (which will compile dependencies):
   javac Main.java

4. If compilation is successful, you should see .class files created in the
   same directory. No error messages means compilation succeeded.


HOW TO RUN THE PROGRAM

After compiling, run the program using:

   java Main

The program will start and display a banner, then prompt you for input.


USING THE PROGRAM

When the program starts, you will be asked to:

1. Enter a User ID (press Enter to use default "u001")
2. Enter a User Name (press Enter to use default "Alex")

Then you'll see a menu with 5 options:

  1) Add vehicle
     - Choose vehicle type: car, bus, or motorbike
     - Enter fuel type (e.g., petrol, diesel, electric)
     - Enter efficiency: kg CO2 emitted per km (default: 0.18)
     - Enter annual distance driven in km (default: 8000)
     - You can add multiple vehicles

  2) Set home usage
     - Enter monthly electricity usage in kWh (default: 150)
     - Enter grid emission factor in kg CO2 per kWh (default: 0.233)
     - This represents your household electricity consumption

  3) Set diet
     - Enter diet emission factor in kg CO2 per unit (default: 1.2)
     - Enter annual diet units (default: 365 for days per year)
     - This represents food-related emissions

  4) Show summary
     - Displays complete carbon footprint breakdown
     - Shows emissions from vehicles, home, and diet
     - Displays total annual CO2 emissions in kg

  5) Exit
     - Closes the program


EXAMPLE SESSION

Here's what a typical session looks like:

   Carbon Footprint Calculator (CLI)
Enter user ID (default: u001): [press Enter]
Enter user name (default: Alex): John

Menu:
  1) Add vehicle
  2) Set home usage
  3) Set diet
  4) Show summary
  5) Exit
Choose [1-5]: 1

Add vehicle
Type (car/bus/motorbike) [default: car]: car
Fuel type [default: petrol]: petrol
Efficiency (kg CO2/km) [default: 0.18]: 0.18
Annual distance (km) [default: 8000]: 10000
Vehicle added: car(car-1)

[Continue adding data or choose option 4 to see summary]


DEFAULT VALUES

If you press Enter without typing anything, these defaults are used:

User Settings:
  - User ID: u001
  - User Name: Alex

Vehicle:
  - Type: car
  - Fuel: petrol
  - Efficiency: 0.18 kg CO2/km
  - Annual Distance: 8000 km

Home:
  - Monthly Electricity: 150 kWh
  - Grid Emission Factor: 0.233 kg CO2/kWh

Diet:
  - Diet Factor: 1.2 kg CO2/unit
  - Annual Units: 365


ASSUMPTIONS AND NOTES

* All emissions are calculated in kilograms of CO2 per year
* The program assumes annual calculations (12 months for home, yearly distance
  for vehicles)
* Grid emission factors vary by country/region - the default 0.233 is an
  average value
* Vehicle efficiency includes all emissions from fuel production and combustion
* Diet units can represent daily meals, calories, or any normalized metric
* Invalid numeric inputs default to 0 or the specified default value
* You can add multiple vehicles, but only one home and one diet profile


UNDERSTANDING THE OUTPUT

When you choose "Show summary", you'll see:

Carbon Footprint Summary
User: [Your Name] ([Your ID])
Vehicles: [XX.XX] kg CO2      <- Total from all vehicles
Home: [XX.XX] kg CO2           <- Annual home electricity
Diet: [XX.XX] kg CO2           <- Annual food-related emissions
Total annual: [XX.XX] kg CO2   <- Sum of all sources
Breakdown map: {Vehicles=XX.XX, Home=XX.XX, Diet=XX.XX, Total=XX.XX}


TYPICAL EMISSION VALUES (FOR REFERENCE)

* Average car: 0.15-0.25 kg CO2/km
* Electric car: 0.05-0.10 kg CO2/km
* Bus: 0.08-0.15 kg CO2/km per passenger
* Motorbike: 0.08-0.12 kg CO2/km
* Home electricity (varies by country): 0.1-0.6 kg CO2/kWh
* Diet (meat-heavy): 2.5-3.3 kg CO2/day
* Diet (vegetarian): 1.5-1.7 kg CO2/day
* Diet (vegan): 1.0-1.5 kg CO2/day


TROUBLESHOOTING

Problem: "javac: command not found" or "java: command not found"
Solution: Java is not installed or not in your PATH. Install JDK and add it
          to your system PATH environment variable.

Problem: "error: cannot find symbol"
Solution: Make sure all .java files are in the same directory and compile
          using "javac *.java" to compile all files together.

Problem: Program exits immediately after running
Solution: Make sure you're using "java Main" not "java Main.java"

Problem: NumberFormatException or program accepts invalid input
Solution: The program has built-in error handling - invalid numbers default
          to 0 or specified defaults. Just re-enter valid data.


PROJECT STRUCTURE

Main.java                    - Entry point, delegates to App
App.java                     - Main CLI controller and user interface
AppGUI.java                  - Display helpers (banner and menu)
User.java                    - User data model (aggregates all emissions)
CalculationEngine.java       - Calculation logic and breakdown generation

Emission.java                - Abstract base class for all emissions
Vehicle.java                 - Abstract vehicle emission model
Car.java                     - Car implementation
Bus.java                     - Bus implementation
Motorbike.java               - Motorbike implementation
Home.java                    - Home electricity emission model
Diet.java                    - Diet emission model

DistanceBasedEmission.java   - Alternative distance model (not currently used)
EnergyConsumptionEmission.java - Alternative energy model (not currently used)
mypart.java                  - Legacy file (can be deleted)


SAMPLE CALCULATION

Example: A user with one car, home electricity, and diet

Vehicle:
  - Car driving 10,000 km/year at 0.18 kg CO2/km
  - Emissions: 10,000 × 0.18 = 1,800 kg CO2/year

Home:
  - 150 kWh/month at 0.233 kg CO2/kWh
  - Emissions: 12 × 150 × 0.233 = 419.4 kg CO2/year

Diet:
  - 1.2 kg CO2/day for 365 days
  - Emissions: 1.2 × 365 = 438 kg CO2/year

TOTAL: 1,800 + 419.4 + 438 = 2,657.4 kg CO2/year (about 2.66 tonnes)

