package Introduction;

class JavaSingleton{
    private static final JavaSingleton singleton = new JavaSingleton();
    public String str;
    private JavaSingleton() {
    }
    public static JavaSingleton getSingleInstance() {
        return singleton;
    }

}
