/*
The Decorator Design Pattern is a structural pattern that lets you
dynamically add new behavior or responsibilities to objects without
modifying their underlying code.

Decorator Pattern allows us to add responsibilities to objects dynamically,
without altering their structre or  modifying original code.
At its core, the pattern relies on wrapping an object inside another object
(a decorator) that implements the same interface and adds new behavior
before or after delegating to the wrapped object.

Component -> Interface with a execute method

ConcreteComponent that implments this interface
BaseDecorator which has a component and also is a component.
ConcreteDecorator -> implements the Base Decorator.

Think of a plain coffee. Now add milk. Now add sugar.
Each addition enhances the original but doesn’t change the base.
 The Decorator Pattern works the same way — stacking behaviors while
  keeping the core intact.
 */

interface Component {
    void render();
}

class ConcreteComponent implements Component{
    String text;
    public ConcreteComponent(String text){
        this.text = text;
    }

    @Override
    public void render(){
        System.out.println(this.text);
    }
}


abstract class BaseDecorator implements Component{
    final Component inner;
    public BaseDecorator(Component inner){
        this.inner = inner;
    }
}

class BoldDecorator extends BaseDecorator{
    public BoldDecorator(Component c) {
        super(c);
    }

    @Override
    public void render(){
        System.out.println("Bold text");
        inner.render();
    }
}

class ItalicDecorator extends BaseDecorator{
    public ItalicDecorator(Component c) {
        super(c);
    }

    @Override
    public void render(){
        System.out.println("Italic text");
        inner.render();
    }
}


// Client Code
public class Decorator {
    public void main(){
        Component text = new ConcreteComponent("hello world");

        text = new ItalicDecorator(new BoldDecorator(text));
        text.render();
    }
}
