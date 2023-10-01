package Reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EmployeeTest {
    public static void main(String[] args) {

        Role role = Role.getRoleFromValue("developer");
        Employee employee1 = new Employee("Nrj", 28, role);
        try {
            System.out.println(invokeGetter(employee1, "name").invoke(employee1));
            System.out.println(invokeSetter(employee1, "name", "Nrrrj"));
            System.out.println(invokeGetter(employee1, "name").invoke(employee1));
//            System.out.println(invokeGetter(employee1, "age").invoke(employee1));
//            System.out.println(invokeGetter(employee1, "role").invoke(employee1));
//            System.out.println(invokeGetter(role, "value").invoke(role));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }


//        Field[] fields = Employee.class.getDeclaredFields();
//        List<String> args1 = new ArrayList<>();
//        for(int i =0;i< fields.length; i++){
//            args1.add(fields[i].getName());
//        }
//        args1.forEach(System.out::println);
    }

    public  static Method  invokeGetter(Object obj, String var) throws IntrospectionException {
            PropertyDescriptor pd = new PropertyDescriptor(var, obj.getClass());
        //System.out.println( getter.getName() +"->"+ getter.invoke(obj));
//            Object f = getter.invoke(obj);
//            System.out.println(f);
            return pd.getReadMethod();
    }

    public static Object invokeSetter(Object obj, String fieldName, Object valueToSet) throws IntrospectionException {
        try {
            return  new PropertyDescriptor(fieldName, obj.getClass()).getWriteMethod().invoke(obj, valueToSet);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
