package HW_18_12_2023;

public class Ex_4 {
    public static void main (String[] args){

        String str1 = "tree";
        UpperCaseConverter upper = String::toUpperCase;
        System.out.println(convert(str1, upper));
    }
    public static String convert(String str, UpperCaseConverter converter){
        return converter.string(str);
    }
    @FunctionalInterface
    interface UpperCaseConverter{
        String string (String str);
    }
}
