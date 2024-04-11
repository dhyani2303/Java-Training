package pack2;
import pack1.AccessModifier1;

class AccessModifier3 extends AccessModifier1{

public static void main(String[] args){

AccessModifier1 a = new AccessModifier1();
    // a.test2(); --> access nai krva de
    AccessModifier3 a1 = new AccessModifier3();
    a1.test2();
}

}