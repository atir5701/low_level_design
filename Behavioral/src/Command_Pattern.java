/*
Command Design Pattern is a behavioral Pattern that turn a request into a
standalone object allowing us to parameterize actions, queue them, log them.
We need to treat each command as a standalone object that encapsulates :
    1. What to do
    2. Which device it affects
    3. How to execute it
    4. (Optionally) How to undo it
This way the controller, remote or scheduler doesn't care how a command works.

Components :

Command : interface with a execute and undo method
ConcreteCommand : implements the command interface and hold a refer of Reciever
Reciever : Object the perform actual work.
Invoker : Responsible for initiating command execution. Hold reference to command
            object and calls execute() when an action occurs.
*/

interface Command {
    void execute();
}

class ReceiversA {
    public void on(){
        System.out.println("Light turned ON");
    }
    public void off(){
        System.out.println("Light turned OFF");
    }
}

class ReceiversB {
    public void setTemperature(int temp) {
        System.out.println("Thermostat set to " + temp + "°C");
    }
}

class CommandA implements Command {
    private ReceiversA a;
    public CommandA(ReceiversA a) {
        this.a = a;
    }
    @Override
    public void execute(){
        this.a.on();
    }
}

class CommandB implements Command {
    private int newTemp;
    private ReceiversB b;
    public CommandB(ReceiversB b) {
        this.b = b;
    }
    public void setNewTemp(int a){
        this.newTemp = a;
    }
    @Override
    public void execute(){
        this.b.setTemperature(this.newTemp);
    }
}

class Invoker {
    private Command command;

    public void setCommand(Command c){
        this.command = c;
    }

    public void run(){
        this.command.execute();
    }

}

// class
public class Command_Pattern {
    public void main(){
        ReceiversA a = new ReceiversA();
        ReceiversB b = new ReceiversB();

        Command A = new CommandA(a);
        Command B = new CommandB(b);

        Invoker i  = new Invoker();
        i.setCommand(A);
        i.run();

        i.setCommand(B);
        i.run();


    }
}
