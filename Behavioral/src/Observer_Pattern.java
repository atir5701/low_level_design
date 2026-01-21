/*
Observer Design Pattern is a behaviroual pattern that defines a one- to-many
dependency between objects so that when one object changes its state all its
dependents are automatically notifies and updated.
The Observer Pattern solves this by decoupling the subject and its observers,
allowing them to interact through a common interface.
Observers can be added or removed at runtime, and the subject doesn’t need
to know who they are.

Components :

1. Observer Interface : Has an update method. All modules that want to listern
    implements this interface
2. Subject Interface : has method to add, remove and notify observer,
3. Concrete Subject : Implements Subject interface
4. Concrete Observer : implements the Objserver interface and has reference
    observer interface to get the data when executing update method
 */

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

interface Subject{
    void addObserver(Observer a);
    void deleteObserver(Observer a);
    void notifyObserver();
}

class ConcreteSubject implements Subject{
    private List<Observer> obs;

    public ConcreteSubject(){
        obs = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer a){
        this.obs.add(a);
    }

    @Override
    public void deleteObserver(Observer a){
        for(Observer t : obs){
            if(t==a){
                obs.remove(t);
                break;
            }
        }
    }

    @Override
    public void notifyObserver(){
        for(Observer t: obs){
            t.update();
        }
    }

}

class ConcreteObserver implements Observer {
    private Subject s;

    public ConcreteObserver(Subject a){
        this.s = a;
    }

    @Override
    public void update(){
        System.out.println("Using the Subject to perform operations");
    }

}


public class Observer_Pattern {
    public void main(){
        Subject s = new ConcreteSubject();
        Observer ob1 = new ConcreteObserver(s);
        Observer ob2 = new ConcreteObserver(s);
        Observer ob3 = new ConcreteObserver(s);

        s.addObserver(new ConcreteObserver(s));
        s.addObserver(ob1);
        s.addObserver(ob2);
        s.addObserver(ob3);
        s.deleteObserver(ob1);
        s.notifyObserver();
    }

}
