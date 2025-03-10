import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Define the grammar components
        Set<Character> VN = new HashSet<>(Arrays.asList('S', 'B', 'D'));
        Set<Character> VT = new HashSet<>(Arrays.asList('a', 'b' , 'c'));
        Map<Character, List<String>> P = new HashMap<>();
        P.put('S', Arrays.asList("aB", "bB" ));
        P.put('B', Arrays.asList("bD", "cB", "aS"));
        P.put('D', Arrays.asList("b", "aD"));
        Character S = 'S';
        // Create the grammar
        System.out.println("=== Creating Grammar ===");
        Grammar grammar = new Grammar(VN, VT, P, S);

        // Generate 5 valid strings
        System.out.println("\n=== Generating 5 Valid Strings ===");
        for (int i = 0; i < 5; i++) {
            System.out.println("String " + (i + 1) + ":");
            grammar.generateString();
        }

        // Convert the grammar to a finite automaton
        System.out.println("\n=== Converting Grammar To Finite Automaton ===");
        FiniteAutomaton automaton = grammar.toFiniteAutomaton();

        // Check if some strings belong to the language
        String[] testStrings = {"abb", "abc", "aabb", "baba"};
        System.out.println("\n=== Checking Strings ===");
        for (String testString : testStrings) {
            System.out.println("Testing String: " + testString);
            boolean belongs = automaton.stringBelongToLanguage(testString);
            System.out.println("Result: " + (belongs ? "Belongs" : "Does Not Belong"));
        }
    }
}