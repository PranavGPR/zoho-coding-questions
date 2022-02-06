public class ValidExpression {
    static char[] stack = new char[100];
    static int top = 0;

    private static void push(char a) {
        stack[top] = a;
        top++;
    }

    private static void pop() {
        if (top == -1) {
            System.out.println("Expression is invalid");
            return;
        } else {
            top--;
        }
    }

    private static void returnTop() {
        if (top == 0) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static void main(String[] args) {
        String exp = "((a+b))";
        // (a=b)(a*b)
        // (ab)(ab+)
        // ((a+b)

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                pop();
            }
        }
        returnTop();
    }
}
