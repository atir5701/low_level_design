/*
Stratergy Design Pattern is a behavioral pattern that help us define a family
of algo, encapsulates eachone in its own class and make them interchangeable at
runtime.
Instead of embedding multiple algorithms inside a single class with conditional
logic, you extract each algorithm into its own strategy class.
The main class (context) delegates the work to whichever strategy is
currently plugged in.

Components :
Stratergy : An common interface implemented by all algorithms which are available
ConcreteStarget : THe actual algorightm possible
Context : hold a refernece of stargety and we can change this during runtime

*/

interface Stratergy {
    void execute();
}

class ConcreteStratergyA implements Stratergy{
    @Override
    public void execute(){
        System.out.println("Implementing Stratergy A");
    }
}

class ConcreteStratergyB implements Stratergy{
    @Override
    public void execute(){
        System.out.println("Implementing Stratergy B");
    }
}


class Context {
    private Stratergy s;
    public Context(Stratergy s){
        this.s = s;
    }

    public void setStratergy(Stratergy s){
        this.s = s;
    }

    public void run(){
        this.s.execute();
    }
}

public class Stratergy_Pattern {
    public void main(){
        Stratergy a = new ConcreteStratergyA();
        Stratergy b = new ConcreteStratergyB();
        Context c = new Context(a);
        c.run();
        c.setStratergy(b);
        c.run();
    }
}
