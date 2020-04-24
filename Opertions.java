package SecondNumPack;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

interface Commands {
    //All commands implements from this interface.
    //static ArrayList<num> stack = new ArrayList<num>();
    void ToDo(Stack s);
}

class DEFINE implements Commands {
    //DEFINE(int a){}
    //DEFINE(){}
    //public void smt(){};
    @Override
    public void ToDo(Stack s) {
        Scanner check = null;
        //exception if arrayList doesn't have 2 arguments
        num toArr = null;
        try {
            check = new Scanner(s.getNumStr().get(2));
            if (check.hasNextInt()) {
                toArr = new num(s.getNumStr().get(1), check.nextInt());
            } else {
                //throw MyErr wrongArgument(NotANumber)
                System.out.println("WrongArguments");
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            //System.out.println("smth wrong");
            e.printStackTrace();
        }
        //System.out.println("perfect");
        if (toArr != null) {
            System.out.println(toArr.a + ": " + toArr.b);
        }
        s.AddNum(toArr);
    }
}
class PUSH implements Commands {
    @Override
    public void ToDo(Stack s) {
        //delete from ArrayList<num> numbers?
        if(s.getNumStr().size() == 2){
            num n = new num(s.getNumStr().get(1), 0);
            s.AddToStack(s.getInt(n));
        }
        else{
            //исключение о неверном кол-ве арг-ов
        }
    }
}

class POP implements Commands {
    @Override
    public void ToDo(Stack S) {
//        if(tmp.size() == 2){
//            num n = new num(tmp.get(1), 0);
//            c.DeleteFromStack(n);
//        }
//        else{
//            //исключение о неверном кол-ве арг-ов
//        }
        if(S.getStackSize() != 0)
            S.DeleteFromStack();
    }
}

class PRINT implements Commands {
    @Override
    public void ToDo(Stack S) {
        System.out.println(S.getLastInStack());
    }
}

class SUM implements Commands {
    @Override
    public void ToDo(Stack S) {
        int a = S.getLastInStack();
        S.DeleteFromStack();
        int b =a + S.getLastInStack();
        S.DeleteFromStack();
        S.AddToStack(b);
    }
}

class MULTIPLY implements Commands {
    @Override
    public void ToDo(Stack S) {
        int a = S.getLastInStack();
        S.DeleteFromStack();
        int b =a * S.getLastInStack();
        S.DeleteFromStack();
        S.AddToStack(b);
    }
}

class SUBTRACT implements Commands {//вычитать
    @Override
    public void ToDo(Stack S) {
        int a = S.getLastInStack();
        S.DeleteFromStack();
        int b =a - S.getLastInStack();
        S.DeleteFromStack();
        S.AddToStack(b);
    }
}

class DEVIDE implements Commands {
    @Override
    public void ToDo(Stack S) {
        int a = S.getLastInStack();
        //System.out.println(a);
        S.DeleteFromStack();
        int b = S.getLastInStack();
        //System.out.println(b);
        S.DeleteFromStack();
        int f = 0;
        if(b != 0){
            f = b / a;
        }else{
            //interruption
        }
        //System.out.println("sssssssssss");
        S.AddToStack(f);
        //Stack.AddToStack(999);
    }
}

class SQRT implements Commands {
    @Override
    public void ToDo(Stack S) {
        int a = S.getLastInStack();
        S.DeleteFromStack();
        S.AddToStack((int) sqrt(a));
    }
}
