package calculator;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private final HashMap<String, Integer> operatorPriority;

    private final LinkedList<Double> numberStack;
    private final LinkedList<String> operatorStack;

    /**
     * 是否开始输入下一个数字
     */
    private boolean nextNum;
    /**
     * 是否已经完成了一次计算
     */
    private boolean calculated;
    /**
     * 是否输入了小数
     */
    private boolean decimal;
    private int decimalDigits;
    /**
     * 是否输入了负数
     */
    private boolean negative;

    public Calculator() {
        operatorPriority = new HashMap<>();
        numberStack = new LinkedList<>();
        operatorStack = new LinkedList<>();

        List<String> level1 = Arrays.asList("+", "-");
        List<String> level2 = Arrays.asList("*", "/", "%");
        level1.forEach(op -> operatorPriority.put(op, 1));
        level2.forEach(op -> operatorPriority.put(op, 2));


        reset();
    }

    public void reset() {
        calculated = true;
        numberStack.clear();
        operatorStack.clear();
        numberStack.push(0.0);
        nextNum = true;
        negative = false;
        decimal = false;
        decimalDigits = 0;
    }

    /**
     * 是否已经完成了一次计算
     */
    public boolean isCalculated() {
        return this.calculated;
    }

    /**
     * 获得计算结果
     *
     * @return 计算结果
     * @throws ArithmeticException 如果输入不合法运算公式则抛出这个异常
     */
    public double getResult() throws ArithmeticException {
        tryDecimal();
        tryNegative();

        while (!numberStack.isEmpty() && !operatorStack.isEmpty()) {
            double num2 = numberStack.pop();
            double num1 = numberStack.pop();
            String operator = operatorStack.pop();
            numberStack.push(calculate(num1, num2, operator));
        }

        calculated = true;

        if (numberStack.isEmpty()) {
            return 0.0;
        } else {
            return numberStack.peek();
        }
    }

    /**
     * 输入一个操作数
     *
     * @param value 整数
     */
    public void inputNum(int value) {
        double number = value;
        if (!nextNum) {
            number = numberStack.pop();
            number = number * 10 + value;
            if (decimal) decimalDigits++;
        }
        numberStack.push(number);

        //开始输入当前这个数字
        nextNum = false;
        //还未完成一次计算
        calculated = false;
    }

    /**
     * 输入一个运算符号
     *
     * @param op 运算符号，目前仅支持“+、-、*、/“，支持小数和负数
     * @throws ArithmeticException 如果输入不合法运算公式则抛出这个异常
     */
    public void inputOperator(String op) throws ArithmeticException {
        //输入运算符时意味着正在进行运算（即未完成）
        calculated = false;

        if (op.equals(".")) {
            //如果连续输入小数点则抛出异常
            if(decimal) throw new ArithmeticException("input double point");
            decimal = true;
            return;
        }
        if(op.equals("neg")){
            negative = !negative;
            return;
        }

        //如果多次输入操作符 (除了单目运算符，小数点，括号以外）
        if(nextNum) throw new ArithmeticException("input double operator");

        tryDecimal();
        tryNegative();

        while (!operatorStack.isEmpty() && compareOperator(op, operatorStack.peek()) < 0) {
            Double num2 = numberStack.pop();
            Double num1 = numberStack.pop();
            String operator = operatorStack.pop();
            numberStack.push(calculate(num1, num2, operator));
        }

        operatorStack.push(op);

        //输运算符后意味着开始输入下一个数字
        nextNum = true;
    }

    /**
     * 检验是否输入了小数
     */
    private boolean tryDecimal() {
        //如果刚刚输入的数字（即栈顶）是小数
        if (decimal) {
            double top = numberStack.pop();
            top *= Math.pow(10, -1 * decimalDigits);
            numberStack.push(top);

            //下一个数字不一定是小数，重置小数参数
            decimal = false;
            decimalDigits = 0;

            return true;
        }
        return false;
    }

    private boolean tryNegative() {
        if(negative){
            double top = numberStack.pop();
            numberStack.push(-top);

            //重置标记
            negative = false;

            return true;
        }
        return false;
    }

    private double calculate(double num1, double num2, String op) {
        //使用string类型消除double精度误差
        BigDecimal bigNum1 = new BigDecimal(String.valueOf(num1));
        BigDecimal bigNum2 = new BigDecimal(String.valueOf(num2));
        BigDecimal result;
        switch (op) {
            case "+":
                result = bigNum1.add(bigNum2);
                break;
            case "-":
                result = bigNum1.subtract(bigNum2);
                break;
            case "*":
                result = bigNum1.multiply(bigNum2);
                break;
            case "/":
                result = bigNum1.divide(bigNum2, BigDecimal.ROUND_HALF_UP);
                break;
            default:
                throw new ArithmeticException();
        }

        return result.doubleValue();
    }

    private int compareOperator(String op1, String op2) {
        int op1Level = 0, op2Level = 0;

        op1Level = operatorPriority.get(op1);
        op2Level = operatorPriority.get(op2);

        return op1Level - op2Level;
    }

}
