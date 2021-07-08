package tasks;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        var pattern = Pattern.compile("\\w+\\.");
        var methods = Task2.class.getMethods();

        var s = methods.toString();
        System.out.println(s);
        var d = pattern.matcher(methods.toString()).replaceAll("");
        System.out.println(d);

    }

    public void test(int t){
        System.out.println("test");
    }
}
