/*
The Composite Design Pattern is a structural pattern that allows to
tread individual objects and composition of objects uniformly.
It allows you to build tree-like structures where clients can work with
both single elements and groups of elements using the same interface.

The Composite Pattern solves this by defining a common interface for all
elements, whether they are leaves or composites. Each component can then be
treated the same way — allowing the client to operate on complex structures
as if they were simple objects.

Component Interface : Declare a common interface for all concrete component
Leaf : Represent an end object
Composition : Represent object that can hold other children
Client : Work with Component
 */

import java.util.ArrayList;
import java.util.List;

interface FileItem{
    int size();
    void print();
}

class File implements FileItem{
    String name;
    public File(String name){
        this.name = name;
    }
    @Override
    public int size(){
        return 1;
    }
    @Override
    public void print(){
        System.out.println("    File : "+name);
    }
}

class Folder implements FileItem{
    private List<FileItem> folder;
    String name;
    public Folder(String name){
        folder = new ArrayList<>();
        this.name = name;
    }

    @Override
    public int size(){
        int s = 0;
        for(FileItem i : folder){
            s = s + i.size();
        }
        return s;
    }

    @Override
    public void print(){
        System.out.println("Folder : "+this.name);
        for(FileItem i : folder){
            i.print();
        }
    }

    public void add(FileItem item){
        this.folder.add(item);
    }
}


public class Composite {

    public void main(){
        FileItem file1 = new File("A.txt");
        FileItem file2 = new File("B.txt");
        FileItem file3 = new File("C.txt");

        Folder folder1 = new Folder("Main");
        Folder folder2 = new Folder("Sub");

        folder2.add(file3);
        folder2.add(file2);
        folder1.add(folder2);
        folder1.add(file1);

        System.out.println(folder1.size());
        folder1.print();
        folder2.print();
    }
}
