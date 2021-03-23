package Stacks.Problems.MatchingParenthesis;

import Stacks.LinkedListImplementation.Stack;
import Stacks.StackUnderflowException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Operations {

    private static final Map<Character,Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')','(');
        matchingParenMap.put('}','{');
        matchingParenMap.put(']','[');

        openingParenSet.addAll(matchingParenMap.values());
    }

    public static void checkMatchingParens(String input){
        try{
            Stack<Character> parenStack = new Stack<>();

            for(int i = 0;i<input.length();i++){
                char ch = input.charAt(i);

                if(openingParenSet.contains(ch)){
                    parenStack.push(ch);
                }

                if(matchingParenMap.containsKey(ch)){
                    Character lastSeenParen = parenStack.pop();

                    if(lastSeenParen != matchingParenMap.get(ch)) {
                        System.out.println("\nInput: " + input + " Contains a mismatched parenthesis at index " + i + "'" + ch + "'");
                        return;
                    }
                }
            }

            if(parenStack.isEmpty()){
                System.out.println("\nInput: "+input+" Has matching parenthesis");
            }else {
                System.out.println("\nInput: "+input+" Has additional opening parenthesis: "+parenStack);
            }
        } catch (StackUnderflowException e) {
            System.out.println("\nInput: "+input+" has additional closing parenthesis");
        }
    }

    public static void main(String[] args) throws StackUnderflowException{

        checkMatchingParens("{(dddd)})");
    }
}
