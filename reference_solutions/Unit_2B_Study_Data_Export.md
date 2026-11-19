# AP CSA Unit 2B — Complete Study Data Export

Structured export combining **Unit 2B Review Key.pdf** (19 review problems + FRQ Part a) and **9 CodeCheck Java practice problems**.

## Verification & OCR Notes

- Review #10: Inner loop upper bound reconstructed as `b < 5` from the key's exact output `3 4 5 4 5 6 5 6 7`.
- Review #11: Handwritten trace sums to 55 (which corresponds to `d <= c`). Raw OCR read `d < c` (which would print 35). Verify the inner condition on the printed sheet.
- Review #13: Loop trace cleanly ends at `count1 = 1`, `count2 = -1`. Verify the final print operator on the original sheet (`count1 - count2` prints `2`; `count1 + " " + count2` prints `1 -1`).
- Practice FRQ Part (b): Method signature `countFragileBeforeHeavy(String labels)` appears in the `Box` class header on page 7, but the prompt/key for Part (b) was not included in the 7-page PDF.

---

## Part 1: Unit 2B Review Packet (Prompts + Keys)

### Loop Tracing

#### Problem 1 (Page 1)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
for (int i = 2; i < 6; i++)
{
    System.out.print(i / 2 + " ");
}
```

**Answer Key:**
- **Loop Variable Values:** `i = 2, 3, 4, 5, 6`
- **Output:** `1 1 2 2 `
- **Trace / Notes:** Integer division truncates decimals: 2/2=1, 3/2=1, 4/2=2, 5/2=2. Loop terminates when i becomes 6.
- **Concepts:** for loop, integer division, loop termination value

#### Problem 2 (Page 1)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
for (int i = 8; i > 1; i -= 2)
{
    System.out.print(i + " ");
}
```

**Answer Key:**
- **Loop Variable Values:** `i = 8, 6, 4, 2, 0`
- **Output:** `8 6 4 2 `
- **Trace / Notes:** Decrements by 2 each iteration; stops when i reaches 0 (0 > 1 is false).
- **Concepts:** decrementing for loop, step size

#### Problem 3 (Page 1)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
for (int i = 0; i < 6; i = (i + 2) / 2)
{
    System.out.print(i + " ");
}
```

**Answer Key:**
- **Loop Variable Values:** `i = 0, 1, 1, 1, ...`
- **Output:** `0 1 1 1 ... (Infinite loop)`
- **Trace / Notes:** Starts at 0; (0+2)/2 = 1; then (1+2)/2 = 3/2 = 1 via integer division forever. Never reaches 6.
- **Concepts:** infinite loop, integer division in loop update

#### Problem 4 (Page 1)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
for (int i = 2; i < 9; i++);
{
    if (i % 2 == 0)
    {
        System.out.print(i + " ");
    }
}
```

**Answer Key:**
- **Loop Variable Values:** `Does not compile`
- **Output:** `Compiler error (i is out of scope)`
- **Trace / Notes:** The trailing semicolon after the for header ends the loop immediately with an empty body. Because i is declared in the for header, i does not exist inside the following block.
- **Concepts:** stray semicolon, variable scope, compile-time error

#### Problem 5 (Page 2)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
int limit = 8;
int count;
System.out.print("HA");
for (count = 10; count <= limit; count++)
{
    System.out.print("P");
}
System.out.print("Y");
```

**Answer Key:**
- **Loop Variable Values:** `count = 10 (loop body executes 0 times)`
- **Output:** `HAY`
- **Trace / Notes:** Initial condition 10 <= 8 is immediately false, so 'P' is never printed.
- **Concepts:** zero-iteration loop, loop condition check before body

#### Problem 6 (Page 2)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
int count;
System.out.print("Hello ");
for (count = 1; count <= 3; count++);
{
    System.out.print("Hi ");
}
System.out.print("Bye");
```

**Answer Key:**
- **Loop Variable Values:** `count = 1, 2, 3, 4`
- **Output:** `Hello Hi Bye`
- **Trace / Notes:** The semicolon immediately closes the loop (empty body runs 3 times). Then the block printing 'Hi ' runs once, followed by 'Bye'. Compiles because count is not referenced out of scope.
- **Concepts:** stray semicolon, block scope

#### Problem 7 (Page 2)
**Instructions:** Write the values the loop variable takes and the output. If the code doesn't compile or never stops, say so.

**Code:**
```java
int num = 0;
for (int i = 5; i > 0; i--)
{
    if (i % 2 == 1)
    {
        num += i;
    }
}
System.out.print(num);
```

**Answer Key:**
- **Loop Variable Values:** `i = 5, 4, 3, 2, 1, 0`
- **Output:** `9`
- **Trace / Notes:** Adds odd values of i: 5 + 3 + 1 = 9.
- **Concepts:** accumulator, modulo parity check, decrementing loop

### Nested Loops

#### Problem 8 (Page 3)
**Prompt:** How many times is "Here again" printed?

**Code:**
```java
int count1 = 1;
while (count1 <= 10)
{
    int count2 = 1;
    while (count2 <= 50)
    {
        System.out.println("Here again");
        count2++;
    }
    count1++;
}
```

**Answer Key:**
- **Output:** `500 times`
- **Trace / Notes:** Outer loop runs 10 times; inner loop resets count2 = 1 each time and runs 50 times. 10 * 50 = 500.
- **Concepts:** nested while loops, iteration counting

#### Problem 9 (Page 3)
**Prompt:** How many stars are printed in the last row of output?

**Code:**
```java
for (int r = 0; r <= 10; r++)
{
    for (int s = 0; s < r; s++)
    {
        System.out.print("*");
    }
    System.out.println();
}
```

**Answer Key:**
- **Output:** `10 stars`
- **Trace / Notes:** On the final iteration of the outer loop, r = 10. Inner loop runs for s = 0..9 (10 iterations).
- **Concepts:** dependent nested loops, pattern printing

#### Problem 10 (Page 3)
**Prompt:** What is printed?

**Code:**
```java
for (int a = 1; a <= 3; a++)
{
    for (int b = 2; b < 5; b++)
    {
        System.out.print(a + b + " ");
    }
}
```

**Answer Key:**
- **Output:** `3 4 5 4 5 6 5 6 7 `
- **Trace / Notes:** a=1 gives (1+2, 1+3, 1+4) = 3 4 5; a=2 gives 4 5 6; a=3 gives 5 6 7. Note: upper bound `5` reconstructed from key output.
- **Concepts:** nested for loops, string concatenation with arithmetic

#### Problem 11 (Page 4)
**Prompt:** What is printed?

**Code:**
```java
int total = 0;
for (int c = 2; c < 7; c++)
{
    for (int d = 1; d <= c; d++) // Verify original PDF: key trace uses d <= c (55); OCR read d < c (35)
    {
        total = total + d;
    }
}
System.out.println(total);
```

**Answer Key:**
- **Output:** `55 (if d <= c, matching key trace) / 35 (if d < c)`
- **Trace / Notes:** With d <= c: sums are (1+2)=3, +(1+2+3)=9, +(1+2+3+4)=19, +(1+2+3+4+5)=34, +(1+2+3+4+5+6)=55. With d < c: 1+3+6+10+15 = 35.
- **Concepts:** dependent nested loops, nested accumulator

#### Problem 12 (Page 4)
**Prompt:** What is printed?

**Code:**
```java
String s = "Bugs Bunny";
for (int e = 0; e < s.length(); e++)
{
    for (int f = 0; f <= e; f++)
    {
        System.out.print(s.substring(f, f + 1));
    }
    System.out.println();
}
```

**Answer Key:**
- **Output:**
```text
B
Bu
Bug
Bugs
Bugs 
Bugs B
Bugs Bu
Bugs Bun
Bugs Bunn
Bugs Bunny
```
- **Trace / Notes:** Prints progressively longer prefixes of 'Bugs Bunny'. Line 5 ('Bugs ') ends with a space character (index 4).
- **Concepts:** nested loops, String substring traversal, whitespace characters

### Tricky Traces

#### Problem 13 (Page 4)
**Prompt:** What is printed?

**Code:**
```java
int count1 = 0;
int count2 = 0;
int inc = 1;
for (int i = 0; i < 11; i++)
{
    count1 += inc;
    inc = -inc;
    count2 += inc;
}
System.out.println(count1 - count2); // Verify operator on original PDF (OCR dropped operator)
```

**Answer Key:**
- **Output:** `After i = 10: count1 = 1, count2 = -1 (prints 2 if `count1 - count2`, or `1 -1` if concatenated)`
- **Trace / Notes:** Even i (0,2,4,6,8,10) leaves count1=1, count2=-1, inc=-1. Odd i (1,3,5,7,9) resets count1=0, count2=0, inc=1. Last iteration is i=10 (even).
- **Concepts:** alternating sign state, pattern recognition in loops, even vs odd iterations

#### Problem 14 (Page 5)
**Prompt:** What is printed?

**Code:**
```java
int a = 0;
int b = 0;
while (a < 3)
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
    System.out.println(b);
}
```

**Answer Key:**
- **Output:**
```text
0
1
2
2
0
1
1
```
- **Trace / Notes:** State table (a,b) after each step: (1,0)->0; (1,1)->1; (1,2)->2; (2,2)->2; (2,0)->0; (2,1)->1; (3,1)->1; then a<3 is false.
- **Concepts:** while loop state trace, chained if/else if/else

### Which Does More Work?

#### Problem 15 (Page 5)
**Prompt:** n is 20. count starts at 0. Give how many times count++ runs in each segment, and say which one does more work.

**Code:**
```java
// Segment A
for (int i = 0; i < n; i++)
{
    for (int j = 0; j < 5; j++)
    {
        count++;
    }
}

// Segment B
for (int i = 0; i < n; i += 2)
{
    for (int j = 0; j < n; j++)
    {
        count++;
    }
}
```

**Answer Key:**
- **Output:** `Segment A: 100 times (20 * 5). Segment B: 200 times (10 * 20). Segment B does more work.`
- **Trace / Notes:** Segment A executes 5n = 100 times; Segment B executes (n/2)*n = 10*20 = 200 times.
- **Concepts:** statement execution count, nested loop complexity, step size

#### Problem 16 (Page 6)
**Prompt:** n is 10. count starts at 0. Give how many times count++ runs in each segment, and say which one does more work.

**Code:**
```java
// Segment A
for (int i = 0; i < n; i++)
{
    for (int j = 0; j < n; j++)
    {
        count++;
    }
}

// Segment B
for (int i = 0; i < n; i++)
{
    count++;
}
for (int j = 0; j < n; j++)
{
    count++;
}
for (int k = 0; k < n; k++)
{
    count++;
}
```

**Answer Key:**
- **Output:** `Segment A: 100 times (10 * 10). Segment B: 30 times (10 + 10 + 10). Segment A does more work.`
- **Trace / Notes:** Nested loops multiply (n^2 = 100); sequential (non-nested) loops add (3n = 30).
- **Concepts:** nested vs sequential loops, statement execution count

### Write It

#### Problem 17 (Page 6)
**Prompt:** num is a positive int. Write code that counts how many digits of num are odd, then prints the count. For example, if num is 37254, it prints 3.

**Answer Key:**
- **Reference Solution:**
```java
int count = 0;
while (num > 0)
{
    int digit = num % 10;
    if (digit % 2 == 1)
    {
        count++;
    }
    num /= 10;
}
System.out.print(count);
```
- **Concepts:** digit extraction, while loop, modulo and integer division

#### Problem 18 (Page 6)
**Prompt:** word is a String. Write code that prints word backwards. For example, if word is "stressed", it prints "desserts".

**Answer Key:**
- **Reference Solution:**
```java
String rev = "";
for (int i = word.length() - 1; i >= 0; i--)
{
    rev += word.substring(i, i + 1);
}
System.out.println(rev);
```
- **Concepts:** reverse String traversal, String building, substring

#### Problem 19 (Page 6)
**Prompt:** word is a String. Write code that sets hasVowelPair to true if word has two vowels (a, e, i, o, u) in a row anywhere, and false otherwise. For example, "beautiful" gives true and "banana" gives false.

**Answer Key:**
- **Reference Solution:**
```java
boolean hasVowelPair = false;
for (int i = 0; i < word.length() - 1; i++)
{
    String curr = word.substring(i, i + 1);
    String next = word.substring(i + 1, i + 2);
    if ("aeiou".indexOf(curr) >= 0 && "aeiou".indexOf(next) >= 0)
    {
        hasVowelPair = true;
    }
}
```
- **Trace / Notes:** Loop stops at word.length() - 1 because we inspect pairs (i and i+1) to prevent StringIndexOutOfBoundsException.
- **Concepts:** adjacent pair comparison, indexOf, bounds safety

### Practice Free-Response

#### Problem FRQ (a) (Page 7)
**Prompt:** A shipping company packs items into boxes using the Box class (with helper `public static double getItemWeight()`). Write `packBox(double maxWeight)`. Items are packed one at a time in the order returned by `getItemWeight()`. Packing stops when the next item would make the total weight greater than `maxWeight`. That item is not packed. Return the number of items packed.

**Starter Code:**
```java
public class Box
{
    public static double getItemWeight() { /* implementation not shown */ }
    public static int packBox(double maxWeight) { /* to be implemented in part (a) */ }
    public static int countFragileBeforeHeavy(String labels) { /* to be implemented in part (b) - not in PDF */ }
}
```

**Examples:**
| Weights | maxWeight | Returns | Note |
| --- | --- | --- | --- |
| `4.0, 6.5, 3.0, 9.0, ...` | `15.0` | `3` | 9.0 would make total 22.5 |
| `5.0, 5.0, 1.0, ...` | `10.0` | `2` | total of exactly 10.0 is allowed |
| `12.0, ...` | `10.0` | `0` | first item already exceeds maxWeight |

**Answer Key:**
- **Reference Solution:**
```java
public static int packBox(double maxWeight)
{
    int count = 0;
    double total = 0;
    double next = getItemWeight();
    while (total + next <= maxWeight)
    {
        count++;
        total += next;
        next = getItemWeight();
    }
    return count;
}
```
- **Trace / Notes:** Uses a priming read (`next = getItemWeight()`) before the loop so the candidate item can be checked against `maxWeight` before adding it and incrementing `count`.
- **Concepts:** AP CSA FRQ, while loop with priming read, accumulator and counter

---

## Part 2: CodeCheck Interactive Practice Problems (9 Tabs)

### 1. `DoubleLetter.java`
- **Method Signature:** `public boolean hasDoubleLetter(String word)`
- **Source Link:** [DoubleLetter on CodeCheck](https://codecheck.io/files/2610231444bdwx9y4xhz8601ea61f8wlxmj)
- **Prompt:** Given a String (at least one character), determine whether it has the same letter twice in a row. Return true if any letter is immediately followed by the same letter, false otherwise. Capital and lowercase letters count as different letters.
- **Examples:**
  - Input: `coffee` -> Output: `true`
  - Input: `orange` -> Output: `false`
  - Input: `x` -> Output: `false`
- **Verified Solution (10/10):**
```java
public boolean hasDoubleLetter(String word) {
    for (int i = 0; i < word.length() - 1; i++) {
        if (word.charAt(i) == word.charAt(i + 1)) {
            return true;
        }
    }
    return false;
}
```
- **Concepts:** adjacent character comparison, early return, bounds (length - 1)

### 2. `LargestDigit.java`
- **Method Signature:** `public int largestDigit(int num)`
- **Source Link:** [LargestDigit on CodeCheck](https://codecheck.io/files/261023130513q7ac139hg8on7f27x3fp935)
- **Prompt:** Given a positive int, return its largest digit.
- **Examples:**
  - Input: `52819` -> Output: `9`
  - Input: `3020` -> Output: `3`
  - Input: `6` -> Output: `6`
- **Verified Solution (10/10):**
```java
public int largestDigit(int num) {
    int max = 0;
    while (num > 0) {
        int digit = num % 10;
        if (digit > max) {
            max = digit;
        }
        num /= 10;
    }
    return max;
}
```
- **Concepts:** digit extraction, running maximum, while loop

### 3. `ApproxPi.java`
- **Method Signature:** `public double approxPi(int terms)`
- **Source Link:** [ApproxPi on CodeCheck](https://codecheck.io/files/241018163624elbnhbof3ozqcan4dph87ks)
- **Prompt:** The Leibniz approximation for pi is pi/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ... Given a number of terms (>= 1), return the Leibniz approximation for pi to that many terms.
- **Examples:**
  - Input: `1` -> Output: `4.0`
  - Input: `25` -> Output: `3.1815766854350325`
- **Verified Solution (10/10):**
```java
public double approxPi(int terms) {
    double sum = 0.0;
    for (int i = 0; i < terms; i++) {
        double term = 1.0 / (2 * i + 1);
        if (i % 2 == 0) {
            sum += term;
        } else {
            sum -= term;
        }
    }
    return sum * 4.0;
}
```
- **Concepts:** alternating series, floating-point division, for loop accumulator

### 4. `CheckPrime.java`
- **Method Signature:** `public boolean checkPrime(int num)`
- **Source Link:** [CheckPrime on CodeCheck](https://codecheck.io/files/2410181628ejbcuoyuta0u12d7grm17vf8c)
- **Prompt:** Given a positive int (>= 2), determine whether or not it is prime.
- **Examples:**
  - Input: `23` -> Output: `true`
  - Input: `120` -> Output: `false`
- **Verified Solution (10/10):**
```java
public boolean checkPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}
```
- **Concepts:** divisibility testing, sqrt optimization, early return

### 5. `CountChar.java`
- **Method Signature:** `public int countChar(String phrase, String letter)`
- **Source Link:** [CountChar on CodeCheck](https://codecheck.io/files/24101817014qo11nvpd5osbi8e5a6mewvbx)
- **Prompt:** Given a string and a single letter, count how many times that letter appears in the string (case-insensitive).
- **Examples:**
  - Input: `Pizza party, p` -> Output: `2`
  - Input: `hip hip hooray, a` -> Output: `1`
  - Input: `carpark, j` -> Output: `0`
- **Verified Solution (10/10):**
```java
public int countChar(String phrase, String letter) {
    phrase = phrase.toLowerCase();
    letter = letter.toLowerCase();
    int count = 0;
    for (int i = 0; i < phrase.length(); i++) {
        if (phrase.substring(i, i + 1).equals(letter)) {
            count++;
        }
    }
    return count;
}
```
- **Concepts:** case-insensitive matching, String traversal, substring + equals

### 6. `DiagonalPrint.java`
- **Method Signature:** `public String diagonalPrint(int n)`
- **Source Link:** [DiagonalPrint on CodeCheck](https://codecheck.io/files/24101817116d51oj6apd9zddgz0nsuj6221)
- **Prompt:** Given a positive integer (n), return a string containing an n by n grid of asterisks except the positive diagonal (top left to lower right) is replaced by an O. Each symbol is followed by a space, including the last one on each line.
- **Examples:**
  - Input: `3` -> Output:
```text
O * * 
* O * 
* * O 
```
  - Input: `5` -> Output:
```text
O * * * * 
* O * * * 
* * O * * 
* * * O * 
* * * * O 
```
- **Verified Solution (10/10):**
```java
public String diagonalPrint(int n) {
    String result = "";
    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            if (row == col) {
                result += "O ";
            } else {
                result += "* ";
            }
        }
        if (row < n - 1) {
            result += "\n";
        }
    }
    return result;
}
```
- **Concepts:** nested loops, 2D grid indexing (row == col), newline formatting

### 7. `Exclamations.java`
- **Method Signature:** `public String exclamation(String input)`
- **Source Link:** [Exclamations on CodeCheck](https://codecheck.io/files/2410181652300phyahqslluvyz2l7tt2wzu)
- **Prompt:** Given a string, return that same string with every character followed by an exclamation mark.
- **Examples:**
  - Input: `pizza` -> Output: `p!i!z!z!a!`
  - Input: `I am sleepy` -> Output: `I! !a!m! !s!l!e!e!p!y!`
- **Verified Solution (10/10):**
```java
public String exclamation(String input) {
    String result = "";
    for (int i = 0; i < input.length(); i++) {
        result += input.substring(i, i + 1) + "!";
    }
    return result;
}
```
- **Concepts:** String building, single-character substring traversal

### 8. `NumberDoubler.java`
- **Method Signature:** `public int doubleNum(int input)`
- **Source Link:** [NumberDoubler on CodeCheck](https://codecheck.io/files/241018121286rldfcm8krh6e6zgtiayyl8a)
- **Prompt:** Take an input (will not be 0) and count how many times you have to double it before it reaches 100 (i.e., before it is > 99 or < -99).
- **Examples:**
  - Input: `50` -> Output: `1`
  - Input: `-14` -> Output: `3`
  - Input: `123` -> Output: `0`
- **Verified Solution (10/10):**
```java
public int doubleNum(int input) {
    int doubleNum = 0;
    while (input < 100 && input > -100) {
        input *= 2;
        doubleNum++;
    }
    return doubleNum;
}
```
- **Concepts:** while loop, compound boolean condition, negative number handling

### 9. `TrianglePrint.java`
- **Method Signature:** `public String triPrint(int n)`
- **Source Link:** [TrianglePrint on CodeCheck](https://codecheck.io/files/2410181718cpcutezpekac4q16jm0y8j38e)
- **Prompt:** Given a positive int, return a string containing a countdown triangle from that number matching the examples. Each number is followed by a space, including the last one on each line.
- **Examples:**
  - Input: `5` -> Output:
```text
5 4 3 2 1 
4 3 2 1 
3 2 1 
2 1 
1 
```
  - Input: `2` -> Output:
```text
2 1 
1 
```
- **Verified Solution (10/10):**
```java
public String triPrint(int n) {
    String result = "";
    for (int i = n; i >= 1; i--) {
        for (int j = i; j >= 1; j--) {
            result += j + " ";
        }
        if (i > 1) {
            result += "\n";
        }
    }
    return result;
}
```
- **Concepts:** dependent nested decrementing loops, String building, newline formatting
