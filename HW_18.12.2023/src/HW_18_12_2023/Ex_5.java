package HW_18_12_2023;

public class Ex_5 {
    public static void main (String[] args){
        Logger console = System.out::println;
        log("Hello World!", console);
    }
    public static void log(String message, Logger logger) {
        logger.log(message);
    }
    @FunctionalInterface
    interface Logger{
        void log(String letter);
    }
}
