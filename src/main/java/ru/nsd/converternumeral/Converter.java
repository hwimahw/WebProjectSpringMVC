package ru.nsd.converternumeral;

import ru.nsd.converternumeral.exceptions.InputException;
import ru.nsd.converternumeral.exceptions.OverFlowException;

public class Converter {
    public static void main(String[] args) throws OverFlowException, InputException {
        String result = countResult("123", 10, 10);
        System.out.println(result);
    }

    public static String countResult(String number, int a, int b) throws OverFlowException, InputException{
        number = noZeros(number);
        checkForCorrectness(number, a);
        long numberInDecimal = convertFromAToDecimal(number, a , b);
        String result = convertToBNumeralSystem(numberInDecimal, b);
        return result;
    }

    public static void checkForCorrectness (String number, int a) throws InputException{
        char[] n = number.toCharArray();
        if(a <= 10) {
            for (int i = 0; i < n.length; i++) {
                if((int)n[i] < 48 || (int)n[i] > (48 + a - 1)){
                    throw new InputException("Неверные входные данные");
                }
            }
        }else{
            for (int i = 0; i < n.length; i++) {
                if((int)n[i] < 48 || ((int)n[i] > 57 && (int)n[i] < 97) || (int)n[i] > 97 + (a - 10) - 1){
                    throw new InputException("Неверные входные данные");
                }
            }
        }
    }

    public static String noZeros(String number){
        int i = 0;
        while(number.charAt(i) == '0'){
            i++;
            if(i == number.length()){
                return "0";
            }
        }
        return number.substring(i, number.length());
    }

    public static long convertFromAToDecimal(String number, int a, int b) throws OverFlowException{

        long result = 0;
        if(a <= 10) {
            int j = number.length() - 1;
            for (int i = number.length() - 1; i >= 0; i--) {
                int element = Integer.parseInt(number.substring(i, i + 1));
                result = result + element * (long) (Math.pow(a, j - i));
                if(result < 0){
                    throw new OverFlowException("Произошло переполение типа long");
                }
            }
        }else{
            int j = number.length() - 1;
            for (int i = number.length() - 1; i >= 0; i--) {
                char checkElement = number.charAt(i);
                int element;
                if((int)(checkElement) >= 97 && (int)(checkElement) <= 122){
                    element = letterToNumber(checkElement);
                }else{
                    element = Integer.parseInt(number.substring(i, i + 1));
                }
                result = result + element * (long)(Math.pow(a, j - i));
                if(result < 0){
                    throw new OverFlowException("Произошло переполение типа long");
                }
            }
        }
        return result;
    }

    public static String convertToBNumeralSystem(long numberInDecimal, int b){
        StringBuffer sb = new StringBuffer();
        long n = numberInDecimal;
        long q = b;
        while(n >= 1){
            long r = n % b;
            q = n / b;
            if(r >= 10){
                sb.append(numberToLetter(r));
                n = q;
                continue;
            }else{
                sb.append(r);
                n = q;
            }
        }
        return sb.reverse().toString();
    }

    private static int letterToNumber(char letter){
        return letter - 87;
    }

    private static char numberToLetter(long number){
        return (char)(number + 87);
    }
}
