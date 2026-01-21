/*
Template Design Pattern is a behavioral design pattern that defines the
skeleton of an algo in a base class, but allow subclasses to oveerride
the specific steps of algo without changing its overall structure.

The Template Method Pattern solves this by capturing the common workflow
in a base class and pushing the customizable steps into subclasses,
ensuring that the overall structure remains consistent while allowing
flexibility where needed.

Component :
Abstract Class : has a template method which is final and defines the fixed sequence
                of steps for the algorithm, it has one or more abstract methods that
                by subclasses. These represent steps that may vary accross diff
                implementations

Concrete Classes : Extend abstract base class & provide implementation for
                    abstract method defines in template
*/

abstract class BaseTemplateClass {
    public final void template(){
        prepareData();
        openFile();
        writeHeader();
        writeData();
        closeFile();
    }

    protected void prepareData(){
        System.out.println("Preparing report data (common step)...");
    }
    protected void openFile(){
        System.out.println("Opening report data (common step)...");
    }
    protected abstract void writeHeader();
    protected abstract void writeData();
    protected void closeFile(){
        System.out.println("Closing report data (common step)...");
    }
}

class TemplateA extends BaseTemplateClass {
    @Override
    protected void writeHeader(){
        System.out.println("Headers Written");
    }
    @Override
    protected void writeData(){
        System.out.println("Data Written");
    }
}

class TemplateB extends BaseTemplateClass {
    @Override
    protected void writeHeader(){
        System.out.println("Headers Written");
    }
    @Override
    protected void writeData(){
        System.out.println("Data Written");
    }
}

public class Template_Pattern {
    public void run(){
        TemplateA a = new TemplateA();
        a.template();
        TemplateB b = new TemplateB();
        b.template();
    }
}
