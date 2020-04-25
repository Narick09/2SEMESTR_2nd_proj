package SecondNumPack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Parser{
    //use this class to get command with overriding method toDo
    //fabric pattern
    private DEFINE def = null;
    private PUSH push = null;
    private POP pop = null;
    private PRINT print = null;
    private SUM sum = null;
    private MULTIPLY mult = null;
    private SUBTRACT sub = null;
    private DEVIDE dev = null;
    private SQRT sqrt = null;

    private Method methodDef = null;
    private Method methodPush = null;
    private Method methodPop = null;
    private Method methodPrint = null;
    private Method methodSum = null;
    private Method methodMult = null;
    private Method methodSub = null;
    private Method methodDev = null;
    private Method methodSqrt = null;

    public void conInit(){
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
    }

    public void parsing(Stack stack, String commandName){
        try {
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
                case "DEVIDE":
                    if (methodDev != null) {
                        //System.out.println("Devide:");
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
