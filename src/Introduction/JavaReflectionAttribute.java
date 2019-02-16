package Introduction;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflectionAttribute {

    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = Student.class.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
