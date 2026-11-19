import java.util.*;

/**
 * AP CSA Unit 2B Interactive Tracing Quiz Runner.
 *
 * Generates fresh, isomorphic tracing problems modeled on Review #1-#16:
 * - Stray semicolons & variable scope (#4, #6)
 * - Infinite loops & zero-iteration loops (#3, #5)
 * - Loop tracing: integer division, decrementing step, modulo accumulator (#1, #2, #7)
 * - Nested & dependent nested loops (#8, #9, #10, #11, #12)
 * - Alternating sign traces & while-loop state machines (#13, #14)
 * - Statement execution counts ("Which Does More Work?", #15, #16)
 */
public class Main {

    private static final Random RNG = new Random();

    enum Category {
        ALL("All Categories (Random Mix)"),
        STRAY_SEMICOLON("Stray Semicolons & Scope (#4, #6)"),
        INFINITE_AND_ZERO("Infinite & Zero-Iteration Loops (#3, #5)"),
        BASIC_TRACES("Basic Loop Traces (#1, #2, #7)"),
        NESTED_LOOPS("Dependent & Independent Nested Loops (#8-#12)"),
        TRICKY_TRACES("Alternating Sign & State Traces (#13, #14)"),
        EXECUTION_COUNTS("Statement Execution Counts (#15, #16)");

        final String label;

        Category(String label) {
            this.label = label;
        }
    }

    record Question(
            String title,
            String prompt,
            String code,
            String expectedDisplay,
            List<String> acceptedAnswers,
            String explanation
    ) {
        boolean matches(String rawInput) {
            String norm = normalize(rawInput);
            for (String acc : acceptedAnswers) {
                if (norm.equals(normalize(acc))) {
                    return true;
                }
            }
            return false;
        }

        private static String normalize(String s) {
            return s == null ? "" : s.trim().replaceAll("\\s+", " ").toLowerCase();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("   AP CSA Unit 2B — Isomorphic Loop Tracing Drill   ");
        System.out.println("====================================================");

        int correct = 0;
        int total = 0;
        int streak = 0;

        while (true) {
            Category cat = chooseCategory(in);
            if (cat == null) {
                break;
            }

            System.out.println("\nMode: " + cat.label);
            System.out.println("Type your answer, 's' to skip, or 'm' to return to menu.\n");

            while (true) {
                Question q = generateQuestion(cat);
                System.out.println("----------------------------------------------------");
                System.out.println("[" + q.title() + "]");
                System.out.println(q.prompt());
                System.out.println();
                System.out.println(q.code());
                System.out.println();
                System.out.print("Your answer > ");

                if (!in.hasNextLine()) {
                    return;
                }
                String answer = in.nextLine().trim();

                if (answer.equalsIgnoreCase("m") || answer.equalsIgnoreCase("menu")) {
                    break;
                }
                if (answer.equalsIgnoreCase("q") || answer.equalsIgnoreCase("quit")) {
                    printSummary(correct, total, streak);
                    return;
                }

                total++;
                if (answer.equalsIgnoreCase("s") || answer.equalsIgnoreCase("skip")) {
                    streak = 0;
                    System.out.println("Skipped. Expected: " + q.expectedDisplay());
                } else if (q.matches(answer)) {
                    correct++;
                    streak++;
                    System.out.println("CORRECT! (Streak: " + streak + " | Score: " + correct + "/" + total + ")");
                } else {
                    streak = 0;
                    System.out.println("INCORRECT. Expected: " + q.expectedDisplay());
                }
                System.out.println("Explanation: " + q.explanation());
                System.out.println();
            }
        }

        printSummary(correct, total, streak);
    }

    private static Category chooseCategory(Scanner in) {
        Category[] cats = Category.values();
        System.out.println("\nChoose a drill category:");
        for (int i = 0; i < cats.length; i++) {
            System.out.printf("  %d) %s%n", i + 1, cats[i].label);
        }
        System.out.println("  q) Quit");
        System.out.print("Select > ");

        if (!in.hasNextLine()) {
            return null;
        }
        String choice = in.nextLine().trim();
        if (choice.equalsIgnoreCase("q") || choice.equalsIgnoreCase("quit")) {
            return null;
        }
        try {
            int idx = Integer.parseInt(choice) - 1;
            if (idx >= 0 && idx < cats.length) {
                return cats[idx];
            }
        } catch (NumberFormatException ignored) {
        }
        System.out.println("Invalid choice, defaulting to All Categories.");
        return Category.ALL;
    }

    private static void printSummary(int correct, int total, int streak) {
        System.out.println("\n====================================================");
        System.out.printf("Session Complete: %d/%d correct (%.1f%%)%n",
                correct, total, total == 0 ? 0.0 : (100.0 * correct / total));
        System.out.println("====================================================");
    }

    private static Question generateQuestion(Category cat) {
        return switch (cat) {
            case STRAY_SEMICOLON -> RNG.nextBoolean() ? genReview04StraySemicolonError() : genReview06StraySemicolonCompiles();
            case INFINITE_AND_ZERO -> RNG.nextBoolean() ? genReview03InfiniteLoop() : genReview05ZeroIterLoop();
            case BASIC_TRACES -> switch (RNG.nextInt(3)) {
                case 0 -> genReview01IntDivision();
                case 1 -> genReview02DecrementStep();
                default -> genReview07ModuloAccumulator();
            };
            case NESTED_LOOPS -> switch (RNG.nextInt(5)) {
                case 0 -> genReview08NestedWhileCount();
                case 1 -> genReview09DependentLastRow();
                case 2 -> genReview10NestedArithmetic();
                case 3 -> genReview11DependentAccumulator();
                default -> genReview12StringPrefixLineCount();
            };
            case TRICKY_TRACES -> RNG.nextBoolean() ? genReview13AlternatingSign() : genReview14StateMachine();
            case EXECUTION_COUNTS -> RNG.nextBoolean() ? genReview15MoreWorkStepVsConst() : genReview16NestedVsSequential();
            case ALL -> {
                Category[] specific = {
                        Category.STRAY_SEMICOLON,
                        Category.INFINITE_AND_ZERO,
                        Category.BASIC_TRACES,
                        Category.NESTED_LOOPS,
                        Category.TRICKY_TRACES,
                        Category.EXECUTION_COUNTS
                };
                yield generateQuestion(specific[RNG.nextInt(specific.length)]);
            }
        };
    }

    // Modeled on Review #1: Integer division inside a for loop
    private static Question genReview01IntDivision() {
        int start = 2 + RNG.nextInt(3);      // 2..4
        int len = 4 + RNG.nextInt(2);        // 4..5 iterations
        int end = start + len;
        int div = 2 + RNG.nextInt(2);        // 2 or 3

        StringBuilder out = new StringBuilder();
        for (int i = start; i < end; i++) {
            out.append(i / div).append(" ");
        }
        String ans = out.toString().trim();

        String code = String.format("""
                for (int i = %d; i < %d; i++)
                {
                    System.out.print(i / %d + " ");
                }""", start, end, div);

        return new Question(
                "Review #1 Isomorph — Integer Division",
                "What is the exact output? (Separate numbers with spaces)",
                code,
                ans,
                List.of(ans),
                "Integer division truncates decimals for i = " + start + ".." + (end - 1) + ", stopping when i reaches " + end + "."
        );
    }

    // Modeled on Review #2: Decrementing for loop with step size
    private static Question genReview02DecrementStep() {
        int step = 2 + RNG.nextInt(2);       // 2 or 3
        int start = 8 + RNG.nextInt(5);      // 8..12
        int stop = 1 + RNG.nextInt(3);       // 1..3

        StringBuilder out = new StringBuilder();
        for (int i = start; i > stop; i -= step) {
            out.append(i).append(" ");
        }
        String ans = out.toString().trim();

        String code = String.format("""
                for (int i = %d; i > %d; i -= %d)
                {
                    System.out.print(i + " ");
                }""", start, stop, step);

        return new Question(
                "Review #2 Isomorph — Decrementing Loop",
                "What is the exact output? (Separate numbers with spaces)",
                code,
                ans,
                List.of(ans),
                "Starts at " + start + " and subtracts " + step + " each iteration while i > " + stop + "."
        );
    }

    // Modeled on Review #3: Infinite loop via integer division in update
    private static Question genReview03InfiniteLoop() {
        int div = 2 + RNG.nextInt(2);        // 2 or 3
        int add = div;                       // (0 + div) / div = 1, then (1 + div) / div = 1 forever
        int limit = 5 + RNG.nextInt(5);      // 5..9

        String code = String.format("""
                for (int i = 0; i < %d; i = (i + %d) / %d)
                {
                    System.out.print(i + " ");
                }""", limit, add, div);

        return new Question(
                "Review #3 Isomorph — Infinite Loop",
                "What is the output? (If it doesn't compile or never stops, say so)",
                code,
                "Infinite loop (0 1 1 1 ...)",
                List.of("infinite loop", "infinite", "never stops", "does not stop", "0 1 1 1 ..."),
                "i starts at 0; (0+" + add + ")/" + div + " = 1; then (1+" + add + ")/" + div + " = 1 via integer division forever."
        );
    }

    // Modeled on Review #4: Stray semicolon causing out-of-scope compile error
    private static Question genReview04StraySemicolonError() {
        int start = 1 + RNG.nextInt(3);
        int end = 7 + RNG.nextInt(4);
        String varName = RNG.nextBoolean() ? "i" : "k";

        String code = String.format("""
                for (int %s = %d; %s < %d; %s++);
                {
                    if (%s %% 2 == 0)
                    {
                        System.out.print(%s + " ");
                    }
                }""", varName, start, varName, end, varName, varName, varName);

        return new Question(
                "Review #4 Isomorph — Stray Semicolon (Scope Error)",
                "What is the output? (If it doesn't compile or never stops, say so)",
                code,
                "Does not compile (compile error)",
                List.of("does not compile", "doesn't compile", "compile error", "compiler error", "error"),
                "The trailing semicolon ends the for loop immediately with an empty body. Because '" + varName
                        + "' was declared in the for header, it is out of scope in the block below."
        );
    }

    // Modeled on Review #5: Zero-iteration loop
    private static Question genReview05ZeroIterLoop() {
        String[][] words = {
                {"HA", "P", "Y"},
                {"CA", "T", "S"},
                {"GO", "A", "L"},
                {"ST", "A", "R"}
        };
        String[] w = words[RNG.nextInt(words.length)];
        int limit = 5 + RNG.nextInt(5);
        int start = limit + 1 + RNG.nextInt(4);

        String code = String.format("""
                int limit = %d;
                int count;
                System.out.print("%s");
                for (count = %d; count <= limit; count++)
                {
                    System.out.print("%s");
                }
                System.out.print("%s");""", limit, w[0], start, w[1], w[2]);

        String ans = w[0] + w[2];
        return new Question(
                "Review #5 Isomorph — Zero-Iteration Loop",
                "What is printed?",
                code,
                ans,
                List.of(ans),
                "Initial condition " + start + " <= " + limit + " is immediately false, so the loop body runs 0 times."
        );
    }

    // Modeled on Review #6: Stray semicolon that DOES compile
    private static Question genReview06StraySemicolonCompiles() {
        String[][] phrases = {
                {"Hello ", "Hi ", "Bye"},
                {"Start ", "Go ", "Done"},
                {"Red ", "Blue ", "Green"},
                {"One ", "Two ", "Three"}
        };
        String[] p = phrases[RNG.nextInt(phrases.length)];
        int n = 3 + RNG.nextInt(4);

        String code = String.format("""
                int count;
                System.out.print("%s");
                for (count = 1; count <= %d; count++);
                {
                    System.out.print("%s");
                }
                System.out.print("%s");""", p[0], n, p[1], p[2]);

        String ans = p[0] + p[1] + p[2];
        return new Question(
                "Review #6 Isomorph — Stray Semicolon (Compiles!)",
                "What is printed?",
                code,
                ans,
                List.of(ans),
                "The semicolon closes the loop (empty body runs " + n + " times). Then the block printing \""
                        + p[1] + "\" runs ONCE, followed by \"" + p[2] + "\". Compiles because count is not used inside the block."
        );
    }

    // Modeled on Review #7: Decrementing loop with modulo accumulator
    private static Question genReview07ModuloAccumulator() {
        int start = 5 + RNG.nextInt(4);      // 5..8
        int rem = RNG.nextInt(2);            // 0 (even) or 1 (odd)
        int sum = 0;
        List<Integer> added = new ArrayList<>();
        for (int i = start; i > 0; i--) {
            if (i % 2 == rem) {
                sum += i;
                added.add(i);
            }
        }

        String code = String.format("""
                int num = 0;
                for (int i = %d; i > 0; i--)
                {
                    if (i %% 2 == %d)
                    {
                        num += i;
                    }
                }
                System.out.print(num);""", start, rem);

        String ans = String.valueOf(sum);
        return new Question(
                "Review #7 Isomorph — Modulo Accumulator",
                "What is printed?",
                code,
                ans,
                List.of(ans),
                "Adds values of i with i % 2 == " + rem + ": " + added + " -> sum = " + sum + "."
        );
    }

    // Modeled on Review #8: Nested while loops iteration count
    private static Question genReview08NestedWhileCount() {
        int outer = 4 + RNG.nextInt(8);      // 4..11
        int inner = 10 + RNG.nextInt(5) * 10; // 10, 20, 30, 40, 50
        int total = outer * inner;

        String code = String.format("""
                int count1 = 1;
                while (count1 <= %d)
                {
                    int count2 = 1;
                    while (count2 <= %d)
                    {
                        System.out.println("Here again");
                        count2++;
                    }
                    count1++;
                }""", outer, inner);

        String ans = String.valueOf(total);
        return new Question(
                "Review #8 Isomorph — Nested While Loops",
                "How many times is \"Here again\" printed? (Enter a number)",
                code,
                ans,
                List.of(ans, ans + " times"),
                "Outer loop runs " + outer + " times; inner loop resets count2 = 1 each time and runs "
                        + inner + " times. " + outer + " * " + inner + " = " + total + "."
        );
    }

    // Modeled on Review #9: Dependent nested loop last-row star count
    private static Question genReview09DependentLastRow() {
        int maxR = 6 + RNG.nextInt(8);       // 6..13
        boolean inclusive = RNG.nextBoolean();
        int lastRowStars = inclusive ? maxR : maxR - 1;
        String op = inclusive ? "<=" : "<";

        String code = String.format("""
                for (int r = 0; r %s %d; r++)
                {
                    for (int s = 0; s < r; s++)
                    {
                        System.out.print("*");
                    }
                    System.out.println();
                }""", op, maxR);

        String ans = String.valueOf(lastRowStars);
        return new Question(
                "Review #9 Isomorph — Dependent Nested Loop",
                "How many stars are printed in the LAST row of output? (Enter a number)",
                code,
                ans,
                List.of(ans, ans + " stars"),
                "On the final iteration of the outer loop, r = " + lastRowStars
                        + ". The inner loop runs for s = 0.." + (lastRowStars - 1) + " (" + lastRowStars + " stars)."
        );
    }

    // Modeled on Review #10: Nested for loops with arithmetic + string concatenation
    private static Question genReview10NestedArithmetic() {
        int aStart = 1 + RNG.nextInt(2);     // 1..2
        int aEnd = aStart + 1 + RNG.nextInt(2); // 2 or 3 outer iterations
        int bStart = 2 + RNG.nextInt(2);     // 2..3
        int bEnd = bStart + 3;               // 3 inner iterations

        StringBuilder out = new StringBuilder();
        for (int a = aStart; a <= aEnd; a++) {
            for (int b = bStart; b < bEnd; b++) {
                out.append(a + b).append(" ");
            }
        }
        String ans = out.toString().trim();

        String code = String.format("""
                for (int a = %d; a <= %d; a++)
                {
                    for (int b = %d; b < %d; b++)
                    {
                        System.out.print(a + b + " ");
                    }
                }""", aStart, aEnd, bStart, bEnd);

        return new Question(
                "Review #10 Isomorph — Nested Loop Output",
                "What is printed? (Separate numbers with spaces)",
                code,
                ans,
                List.of(ans),
                "a + b is evaluated as integer addition BEFORE concatenating \" \". Outer a = "
                        + aStart + ".." + aEnd + ", inner b = " + bStart + ".." + (bEnd - 1) + "."
        );
    }

    // Modeled on Review #11: Dependent nested loop accumulator
    private static Question genReview11DependentAccumulator() {
        int cStart = 2;
        int cEnd = 5 + RNG.nextInt(3);       // 5..7
        boolean inclusive = RNG.nextBoolean();
        String op = inclusive ? "<=" : "<";

        int total = 0;
        for (int c = cStart; c < cEnd; c++) {
            for (int d = 1; inclusive ? d <= c : d < c; d++) {
                total += d;
            }
        }

        String code = String.format("""
                int total = 0;
                for (int c = %d; c < %d; c++)
                {
                    for (int d = 1; d %s c; d++)
                    {
                        total = total + d;
                    }
                }
                System.out.println(total);""", cStart, cEnd, op);

        String ans = String.valueOf(total);
        return new Question(
                "Review #11 Isomorph — Dependent Nested Accumulator",
                "What is printed? (Enter a single integer)",
                code,
                ans,
                List.of(ans),
                "For each c from " + cStart + " to " + (cEnd - 1) + ", the inner loop sums d from 1 while d "
                        + op + " c, giving a grand total of " + total + "."
        );
    }

    // Modeled on Review #12: Nested loop String prefix triangle
    private static Question genReview12StringPrefixLineCount() {
        String[] words = {"Java Fun", "AP CSA", "Loop Lab", "Code Run"};
        String s = words[RNG.nextInt(words.length)];
        int targetLine = 3 + RNG.nextInt(s.length() - 2); // 1-based line number

        String expectedLine = s.substring(0, targetLine);

        String code = String.format("""
                String s = "%s";
                for (int e = 0; e < s.length(); e++)
                {
                    for (int f = 0; f <= e; f++)
                    {
                        System.out.print(s.substring(f, f + 1));
                    }
                    System.out.println();
                }""", s);

        return new Question(
                "Review #12 Isomorph — String Prefix Triangle",
                "What is printed on line #" + targetLine + " (1-based)? (Include spaces if any, or exact text)",
                code,
                "\"" + expectedLine + "\"",
                List.of(expectedLine, "\"" + expectedLine + "\""),
                "Line #" + targetLine + " corresponds to e = " + (targetLine - 1)
                        + ", which prints characters 0.." + (targetLine - 1) + ": \"" + expectedLine + "\"."
        );
    }

    // Modeled on Review #13: Alternating sign trace
    private static Question genReview13AlternatingSign() {
        int iters = 9 + RNG.nextInt(8);      // 9..16
        int count1 = 0, count2 = 0, inc = 1;
        for (int i = 0; i < iters; i++) {
            count1 += inc;
            inc = -inc;
            count2 += inc;
        }
        int result = count1 - count2;

        String code = String.format("""
                int count1 = 0;
                int count2 = 0;
                int inc = 1;
                for (int i = 0; i < %d; i++)
                {
                    count1 += inc;
                    inc = -inc;
                    count2 += inc;
                }
                System.out.println(count1 - count2);""", iters);

        String ans = String.valueOf(result);
        return new Question(
                "Review #13 Isomorph — Alternating Sign Trace",
                "What is printed? (Enter a single integer)",
                code,
                ans,
                List.of(ans),
                "Even i leaves (count1=1, count2=-1); odd i resets (count1=0, count2=0). "
                        + "Last iteration is i = " + (iters - 1) + " (" + ((iters - 1) % 2 == 0 ? "even" : "odd")
                        + "), so count1=" + count1 + ", count2=" + count2 + ", count1 - count2 = " + result + "."
        );
    }

    // Modeled on Review #14: While loop state machine trace
    private static Question genReview14StateMachine() {
        int targetA = 2 + RNG.nextInt(2);    // 2 or 3
        int a = 0, b = 0;
        StringBuilder out = new StringBuilder();
        while (a < targetA) {
            if (a + b == 0) {
                a++;
            } else if (a + b == 1 || a + b == 2) {
                b++;
            } else if (a + b == 3) {
                a++;
            } else {
                b = 0;
            }
            out.append(b).append(" ");
        }
        String ans = out.toString().trim();

        String code = String.format("""
                int a = 0;
                int b = 0;
                while (a < %d)
                {
                    if (a + b == 0)
                    {
                        a++;
                    }
                    else if (a + b == 1 || a + b == 2)
                    {
                        b++;
                    }
                    else if (a + b == 3)
                    {
                        a++;
                    }
                    else
                    {
                        b = 0;
                    }
                    System.out.print(b + " ");
                }""", targetA);

        return new Question(
                "Review #14 Isomorph — While Loop State Trace",
                "What is printed? (Separate numbers with spaces)",
                code,
                ans,
                List.of(ans),
                "Trace (a, b) after each iteration until a reaches " + targetA + ". Output: " + ans + "."
        );
    }

    // Modeled on Review #15: Statement execution count (5n vs (n/step)*n)
    private static Question genReview15MoreWorkStepVsConst() {
        int n = (4 + RNG.nextInt(5)) * 4;    // 16, 20, 24, 28, 32
        int k = 4 + RNG.nextInt(5);          // 4..8
        int step = 2;

        int segA = n * k;
        int segB = (n / step) * n;
        String winner = segA > segB ? "A" : (segB > segA ? "B" : "Tie");

        String code = String.format("""
                // n = %d, count = 0
                // Segment A
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < %d; j++)
                    {
                        count++;
                    }
                }

                // Segment B
                for (int i = 0; i < n; i += %d)
                {
                    for (int j = 0; j < n; j++)
                    {
                        count++;
                    }
                }""", n, k, step);

        String display = segA + " " + segB + " " + winner;
        return new Question(
                "Review #15 Isomorph — Statement Execution Count",
                "Enter: <Segment A count> <Segment B count> <A or B> (e.g., 100 200 B)",
                code,
                display,
                List.of(display, segA + ", " + segB + ", " + winner),
                "Segment A runs " + n + " * " + k + " = " + segA + " times. "
                        + "Segment B runs (" + n + "/" + step + ") * " + n + " = " + segB + " times. Winner: " + winner + "."
        );
    }

    // Modeled on Review #16: Nested vs sequential loops
    private static Question genReview16NestedVsSequential() {
        int n = 6 + RNG.nextInt(7);          // 6..12
        int numSeq = 3 + RNG.nextInt(2);     // 3 or 4 sequential loops
        int segA = n * n;
        int segB = numSeq * n;
        String winner = segA > segB ? "A" : (segB > segA ? "B" : "Tie");

        StringBuilder seqCode = new StringBuilder();
        String[] vars = {"i", "j", "k", "m"};
        for (int s = 0; s < numSeq; s++) {
            seqCode.append(String.format("""
                    for (int %s = 0; %s < n; %s++)
                    {
                        count++;
                    }
                    """, vars[s], vars[s], vars[s]));
        }

        String code = String.format("""
                // n = %d, count = 0
                // Segment A
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < n; j++)
                    {
                        count++;
                    }
                }

                // Segment B
                %s""", n, seqCode.toString().trim());

        String display = segA + " " + segB + " " + winner;
        return new Question(
                "Review #16 Isomorph — Nested vs Sequential Loops",
                "Enter: <Segment A count> <Segment B count> <A or B> (e.g., 100 30 A)",
                code,
                display,
                List.of(display, segA + ", " + segB + ", " + winner),
                "Nested loops multiply: n * n = " + segA + ". Sequential loops add: "
                        + numSeq + " * n = " + segB + ". Winner: " + winner + "."
        );
    }
}
