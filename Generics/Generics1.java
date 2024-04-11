package Generics;


class Glass<T>{
    private T liquid;
}

class Juice {}

class Water{}

public class Generics1{


    public static void main(String[] args) {
        Glass<Juice> juiceGlass = new Glass<Juice>();
    }
   
}
