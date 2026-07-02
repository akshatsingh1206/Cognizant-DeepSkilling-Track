// Exercise 1: Implementing the Singleton Pattern
public class Logger {
    // 1. Create a private static instance of the class
    private static Logger instance;

    // 2. Make the constructor private so it cannot be instantiated from outside
    private Logger() {
        System.out.println("Logger Instance Initialized (Thread-Safe / Lazy Initialization).");
    }

    // 3. Provide a public static method to get the single instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }

    public static void main(String[] args) {
        // Test Singleton behavior
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting Design Principles assessment task.");
        logger2.log("Verifying Singleton instance identity.");

        // Verification check
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both logger1 and logger2 point to the exact same instance.");
        } else {
            System.out.println("FAILURE: Different instances exist.");
        }
    }
}