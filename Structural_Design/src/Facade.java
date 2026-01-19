/*

The Facade Design Pattern is a structural design pattern that provides a
unified, simplified interface to a complex subsystem making it easier for
clients to interact with multiple components without getting overwhelmed by
their intricacies.

1. Facade : knows which subsystem classess to use and in what order.
    Delegares requests to appropriate subsystems methods without exposing
    internal details
2. Subsystem Clases : classes where actual business logic is writted
3. Clinet : Main class that interacts with Facade

*/

class Git {
    public void pull(){
        System.out.println("Pulling code from Git");
    }
}

class Docker {
    public void build(){
        System.out.println("Building Docker Image");
    }
}

class Testing {
    public void testing(){
        System.out.println("Testing Code");
    }
}

class Deploy {
    public void deploy(){
        System.out.println("Deploying Code on AWS");
    }
}


class Facade {
    private Git git;
    private Docker docker;
    private Testing test;
    private Deploy dep;

    public Facade() {
        this.git = new Git();
        this.dep = new Deploy();
        this.docker = new Docker();
        this.test = new Testing();
    }

    public void execute(){
        this.git.pull();
        this.docker.build();
        this.test.testing();
        this.dep.deploy();
    }

}

/* CLient code */
class Client {
    void main(){
        Facade f = new Facade();
        f.execute();
    }

}
