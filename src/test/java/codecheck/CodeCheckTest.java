package codecheck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CodeCheck Unit 2B Practice Tests")
class CodeCheckTest {

    @Nested
    @DisplayName("1. DoubleLetter.hasDoubleLetter")
    class DoubleLetterTests {
        private final DoubleLetter solver = new DoubleLetter();

        @Test
        void jsonExamples() {
            assertTrue(solver.hasDoubleLetter("coffee"));
            assertFalse(solver.hasDoubleLetter("orange"));
            assertFalse(solver.hasDoubleLetter("x"));
        }

        @Test
        void edgeCases() {
            assertFalse(solver.hasDoubleLetter("a"), "Length-1 string cannot have a double letter");
            assertTrue(solver.hasDoubleLetter("aa"), "Length-2 identical string");
            assertFalse(solver.hasDoubleLetter("Aa"), "Case-sensitive: 'A' and 'a' are different");
            assertFalse(solver.hasDoubleLetter("aA"), "Case-sensitive: 'a' and 'A' are different");
            assertTrue(solver.hasDoubleLetter("aabb"), "Double letter at start");
            assertTrue(solver.hasDoubleLetter("abcc"), "Double letter at very end (bounds check)");
            assertFalse(solver.hasDoubleLetter("ababab"), "Repeated non-adjacent letters");
        }
    }

    @Nested
    @DisplayName("2. LargestDigit.largestDigit")
    class LargestDigitTests {
        private final LargestDigit solver = new LargestDigit();

        @Test
        void jsonExamples() {
            assertEquals(9, solver.largestDigit(52819));
            assertEquals(3, solver.largestDigit(3020));
            assertEquals(6, solver.largestDigit(6));
        }

        @Test
        void edgeCases() {
            assertEquals(1, solver.largestDigit(1), "Smallest positive int");
            assertEquals(9, solver.largestDigit(90000), "Largest digit at most-significant position");
            assertEquals(8, solver.largestDigit(12348), "Largest digit at ones place");
            assertEquals(4, solver.largestDigit(4444), "All identical digits");
            assertEquals(1, solver.largestDigit(10000), "Trailing zeros");
        }
    }

    @Nested
    @DisplayName("3. ApproxPi.approxPi")
    class ApproxPiTests {
        private final ApproxPi solver = new ApproxPi();

        @Test
        void jsonExamples() {
            assertEquals(4.0, solver.approxPi(1), 1e-9);
            assertEquals(3.1815766854350325, solver.approxPi(25), 1e-9);
        }

        @Test
        void edgeCases() {
            // 2 terms: 4 * (1 - 1/3) = 8/3
            assertEquals(8.0 / 3.0, solver.approxPi(2), 1e-9);
            // 3 terms: 4 * (1 - 1/3 + 1/5) = 52/15
            assertEquals(52.0 / 15.0, solver.approxPi(3), 1e-9);
            // 1000 terms should be close to Math.PI
            assertEquals(Math.PI, solver.approxPi(1000), 1e-2);
        }
    }

    @Nested
    @DisplayName("4. CheckPrime.checkPrime")
    class CheckPrimeTests {
        private final CheckPrime solver = new CheckPrime();

        @Test
        void jsonExamples() {
            assertTrue(solver.checkPrime(23));
            assertFalse(solver.checkPrime(120));
        }

        @Test
        void edgeCases() {
            assertTrue(solver.checkPrime(2), "2 is the smallest prime");
            assertTrue(solver.checkPrime(3));
            assertFalse(solver.checkPrime(4), "Smallest composite (perfect square 2*2)");
            assertFalse(solver.checkPrime(9), "Odd perfect square 3*3 (checks i * i <= num)");
            assertFalse(solver.checkPrime(25), "Odd perfect square 5*5");
            assertFalse(solver.checkPrime(49), "Odd perfect square 7*7");
            assertTrue(solver.checkPrime(97));
        }
    }

    @Nested
    @DisplayName("5. CountChar.countChar")
    class CountCharTests {
        private final CountChar solver = new CountChar();

        @Test
        void jsonExamples() {
            assertEquals(2, solver.countChar("Pizza party", "p"));
            assertEquals(1, solver.countChar("hip hip hooray", "a"));
            assertEquals(0, solver.countChar("carpark", "j"));
        }

        @Test
        void edgeCases() {
            assertEquals(1, solver.countChar("a", "a"), "Length-1 matching");
            assertEquals(1, solver.countChar("A", "a"), "Length-1 case-insensitive");
            assertEquals(0, solver.countChar("b", "a"), "Length-1 non-matching");
            assertEquals(3, solver.countChar("aAa", "A"), "Uppercase target letter");
            assertEquals(0, solver.countChar("", "a"), "Empty phrase");
        }
    }

    @Nested
    @DisplayName("6. DiagonalPrint.diagonalPrint")
    class DiagonalPrintTests {
        private final DiagonalPrint solver = new DiagonalPrint();

        @Test
        void jsonExamples() {
            assertEquals(
                    "O * * \n* O * \n* * O ",
                    solver.diagonalPrint(3)
            );
            assertEquals(
                    "O * * * * \n* O * * * \n* * O * * \n* * * O * \n* * * * O ",
                    solver.diagonalPrint(5)
            );
        }

        @Test
        void edgeCases() {
            assertEquals("O ", solver.diagonalPrint(1), "n=1 must have trailing space and NO trailing newline");
            assertEquals("O * \n* O ", solver.diagonalPrint(2), "n=2 exact spaces and newlines");
            assertFalse(solver.diagonalPrint(4).endsWith("\n"), "Must NOT end with a trailing newline");
            assertTrue(solver.diagonalPrint(4).endsWith(" "), "Last line must end with a trailing space");
        }
    }

    @Nested
    @DisplayName("7. Exclamations.exclamation")
    class ExclamationsTests {
        private final Exclamations solver = new Exclamations();

        @Test
        void jsonExamples() {
            assertEquals("p!i!z!z!a!", solver.exclamation("pizza"));
            assertEquals("I! !a!m! !s!l!e!e!p!y!", solver.exclamation("I am sleepy"));
        }

        @Test
        void edgeCases() {
            assertEquals("x!", solver.exclamation("x"), "Length-1 string");
            assertEquals(" !", solver.exclamation(" "), "Single space");
            assertEquals("", solver.exclamation(""), "Empty string");
            assertEquals("!!", solver.exclamation("!"), "Existing exclamation mark");
        }
    }

    @Nested
    @DisplayName("8. NumberDoubler.doubleNum")
    class NumberDoublerTests {
        private final NumberDoubler solver = new NumberDoubler();

        @Test
        void jsonExamples() {
            assertEquals(1, solver.doubleNum(50));
            assertEquals(3, solver.doubleNum(-14));
            assertEquals(0, solver.doubleNum(123));
        }

        @Test
        void edgeCases() {
            assertEquals(0, solver.doubleNum(100), "100 is already > 99");
            assertEquals(1, solver.doubleNum(99), "99 -> 198 takes 1 doubling");
            assertEquals(0, solver.doubleNum(-100), "-100 is already < -99");
            assertEquals(1, solver.doubleNum(-99), "-99 -> -198 takes 1 doubling");
            assertEquals(1, solver.doubleNum(-50), "-50 -> -100 takes 1 doubling");
            assertEquals(2, solver.doubleNum(-49), "-49 -> -98 -> -196 takes 2 doublings");
            assertEquals(7, solver.doubleNum(1), "1 -> 2 -> 4 -> 8 -> 16 -> 32 -> 64 -> 128");
            assertEquals(7, solver.doubleNum(-1), "-1 -> ... -> -128");
        }
    }

    @Nested
    @DisplayName("9. TrianglePrint.triPrint")
    class TrianglePrintTests {
        private final TrianglePrint solver = new TrianglePrint();

        @Test
        void jsonExamples() {
            assertEquals(
                    "5 4 3 2 1 \n4 3 2 1 \n3 2 1 \n2 1 \n1 ",
                    solver.triPrint(5)
            );
            assertEquals(
                    "2 1 \n1 ",
                    solver.triPrint(2)
            );
        }

        @Test
        void edgeCases() {
            assertEquals("1 ", solver.triPrint(1), "n=1 must have trailing space and NO trailing newline");
            assertEquals("3 2 1 \n2 1 \n1 ", solver.triPrint(3));
            assertFalse(solver.triPrint(4).endsWith("\n"), "Must NOT end with a trailing newline");
            assertTrue(solver.triPrint(4).endsWith(" "), "Last line must end with a trailing space");
        }
    }
}
