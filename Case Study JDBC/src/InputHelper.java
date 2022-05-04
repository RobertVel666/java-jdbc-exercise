import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelper {
    public static String getInput(String prompt){
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println(prompt);
        System.out.flush();

        try {
            return stdin.readLine();
        }//try
        catch (Exception e){
            return "Error: " + e.getMessage();
        }//catch
    }//getInput

    public  static double getDoubleInput(String prompt) throws NumberFormatException{
        String input = getInput(prompt);
        return Double.parseDouble(input);
    }//getDoubleInput

    public static int getIntegerInput(String prompt) throws NumberFormatException {
        String input = getInput(prompt);
        return Integer.parseInt(input);
    }//getIntegerInput


}//InputHelper
