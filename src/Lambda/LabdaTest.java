package Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LabdaTest {

    public static List<String> IGNORE_LIST = new ArrayList<>();
    public static List<String> patches = new ArrayList<>();


    public static void main(String[] args) {

        IGNORE_LIST.add("xyz");
        IGNORE_LIST.add("uuid");
        IGNORE_LIST.add("mus");
        IGNORE_LIST.add("operation");
        IGNORE_LIST.add("delta");

        patches.add("speediest");
        patches.add("xyz");
        patches.add("median");

        patches.forEach(System.out::println);

        patches = patches.stream().filter(patch -> !IGNORE_LIST.contains(patch)).collect(Collectors.toList());

        patches.forEach(System.out::println);




    }
}
