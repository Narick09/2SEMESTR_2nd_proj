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
    String print(){
        return "<" + a + ">: " + b;
    }
    public boolean equals(Object o){
        num toCheck = (num)o;
        return this.a.equals(toCheck.a);
    }
}

public class Calc{
    //Main functional.
    private Properties commandsNames = null;
    private Scanner scan = null;
    Stack stack = null;
    //private Class[] comandClasses = null;

    {
        FileInputStream in_d = null;
        commandsNames = new Properties();
        try {
            in_d = new FileInputStream("C:\\Users\\Даниил\\IdeaProjects\\SecondProj\\src\\SecondNumPack\\LoadClassesNames.properties");
            commandsNames.load(in_d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stack = new Stack();
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

            methodDef = def.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodPush = push.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodPop = pop.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodPrint = print.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodSum = sum.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodMult = mult.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodSub = sub.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodDev = dev.getClass().getDeclaredMethod("ToDo", Stack.class);
            methodSqrt = sqrt.getClass().getDeclaredMethod("ToDo", Stack.class);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        while (scan.hasNext()) {
            String s = scan.nextLine();
            if (s.equals("EXIT")) {

                System.out.println("Numbers:");
                stack.printNums();
                //Stack.AddToStack(999);

                System.out.println("Stack:");
                stack.printStack();
                break;
            }
            //parsing
            Scanner strings = new Scanner(s);
            ArrayList<String> ArrStr = new ArrayList<>();
            while (strings.hasNext()) {
                ArrStr.add(strings.next());//correct probably
            }
            stack.setNumStr(ArrStr);
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
                System.out.println("WrongCommend");
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
                            methodDef.invoke(def, stack);
                        }
                        break;
                    case "PUSH":
                        if (methodPush != null) {
                            methodPush.invoke(push, stack);
                        }
                        break;
                    case "POP":
                        if (methodPop != null) {
                            methodPop.invoke(pop, stack);
                        }
                        break;
                    case "PRINT":
                        if (methodPrint != null) {
                            methodPrint.invoke(print, stack);
                        }
                        break;
                    case "SUM":
                        if (methodSum != null) {
                            methodSum.invoke(sum, stack);
                        }
                        break;
                    case "MULTIPLY":
                        if (methodMult != null) {
                            methodMult.invoke(mult, stack);
                        }
                        break;
                    case "SUBTRACT":
                        if (methodSub != null) {
                            methodSub.invoke(sub, stack);
                        }
                        break;
                    case "DEVIDE"://change to "DEVIDE"
                        if (methodDev != null) {
                            System.out.println("Devide:");
                            methodDev.invoke(dev, stack);
                        }
                        break;
                    case "SQRT":
                        if (methodSqrt != null) {
                            methodSqrt.invoke(sqrt, stack);
                        }
                        break;
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
