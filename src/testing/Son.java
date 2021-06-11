package testing;

public abstract class Son implements Father {
    // Abstract Class Vars -
    protected int sonAge = 23;

    // Abstract Class Functions -

    // Notice this is redundant - you get it for free from the implementation of Father!
    public abstract void fatherMethod();

    public void sonMethod(){
        System.out.println("this is the son Method");
    }
}
