package testing;

public class GrandSon extends Son {

    private int grandSonAge = 13;

    public void fatherMethod() {
        System.out.println("Because i'm a Class that implement the interface i must implement the Father function!");
    }

    public void getFatherAge(){
        System.out.println("This is Father Age" + fatherAge);
    }

    public void getSonAge(){
        System.out.println("This is Father Age" + sonAge);
    }

    public void getGrandSonAge(){
        System.out.println("This is Father Age" + grandSonAge);
    }

    public static void main(String[] args) {
        Father father = new GrandSon();
        Son son = new GrandSon();
        GrandSon gSon = new GrandSon();

        //Notice Father have only his methods and nothing else!
        father.fatherMethod();
        //Notice that son can only access his father method and his methods but not grandson methods!
        System.out.println("son can print his age only: "+ son.sonAge);
        son.fatherMethod();
        son.sonMethod();
        //Lastly grandSon can access father and son methods and all of his methods -
        System.out.println("gSon can print his age: "+ gSon.grandSonAge + ", also Son age: "+ gSon.sonAge +", lastly for the interface you need to use a interface itself for the vars: "+ Father.fatherAge);
        gSon.fatherMethod();
        gSon.getSonAge();
        gSon.getGrandSonAge();
        gSon.sonMethod();
    }
}
