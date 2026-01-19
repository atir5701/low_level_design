package Factory;
/*
The Abstract Factory Design Pattern is a creational pattern that provides
an interface  for creating families of related or dependent objects without
specifying their concrete classes.

Abstract Factory Pattern encapsulates object creation into factory interfaces.
Each concrete factory implements the interface and produces
a complete set of related objects.
 */
/*
Components :

AbstractFactory : common interface for creating a family of related products
ConcreteFacotry : Implement abstract factory
Abstract Product : Interface for set of related components
Concrete Product : Implement abstract product interfaces
 */

interface Button {
    void click();
}

interface CheckBox {
    void press();
}

class WindowButton implements Button {
    public void click(){
        System.out.println("Window Button Pressed");
    }
}

class MacButton implements Button {
    public void click(){
        System.out.println("Mac Button Pressed");
    }
}

class MacBox implements CheckBox {
    public void press(){
        System.out.println("Mac Box Pressed");
    }
}

class WindowBox implements CheckBox {
    public void press(){
        System.out.println("Window Box Pressed");
    }
}


interface UIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WindowFactory implements  UIFactory {
    public Button createButton(){
        return new WindowButton();
    }

    public  CheckBox createCheckBox(){
        return  new WindowBox();
    }
}

class MACFactory implements  UIFactory {
    public Button createButton(){
        return new MacButton();
    }

    public CheckBox createCheckBox(){
        return new MacBox();
    }
}

class Client {
    public void main(){
        UIFactory f = new MACFactory();
        Button t = f.createButton();
        t.click();
        CheckBox c = f.createCheckBox();
        c.press();
        f = new WindowFactory();
        t = f.createButton();
        c = f.createCheckBox();
    }
}