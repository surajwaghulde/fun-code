package Multithreading;

public class SingleInstance {
    private static SingleInstance inst = null;
     
    private SingleInstance(){}
     
    public static SingleInstance getInstance() {
        synchronized(SingleInstance.class) {
            if(inst == null) {
                inst = new SingleInstance();
            }
        }
        return inst;
    }
}
