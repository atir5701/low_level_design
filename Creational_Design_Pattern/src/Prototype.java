/*
The Prototype Design Pattern is a creational design pattern that lets
you create new objects by cloning existing ones, instead of instantiating
them from scratch.

It’s particularly useful in situations where:
    Creating a new object is expensive, time-consuming, or resource-intensive.
    You want to avoid duplicating complex initialization logic.
    You need many similar objects with only slight differences.

The Better way of cloning is let the object clone itself.

Instead of having external cody copy or recreating the object, the object itself
knows how to create its clone.
So we expose a clone() or copy() method that returns a new instance with the same
data.
This :
preserves encapsulation, eliminates the need to know concrete class, and makes
the system more flexible and extensible.

Prototype Design Pattern : specifies the kinds of objects to create using a
prototypical instance and creates new objects by copying this prototype.

Working:
Prototype: interface with a clone() method which every cloneable object must implement

Concrete Prototype L Each objects that needs to be cloneable implments Prototype
interface and provides logic to clone itself.
 */

interface Prototype1 {
    Prototype1 clone();
}


class Obj implements Prototype1 {
    private String name;
    private int age;

    public Obj(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public Obj clone(){
        return new Obj(this.name,this.age);
    }

    void print(){
        System.out.println(this.age+" "+this.name);
    }
}

public class Prototype {
    public void main(){
        Obj a = new Obj("Hello",12);
        Obj b = a.clone();
        a.print();
        b.print();
    }
}
