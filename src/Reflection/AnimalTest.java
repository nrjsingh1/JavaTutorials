package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnimalTest {


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        Class c = Cow.class;
        Method[] m = c.getDeclaredMethods();
        for(Method method:m){
            System.out.println(method.getName());
        }


    }


}
