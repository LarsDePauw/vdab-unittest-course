package com.realdolmen;




public class Calculator {
    int add(String numbers) {

        // TODO: to change a delimiter, the beginning of the string will contain a separate line that looks like this:
        //TODO: [delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .


        int total = 0;
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.contains("\n") || numbers.contains(",")) {
            String[] numbersStrings = numbers.split(", |\n");
            for (int i = 0; i < numbersStrings.length; i++) {
                total += Integer.parseInt(numbersStrings[i]);
            }
            return total;
        } else {
            return Integer.parseInt(numbers);
        }
    }
}
