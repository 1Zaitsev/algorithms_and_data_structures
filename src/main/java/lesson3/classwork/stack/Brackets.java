package lesson3.classwork.stack;

public class Brackets {

    public static void main(String[] args) {
        final String text =  "public E peek(} {return isEmpty(} ? null : data[size - 1;}";
        new Brackets(text).check();

    }

    private  final String codeText;

    public Brackets(String codeText){
        this.codeText = codeText;
    }

    public void check(){
        Stack<Character> stack = new StackImpl<>(codeText.length());

        for (int index = 0; index < codeText.length() ; index++) {
            checkCurrentChar(stack, index, codeText.charAt(index));
        }
        if(!stack.isEmpty()){
            System.err.println("Error: missing right delimiter");
        }
    }

    private void checkCurrentChar(Stack<Character> stack, int index, char currentChar) {
        switch (currentChar){
            case '<':
            case '{':
            case '(':
            case '[':
                stack.push(currentChar);
                break;

            case'>':
            case'}':
            case')':
            case']':
                if(stack.isEmpty()){
                    showError(index, currentChar);
                    break;
                }
                char lastOpenedBracket = stack.pop();
                if(
                        lastOpenedBracket == '<' && currentChar != '>' ||
                        lastOpenedBracket == '{' && currentChar != '}' ||
                        lastOpenedBracket == '(' && currentChar != ')' ||
                        lastOpenedBracket == '[' && currentChar != ']'
                ){
                    showError(index, currentChar);
                    break;
                }
            default:
                break;
        }
    }

    private void showError(int index, char currentChar) {
        System.err.printf("Error: %s at %d%n", currentChar, index);
    }
}
