package com.taseerahmad.linkzapper.util;

import java.util.HashMap;
import java.util.Map;

public final class IDUtil {
    private static HashMap<Character, Integer> charToNumberMapping;
    private static HashMap<Integer, Character> numberToCharMapping;

    private IDUtil()
    {
        initCharToNumberMapping();
        initNumberToCharMapping();
    }

    public static char getCharFromNumber(int number)
    {
        return numberToCharMapping.get(number);
    }

    public static int getNumberFromChar(char character)
    {
        return charToNumberMapping.get(character);
    }

    private void initCharToNumberMapping()
    {
        char charKey = 'a';
        charToNumberMapping = new HashMap<>();

        for (int number = 0; number < 26; number++) {
            charToNumberMapping.put(charKey++, number);
        }

        charKey = 'A';
        for (int number = 26; number < 52; number++) {
            charToNumberMapping.put(charKey++, number);
        }

        charKey = '0';
        for (int number = 52; number < 62; number++) {
            charToNumberMapping.put(charKey++, number);
        }
    }

    private void initNumberToCharMapping()
    {
        numberToCharMapping = new HashMap<>();

        for (Map.Entry<Character, Integer> entry: charToNumberMapping.entrySet()) {
            char value = entry.getKey();
            int key = entry.getValue();
            numberToCharMapping.put(key, value);
        }
    }
}
