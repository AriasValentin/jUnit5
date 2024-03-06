package jUnit5;

public class Calculadora {

    private int resultado;

    public int sumar(int num1,int num2){
        resultado = num1 + num2;
        return resultado;
    }

    public int dividir(int num1,int num2){
        resultado = num1 / num2;
        return resultado;
    }
    public int divideByZero(int num1,int num2){
        if(num2 == 0)
        {
            throw  new ArithmeticException("no se puede dividir por 0.");
        }
        resultado = num1 / num2;
        return resultado;
    }

    public int restar(int num1,int num2){
        resultado = num1 - num2;
        return resultado;
    }
}
