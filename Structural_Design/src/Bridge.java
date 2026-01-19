/*
The Brigde desgin pattern is a structural pattern that lets us decouple
an abstraction from its implementation allows two to vary independently.

In this Pattern we split a class into two seperate hierarchies:

1. One for Abstraction
2. One for implementation

Both are bridges via composition and not inheritance.

Abstraction -> Containes and Implementors reference and defines
                operation possible
                High Level interface.

Refined Abstraction -> Subcalss of Abstraction that addes behaviour logic

Implementor -> An interface that declares operation to be implemented by
                concrete implementors
ConcreteImplementor -> Platform specific classes that implements Inplementor
                interface.
*/

interface Implementor {
    void renderCircle();
    void renderSquare();
}

class ConcreteImplementorA implements Implementor{

    @Override
    public void renderCircle(){
        System.out.println("Rendering Circle From Concrete Implementor A");
    }

    @Override
    public void renderSquare(){
        System.out.println("Rendering Square From Concrete Implementor A");
    }
}

class ConcreteImplementorB implements Implementor{

    @Override
    public void renderCircle(){
        System.out.println("Rendering Circle From Concrete Implementor B");
    }

    @Override
    public void renderSquare(){
        System.out.println("Rendering Square From Concrete Implementor B");
    }
}

abstract class Abstraction {
    Implementor imp;
    abstract void getDisplay();
}

class RefinedAbstractionCircle extends Abstraction{
    public RefinedAbstractionCircle(Implementor imp){
        this.imp = imp;
    }

    @Override
    public void getDisplay(){
        this.imp.renderCircle();
    }
}

class RefinedAbstractionSqaure extends Abstraction{
    public RefinedAbstractionSqaure(Implementor imp){
        this.imp = imp;
    }

    @Override
    public void getDisplay(){
        this.imp.renderSquare();
    }
}



public class Bridge {

    public void main(){
        Implementor a = new ConcreteImplementorA();
        Implementor b = new ConcreteImplementorB();
        Abstraction c = new RefinedAbstractionCircle(a);
        c.getDisplay();
        c = new RefinedAbstractionCircle(b);
        c.getDisplay();


        Abstraction s = new RefinedAbstractionSqaure(a);
        s.getDisplay();
        s = new RefinedAbstractionSqaure(b);
        s.getDisplay();
    }

}
