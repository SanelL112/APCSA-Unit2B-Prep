# AP CSA Unit 2B Test Prep

IntelliJ-ready Maven project with JUnit 5 tests for AP CSA Unit 2B (Iteration, Loops, Nested Loops, String Traversal, Algorithm Analysis).

## Structure

- `src/main/java/codecheck/` — Blank method stubs for all 9 CodeCheck problems
- `src/main/java/review/ReviewWriteIt.java` — Blank method stubs for Review #17–#19
- `src/main/java/review/Box.java` — Blank `packBox(double maxWeight)` stub with deterministic test queue backing `getItemWeight()`
- `src/main/java/Main.java` — Interactive CLI quiz runner generating fresh, isomorphic tracing problems modeled on Review #1–#16
- `src/test/java/` — JUnit 5 test suites covering all JSON examples plus edge cases
- `reference_solutions/` — Complete reference solutions + original study export files (**excluded from IntelliJ indexing** so you won't spoil yourself in search/autocomplete)

## How to Use

1. **Practice Coding**: Implement the methods in `src/main/java/codecheck/` and `src/main/java/review/`.
2. **Run Tests**: Right-click `src/test/java` in IntelliJ IDEA and choose **Run 'All Tests'** (or run individual test classes).
3. **Drill Tracing**: Run `Main.java` in IntelliJ IDEA to practice randomized tracing questions modeled on Review #1–#16.
