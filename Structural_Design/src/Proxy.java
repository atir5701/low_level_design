/*
The Proxy Desgin Pattern is a structural pattern that provide a placeholder
for another object allowing us to control access to it.

There are 3 types in which Proxy can be used

1. virtual -> used to prevent eaager loading and help in lazy initialization
2. remote -> used to represet the object location present on a different machine
3. protected -> used for controlling access to real resource

ALl the three ways of Proxy but used the same way of implementation

Subject : A common interface used by the real subject and the Proxy
Real SUbject : The actaul object
Proxy : Placeholder, also containert the objct of real subject
Client : interfact woth Proxy

*/

interface Subject {
    void load();
}

class RealSubject implements Subject{
    private String fileName;

    public RealSubject(String name){
        this.fileName = name;
        // loading the image (heavy task carried out)
    }
    @Override
    public void load(){
        System.out.println("Loading the image");
    }
}

class ProxyClass implements Subject{
    private String fileName;
    private RealSubject rs;
    public ProxyClass(String name){
        this.fileName = name;
    }

    @Override
    public void load(){
        if(rs==null){
            rs = new RealSubject(this.fileName);
        }
        rs.load();
    }
}


// Client Code
public class Proxy {
    void main(){
        ProxyClass p = new ProxyClass("hello");
        p.load(); // actual loading of the image
        p.load(); // using the already loaded image
    }
}
