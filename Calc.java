package SecondNumPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

class num{
    String a;
    int b;
    num(String a, int b){
        this.a = a;
        this.b = b;
    }
    //-------------------------------------------------------------------------------------------------------
    String print(){
        return "<" + a + ">: " + b;
    }
    public boolean equals(Object o){
        num toCheck = (num)o;
        return this.a.equals(toCheck.a);
    }
    //-------------------------------------------------------------------------------------------------------
}

public class Calc{
    //Main functional.
    private Properties commandsNames = null;
    private ArrayList<Integer> stack = new ArrayList<Integer>();//сам стек, с которого будут сниматься числа для операций
    private ArrayList<num> numbers = new ArrayList<num>();//все числа, определенные DEFINE. Удаляются командой PUSH?
    private Scanner scan = null;
    //private Class[] comandClasses = null;

    public void AddNum(num n) {
        boolean Added = false;
        int ind = 0;
        for (num number : numbers) {
            if (number.equals(n)) {
                Added = true;
                break;
            }
            ind++;
        }
        if(!Added)
            this.numbers.add(n);
        else
            this.numbers.get(ind).b = n.b;
    }
    public void AddToStack(int n){
        stack.add(n);
    }
    public void DeleteFromStack(/*num n*/){
        stack.remove(stack.size() - 1);
    }
    public int LastInStack(){
        return stack.get(stack.size() - 1);
    }
    {
        FileInputStream in_d = null;
        commandsNames = new Properties();
        try {
            in_d = new FileInputStream("C:\\Users\\Даниил\\IdeaProjects\\SecondProj\\src\\SecondNumPack\\LoadClassesNames.properties");
            commandsNames.load(in_d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getInt(num n){
        return numbers.get(numbers.indexOf(n)).b;
    }
    String getProperty(String s) {
        return commandsNames.getProperty(s);
    }

    Calc() {
        this.scan = new Scanner(System.in);
    }
    Calc(String s) {
        this.scan = new Scanner(s);
    }

    void calculations() {
        DEFINE def = null;
        PUSH push = null;
        POP pop = null;
        PRINT print = null;
        SUM sum = null;
        MULTIPLY mult = null;
        SUBTRACT sub = null;
        DEVIDE dev = null;
        SQRT sqrt = null;

        Method methodDef = null;
        Method methodPush = null;
        Method methodPop = null;
        Method methodPrint = null;
        Method methodSum = null;
        Method methodMult = null;
        Method methodSub = null;
        Method methodDev = null;
        Method methodSqrt = null;
        try {
            Class Def = Class.forName(DEFINE.class.getName());
            Class Push = Class.forName(PUSH.class.getName());
            Class Pop = Class.forName(POP.class.getName());
            Class Print = Class.forName(PRINT.class.getName());
            Class Sum = Class.forName(SUM.class.getName());
            Class Mult = Class.forName(MULTIPLY.class.getName());
            Class Sub = Class.forName(SUBTRACT.class.getName());
            Class Dev = Class.forName(DEVIDE .class.getName());
            Class Sqrt = Class.forName(SQRT.class.getName());

            Constructor<?> conDef = Def.getDeclaredConstructor();
            Constructor<?> conPush = Push.getDeclaredConstructor();
            Constructor<?> conPop = Pop.getDeclaredConstructor();
            Constructor<?> conPrint = Print.getDeclaredConstructor();
            Constructor<?> conSum = Sum.getDeclaredConstructor();
            Constructor<?> conMult = Mult.getDeclaredConstructor();
            Constructor<?> conSub = Sub.getDeclaredConstructor();
            Constructor<?> conDev = Dev.getDeclaredConstructor();
            Constructor<?> conSqrt = Sqrt.getDeclaredConstructor();
//            Constructor[] css = cl1.getDeclaredConstructors();
//            for(Constructor c:css)
//                System.out.println("Name: "+ c.getName());
//            System.out.println("Name: " + con.getName());
            def = (DEFINE) conDef.newInstance();
            push = (PUSH) conPush.newInstance();
            pop = (POP) conPop.newInstance();
            print = (PRINT) conPrint.newInstance();
            sum = (SUM) conSum.newInstance();
            mult = (MULTIPLY) conMult.newInstance();
            sub = (SUBTRACT) conSub.newInstance();
            dev = (DEVIDE) conDev.newInstance();
            sqrt = (SQRT) conSqrt.newInstance();

            methodDef = def.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodPush = push.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodPop = pop.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodPrint = print.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodSum = sum.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodMult = mult.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodSub = sub.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodDev = dev.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
            methodSqrt = sqrt.getClass().getDeclaredMethod("ToDo", Calc.class, ArrayList.class);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        while (scan.hasNext()) {
            String s = scan.nextLine();
            if (s.equals("EXIT")) {
                int c = 0;
                System.out.println("Numbers:");
                while (c < numbers.size()) {
                    System.out.println(numbers.get(c).print());
                    c++;
                }
                this.AddToStack(999);
                c = 0;
                System.out.println("Stack:");
                while (c < stack.size()) {
                    System.out.println(stack.get(c));
                    c++;
                }
                break;
            }
            //parsing
            Scanner strings = new Scanner(s);
            ArrayList<String> ArrStr = new ArrayList<>();
            while (strings.hasNext()) {
                ArrStr.add(strings.next());//correct probably
            }
            //System.out.println(ArrStr);
            int i = 0;
            String commandName = null;
            while (i < ArrStr.size()) {
                if (this.getProperty(ArrStr.get(i)) != null) {
                    commandName = this.getProperty(ArrStr.get(i));
                    break;
                }
                i++;
            }
            if(commandName == null){
                continue;
            }
            try {
//                for(int k = 0; k < commandsNames.size(); k++){
//                    if(commandName.equals());
//                }
//
                //fabric:
                switch(commandName){
                    case "DEFINE":
                        if (methodDef != null) {
                            methodDef.invoke(def, this, ArrStr);
                        }
                        break;
                    case "PUSH":
                        if (methodPush != null) {
                            methodPush.invoke(push, this, ArrStr);
                        }
                        break;
                    case "POP":
                        if (methodPop != null) {
                            methodPop.invoke(pop, this, ArrStr);
                        }
                        break;
                    case "PRINT":
                        if (methodPrint != null) {
                            methodPrint.invoke(print, this, ArrStr);
                        }
                        break;
                    case "+":
                        if (methodSum != null) {
                            methodSum.invoke(sum, this, ArrStr);
                        }
                        break;
                    case "*":
                        if (methodMult != null) {
                            methodMult.invoke(mult, this, ArrStr);
                        }
                        break;
                    case "-":
                        if (methodSub != null) {
                            methodSub.invoke(sub, this, ArrStr);
                        }
                        break;
                    case "/":
                        if (methodDev != null) {
                            methodDev.invoke(dev, this, ArrStr);
                        }
                        break;
                    case "SQRT":
                        if (methodSqrt != null) {
                            methodSqrt.invoke(sqrt, this, ArrStr);
                        }
                        break;
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }

//            DEFINE defd = new DEFINE(3);
//            defd.ToDo(ArrStr);
            //end of Parsing
            //рефлексия:
            //либо как-то заранее загружаем все классы
            //либо делаем их статическими(но тогда рефлексия будет не нужна(или все равно каждый раз создается статический объект?
        }
    }
}
//нужно еще разобраться с класслоадером:
//как он вызывается? почему рефлексия тут лучше, чем статик классы?
