// Iterative implement the method int strStr(String text, String pattern), returning the index of the first occurrence of pattern in text, or -1 if pattern is not part of text. 

class ImplementSolution {
    // Function to implement `strstr()` function
    public static int strstr(String text, String pattern) {
        // if `text` is null or if text's length is less than that of pattern's
        if (text == null || pattern.length() > text.length()) {
            return -1;
        }

        // if `pattern` is null or is empty
        if (pattern == null || pattern.length() == 0) {
            return 0;
        }

        for (int x = 0; x <= text.length() - pattern.length(); x++) {
            int y;
            for (y = 0; y < pattern.length(); y++) {
                if (pattern.charAt(y) != text.charAt(x + y)) {
                    break;
                }
            }

            if (y == pattern.length()) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "Excelent Sunlight";
        String pattern = "light";

        System.out.println("\nThe index of the first occurrence of pattern in text is "
                + strstr(text, pattern));
    }
}


/*
 * 
 * Output:
 * 
 * The index of the first occurrence of pattern in text is 12
 * 
 */

/*
 * In summary,
 * The time complexity of this solution is O(x.y) where x and y are the length
 * of string A and B, respectively.
 * 
 */