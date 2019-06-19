package brackets;

public class Brackets {

    static boolean isPar(char character1, char character2) {
        if (character1 == '(' && character2 == ')') {
            return true;
        } else if (character1 == '{' && character2 == '}') {
            return true;
        } else if (character1 == '[' && character2 == ']') {
            return true;
        } else {
            return false;
        }
    }

    static String pares(char letra[]) {
        String valid = "is valid";
        String notValid = "is not valid";
        pilha pilha = new pilha();
        for (int i = 0; i < letra.length; i++) {
            if (letra[i] == '{' || letra[i] == '(' || letra[i] == '[') {
                pilha.push(letra[i]);
            }
            if (letra[i] == '}' || letra[i] == ')' || letra[i] == ']') {
                if (pilha.isEmpty()) {
                    return notValid;
                } else if (!isPar(pilha.pop(), letra[i])) {
                    return notValid;
                }
            }
        }
        return (pilha.isEmpty()) ? valid : notValid;
    }

    public static void main(String[] args) {
        char letra[] = {'{', '(', ')', '}', '[', ']'};
//        char exp[] = {'{', '(', ')', '}', '['};

        System.out.println(pares(letra));
    }

    static class pilha {

        int top = -1;
        char items[] = new char[50];

        void push(char x) {
            if (top == 99) {
                System.out.println("cheio");
            } else {
                items[++top] = x;
            }
        }

        char pop() {
            if (top == -1) {
                System.out.println("erro");
                return '\0';
            } else {
                char element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty() {
            return (top == -1) ? true : false;
        }
    }
}
