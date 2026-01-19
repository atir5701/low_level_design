package Factory;

/*
So in Factory Method we define an interface for creating
objects but allow subclasses to decide which class to
instantiate
Factory method lets us create different objects without coupling
our code to specific classes.

So each subclass has its own way of instantiating objects
The base class defines a common interface for creating object but doesn't kbow what object is
Base class also defines common behavior using created object in some way.

 */

/*
  4 things :
  Product - Interface for objects the facotry creates
  Concrete Products
  Creator - Interface declaring the facotry method
  ConcreteCreator - Subclass implementing factory method
 */

interface Notification {
    public void send(String messgae);
}

class EmailNotification implements  Notification {
    @Override
    public  void send(String messgae){
        System.out.println("Sending email with "+messgae);
    }
}

class SMSNotification implements  Notification {
    @Override
    public  void send(String messgae){
        System.out.println("Sending SMS with "+messgae);
    }
}

class PushNotification implements  Notification {
    @Override
    public  void send(String messgae){
        System.out.println("Sending push notify with "+messgae);
    }
}

interface NotificationFactory{
    public Notification createNotifier();
}

class EmailNotificationFactory implements NotificationFactory{
    @Override
    public  Notification createNotifier(){
        return new EmailNotification();
    }
}

class SMSNotificationFactory implements NotificationFactory{
    @Override
    public  Notification createNotifier(){
        return new SMSNotification();
    }
}

class PushNotificationFactory implements NotificationFactory{
    @Override
    public  Notification createNotifier(){
        return new PushNotification();
    }
}


// Using it in Client Code

class Demo{

    public static void main(String[] args){
        NotificationFactory f;
        f = new EmailNotificationFactory();
        Notification t = f.createNotifier();
        t.send("hello");

        f = new SMSNotificationFactory();
        t = f.createNotifier();
        t.send("hello");

        f = new PushNotificationFactory();
        t = f.createNotifier();
        t.send("hello");
    }

}
