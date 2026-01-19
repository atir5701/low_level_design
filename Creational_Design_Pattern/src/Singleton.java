
// Singleton Pattern is a creational design pattern that guarantees a class has only one instance and provides a global
// point of access to it.

// Three Way to implement the design pattern


// 1. Lazy Initialization
// This method is not Thread Safe
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Object Created");
    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}


// 2. Thread Safe Singleton
// Synchronization keyword ensures that only one thread can perform the (instance == null) check and create the object.
// This approach reduces performance.

class SingletonThreadSafe {
    private static SingletonThreadSafe instance;

    private SingletonThreadSafe() {
        System.out.println("Object Created");
    }

    public static synchronized SingletonThreadSafe getInstance(){
        if(instance==null){
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}

// 3. Double-Checked Locking
/*
If the first check (instance == null) passes, we synchronize on the class object.
We check the same condition one more time because multiple threads may have passed the first check.
The instance is created only if both checks pass.
 */
class SingletonDouble {
    private static SingletonDouble instance;

    private SingletonDouble() {
        System.out.println("Object Created");
    }

    public static SingletonDouble getInstance(){
        if(instance==null){
            synchronized (SingletonDouble.class) {
                if(instance==null) {
                    instance = new SingletonDouble();
                }
            }
        }
        return instance;
    }
}

// 4 Eager Initialization
/*
This approach is suitable if your application always creates and uses the singleton instance,
or the overhead of creating it is minimal.
 */

class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {
        System.out.println("Object Created");
    }

    public static SingletonEager getInstance(){
        return instance;
    }
}



 /*
Singleton is useful in scenarios like:

Managing Shared Resources (database connections, thread pools, caches, configuration settings)
Coordinating System-Wide Actions (logging, print spoolers, file managers)
Managing State (user session, application state)

  */