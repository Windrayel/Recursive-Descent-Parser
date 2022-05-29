import java.util.Scanner;

public class Main {
    static char[] symbols;
    static int currentCharIndex;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String symbols = in.nextLine();
        if (isDerivable(symbols)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }

    public static boolean isDerivable(String chain) {
        symbols = chain.toCharArray();
        currentCharIndex = 0;
        try {
            S();
            return true;
        } catch (RuntimeException e) {
           return false;
        }
    }

    private static void error() {
        throw new RuntimeException("Цепочка не выводима из грамматики");
    }

    private static char getChar() {
        char c = symbols[currentCharIndex];
        currentCharIndex++;
        return c;
    }

    private static void S() {
        char c = getChar();
        if (c != 'a')
            error();
        E();
        if (currentCharIndex != symbols.length)
            error();
    }

    private static void E() {
        char c = getChar();
        if (c == 'b') {
            A();
            A();
        }
        else if (c == 'c'){
            A();
            B();
        }
        else if (c != 'a')
            error();
    }

    private static void A() {
        char c = getChar();
        if (c != 'a')
            error();
        D();
    }

    private static void D() {
        char c = getChar();
        if (c != 'b') {
            currentCharIndex--;
            C();
            c = getChar();
            if (c != 'a')
                error();
        }
    }

    private static void C() {
        char c = getChar();
        if (c == 'a') {
            c = getChar();
            if (c != 'b')
                error();
            H();
        }
        else if (c == 'c') {
            C();
        } else error();
    }

    private static void H() {
        char c = getChar();
        if (c == 'c')
            A();
        else {
            A();
            B();
        }
    }

    private static void B() {
        C();
        A();
        char c = getChar();
        if (c != 'a')
            error();
    }
}