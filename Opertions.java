package SecondNumPack;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

interface Commands {
    //All commands implements from this interface.
    //static ArrayList<num> stack = new ArrayList<num>();
    void ToDo(Calc c, ArrayList<String> tmp);
}

class DEFINE implements Commands {
    //DEFINE(int a){}
    //DEFINE(){}
    //public void smt(){};
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        Scanner check = null;
        //exception if arrayList doesn't have 2 arguments
        num toArr = null;
        try {
            check = new Scanner(tmp.get(2));
            if (check.hasNextInt()) {
                toArr = new num(tmp.get(1), check.nextInt());
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
        c.AddNum(toArr);
    }
}
class PUSH implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        //delete from ArrayList<num> numbers?
        if(tmp.size() == 2){
            num n = new num(tmp.get(1), 0);
            c.AddToStack(c.getInt(n));
        }
        else{
            //исключение о неверном кол-ве арг-ов
        }
    }
}

class POP implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
//        if(tmp.size() == 2){
//            num n = new num(tmp.get(1), 0);
//            c.DeleteFromStack(n);
//        }
//        else{
//            //исключение о неверном кол-ве арг-ов
//        }
        c.DeleteFromStack();
    }
}

class PRINT implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        System.out.println(c.LastInStack());
    }
}

class SUM implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        int a = c.LastInStack();
        c.DeleteFromStack();
        int b =a + c.LastInStack();
        c.DeleteFromStack();
        c.AddToStack(b);
    }
}

class MULTIPLY implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        int a = c.LastInStack();
        c.DeleteFromStack();
        int b =a * c.LastInStack();
        c.DeleteFromStack();
        c.AddToStack(b);
    }
}

class SUBTRACT implements Commands {//вычитать

    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        int a = c.LastInStack();
        c.DeleteFromStack();
        int b =a - c.LastInStack();
        c.DeleteFromStack();
        c.AddToStack(b);
    }
}

class DEVIDE implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        int a = c.LastInStack();
        c.DeleteFromStack();
        int b = c.LastInStack();
        c.DeleteFromStack();
        int f = 0;
        if(c.LastInStack() != 0){
            f = b / a;
        }else{
            //interruption
        }
        c.AddToStack(f);
    }
}

class SQRT implements Commands {
    @Override
    public void ToDo(Calc c, ArrayList<String> tmp) {
        int a = c.LastInStack();
        c.DeleteFromStack();
        c.AddToStack((int) sqrt(a));
    }
}
