class MagicPotion {

    private static String minimalSteps(String ingredients, int index, StringBuilder encodedStringBuilder) {
        if (index >= ingredients.length())
            return encodedStringBuilder.toString();    // encoded String.
        if (index != 0 && index * 2 <= ingredients.length()) {
            String stringToCompare = ingredients.substring(0, index);
            if (stringToCompare.equals(ingredients.substring(index, 2 * index))) {  // On match from start of the String.
                encodedStringBuilder.append("*");
                String resultFromPath1 =
                        minimalSteps(
                                ingredients,
                                2 * index,  // Encode and move forward
                                new StringBuilder(encodedStringBuilder.toString())
                        );

                encodedStringBuilder.setLength(encodedStringBuilder.length() - 1);  // Remove encoding.
                encodedStringBuilder.append(ingredients.charAt(index));
                String resultFromPath2 =
                        minimalSteps(
                                ingredients,
                                index + 1,  // Append the character and move one step forward.
                                new StringBuilder(encodedStringBuilder.toString())
                        );
                return resultFromPath1.length() < resultFromPath2.length() ? resultFromPath1 : resultFromPath2;
            }
        }
        encodedStringBuilder.append(ingredients.charAt(index));
        return minimalSteps(
                ingredients,
                index + 1,  // Append the character and move one step forward.
                new StringBuilder(encodedStringBuilder.toString())
        );
    }

    private static Integer minimalSteps(String ingredients) {
        String res = minimalSteps(ingredients, 0, new StringBuilder());
        System.out.println(ingredients + ": " + res);
        return res.length();
    }

    public static void main(String[] args) {
        if (minimalSteps("ABABCABABCE") == 6
                && minimalSteps("ABCDABCE") == 8
                && minimalSteps("ABCABCE") == 5
                && minimalSteps("AAA") == 3
                && minimalSteps("AAAA") == 3
                && minimalSteps("BBB") == 3
                && minimalSteps("AAAAAA") == 4) {
            System.out.println();
            System.out.println("Pass");
        } else {
            System.out.println();
            System.out.println("Fail");
        }
    }
}