# AP CSA Unit 2B — Copy-Paste Prompts by Problem

Each prompt tells the agent to check your code, run the JUnit 5 tests, tell you what's wrong and what to focus on, and help without spoiling the full solution from `reference_solutions/`.

---

## Overall Check (All Problems)

```text
Check all my implementations in src/main/java/codecheck/ and src/main/java/review/ by running the JUnit 5 tests. Do NOT edit my code or show me solutions from reference_solutions/. Tell me what passes, what fails and why, what patterns of mistakes I'm making, and what AP CSA Unit 2B concepts I should focus on most.
```

---

## CodeCheck Problems

### 1. DoubleLetter (`hasDoubleLetter`)
```text
Check my `hasDoubleLetter` implementation in `src/main/java/codecheck/DoubleLetter.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially bounds, length-1 strings, or case sensitivity), what I should focus on, and give me a hint if I'm stuck.
```

### 2. LargestDigit (`largestDigit`)
```text
Check my `largestDigit` implementation in `src/main/java/codecheck/LargestDigit.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially digit extraction, loop condition, or running max initialization), what I should focus on, and give me a hint if I'm stuck.
```

### 3. ApproxPi (`approxPi`)
```text
Check my `approxPi` implementation in `src/main/java/codecheck/ApproxPi.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially integer vs. floating-point division, alternating signs, or multiplying by 4), what I should focus on, and give me a hint if I'm stuck.
```

### 4. CheckPrime (`checkPrime`)
```text
Check my `checkPrime` implementation in `src/main/java/codecheck/CheckPrime.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially edge cases like 2 or perfect squares like 4, 9, 25, or early returns), what I should focus on, and give me a hint if I'm stuck.
```

### 5. CountChar (`countChar`)
```text
Check my `countChar` implementation in `src/main/java/codecheck/CountChar.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially case-insensitive matching, `equals` vs `==`, or string bounds), what I should focus on, and give me a hint if I'm stuck.
```

### 6. DiagonalPrint (`diagonalPrint`)
```text
Check my `diagonalPrint` implementation in `src/main/java/codecheck/DiagonalPrint.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially `row == col`, trailing spaces, or no trailing newline on the last line), what I should focus on, and give me a hint if I'm stuck.
```

### 7. Exclamations (`exclamation`)
```text
Check my `exclamation` implementation in `src/main/java/codecheck/Exclamations.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially string building, spaces, or length-1/empty strings), what I should focus on, and give me a hint if I'm stuck.
```

### 8. NumberDoubler (`doubleNum`)
```text
Check my `doubleNum` implementation in `src/main/java/codecheck/NumberDoubler.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially negative numbers, boundary values like 99/-99/100/-100, or the while condition), what I should focus on, and give me a hint if I'm stuck.
```

### 9. TrianglePrint (`triPrint`)
```text
Check my `triPrint` implementation in `src/main/java/codecheck/TrianglePrint.java` against its JUnit 5 tests in `CodeCheckTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially dependent decrementing loop bounds, trailing spaces, or no trailing newline on the last line), what I should focus on, and give me a hint if I'm stuck.
```

---

## Review "Write It" & Practice FRQ

### Review #17 (`countOddDigits`)
```text
Check my `countOddDigits` implementation in `src/main/java/review/ReviewWriteIt.java` against its JUnit 5 tests in `ReviewTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially digit extraction with `% 10` and `/ 10` or parity check), what I should focus on, and give me a hint if I'm stuck.
```

### Review #18 (`reverseWord`)
```text
Check my `reverseWord` implementation in `src/main/java/review/ReviewWriteIt.java` against its JUnit 5 tests in `ReviewTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially reverse loop bounds `length() - 1` down to `0` or `substring`), what I should focus on, and give me a hint if I'm stuck.
```

### Review #19 (`hasVowelPair`)
```text
Check my `hasVowelPair` implementation in `src/main/java/review/ReviewWriteIt.java` against its JUnit 5 tests in `ReviewTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially checking adjacent pairs without `StringIndexOutOfBoundsException`, length-1 strings, or vowel checking), what I should focus on, and give me a hint if I'm stuck.
```

### Practice FRQ (a): `Box.packBox`
```text
Check my `packBox` implementation in `src/main/java/review/Box.java` against its JUnit 5 tests in `ReviewTest`. Do NOT give me the fixed code or look at `reference_solutions/`. Tell me what's wrong (especially priming read / calling `getItemWeight()` the right number of times, exact `maxWeight` matches, or 0-item boxes), what I should focus on, and give me a hint if I'm stuck.
```
