package review;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit 2B Review & Practice FRQ Tests")
class ReviewTest {

    @Nested
    @DisplayName("Review #17: countOddDigits")
    class CountOddDigitsTests {
        @Test
        void jsonExample() {
            assertEquals(3, ReviewWriteIt.countOddDigits(37254));
        }

        @Test
        void edgeCases() {
            assertEquals(1, ReviewWriteIt.countOddDigits(1), "Single odd digit");
            assertEquals(0, ReviewWriteIt.countOddDigits(2), "Single even digit");
            assertEquals(0, ReviewWriteIt.countOddDigits(24680), "All even digits");
            assertEquals(5, ReviewWriteIt.countOddDigits(13579), "All odd digits");
            assertEquals(1, ReviewWriteIt.countOddDigits(10000), "Leading odd digit with zeros");
        }
    }

    @Nested
    @DisplayName("Review #18: reverseWord")
    class ReverseWordTests {
        @Test
        void jsonExample() {
            assertEquals("desserts", ReviewWriteIt.reverseWord("stressed"));
        }

        @Test
        void edgeCases() {
            assertEquals("a", ReviewWriteIt.reverseWord("a"), "Length-1 string");
            assertEquals("", ReviewWriteIt.reverseWord(""), "Empty string");
            assertEquals("racecar", ReviewWriteIt.reverseWord("racecar"), "Palindrome");
            assertEquals("ba", ReviewWriteIt.reverseWord("ab"), "Length-2 string");
            assertEquals("ynnuB sguB", ReviewWriteIt.reverseWord("Bugs Bunny"), "String with space");
        }
    }

    @Nested
    @DisplayName("Review #19: hasVowelPair")
    class HasVowelPairTests {
        @Test
        void jsonExamples() {
            assertTrue(ReviewWriteIt.hasVowelPair("beautiful"));
            assertFalse(ReviewWriteIt.hasVowelPair("banana"));
        }

        @Test
        void edgeCases() {
            assertFalse(ReviewWriteIt.hasVowelPair("a"), "Length-1 vowel cannot form a pair");
            assertFalse(ReviewWriteIt.hasVowelPair("x"), "Length-1 consonant");
            assertFalse(ReviewWriteIt.hasVowelPair(""), "Empty string");
            assertTrue(ReviewWriteIt.hasVowelPair("ae"), "Length-2 vowel pair");
            assertTrue(ReviewWriteIt.hasVowelPair("zoo"), "Vowel pair at very end (bounds check)");
            assertTrue(ReviewWriteIt.hasVowelPair("eat"), "Vowel pair at very start");
            assertFalse(ReviewWriteIt.hasVowelPair("rhythm"), "No vowels at all");
            assertFalse(ReviewWriteIt.hasVowelPair("abecidofu"), "Vowels separated by consonants");
        }
    }

    @Nested
    @DisplayName("Practice FRQ (a): Box.packBox")
    class BoxPackBoxTests {

        @AfterEach
        void tearDown() {
            Box.resetTestWeights();
        }

        @Test
        void jsonExamples() {
            // Example 1: 4.0, 6.5, 3.0, 9.0 with maxWeight 15.0 -> 3 items (total 13.5; 9.0 would make 22.5)
            Box.setTestWeights(4.0, 6.5, 3.0, 9.0, 1.0);
            assertEquals(3, Box.packBox(15.0));

            // Example 2: 5.0, 5.0, 1.0 with maxWeight 10.0 -> 2 items (exact 10.0 is allowed)
            Box.setTestWeights(5.0, 5.0, 1.0);
            assertEquals(2, Box.packBox(10.0));

            // Example 3: 12.0 with maxWeight 10.0 -> 0 items (first item already exceeds maxWeight)
            Box.setTestWeights(12.0, 1.0);
            assertEquals(0, Box.packBox(10.0));
        }

        @Test
        void edgeCases() {
            // Single item equals maxWeight exactly, next item pushes over
            Box.setTestWeights(10.0, 0.1);
            assertEquals(1, Box.packBox(10.0), "Single item matching maxWeight exactly should be packed");

            // First item slightly exceeds maxWeight -> 0 items
            Box.setTestWeights(10.01, 1.0);
            assertEquals(0, Box.packBox(10.0), "0-item box when first item slightly exceeds maxWeight");

            // Many small items hitting exact maxWeight
            Box.setTestWeights(2.5, 2.5, 2.5, 2.5, 0.5);
            assertEquals(4, Box.packBox(10.0), "Four 2.5 items hit exact 10.0");

            // Zero maxWeight with positive first item -> 0 items
            Box.setTestWeights(0.5);
            assertEquals(0, Box.packBox(0.0), "0-item box when maxWeight is 0.0");
        }
    }
}
