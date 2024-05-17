package ra.excercise;

import java.util.regex.Pattern;

public class BT9 {
    public static void main(String[] args) {
        String passwordRegex = "[\\S]{7,}";
        String password = "rikk";
        System.out.println("Kết quả: "+ Pattern.matches(passwordRegex,password));
    }
}
