import model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.get(r));
        Method toString = r.getClass().getMethod("toString");
        System.out.println(toString.invoke(r));
        toString = r.getClass().getMethod("hashCode",null);
        System.out.println(toString.invoke(r,null));
    }
}
