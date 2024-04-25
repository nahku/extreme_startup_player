package com.oocode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class Answerer {
    public String answerFor(String question) {
        question = question.replace("?", "");

        if (question.startsWith("Which of the following numbers is the largest:")){
            return Integer.toString(getMax(question));
        }

        Pattern multadd = Pattern.compile("What is (\\d+) multiplied by (\\d+) plus ");
        if (multadd.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            return Integer.toString(numbers[0]*numbers[1]+numbers[2]);
        }

        Pattern addmult = Pattern.compile("What is (\\d+) plus (\\d+) multiplied by ");
        if (addmult.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            return Integer.toString(numbers[0]+numbers[1]*numbers[2]);
        }

        Pattern addition = Pattern.compile("What is (\\d+) plus (\\d+)");
        if (addition.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            return Integer.toString(IntStream.of(numbers).sum());
        }

        Pattern sub = Pattern.compile("What is (\\d+) minus (\\d+)");
        if (sub.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            return Integer.toString(numbers[0] - numbers[1]);
        }

        Pattern multiply = Pattern.compile("What is (\\d+) multiplied by (\\d+)");
        if (multiply.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            int product=1;
            for(int i: numbers){
                product*=i;
            }
            return Integer.toString(product);
        }

        Pattern power = Pattern.compile("What is (\\d+) to the power of (\\d+)");
        if (power.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            var p = BigInteger.valueOf(numbers[0]).pow(numbers[1]);

            return p.toString();
        }

        if (question.startsWith("Which of the following numbers is both a square and a cube:")) {
            var numbers = getNumbersFromString(question);
            for(int i: numbers){
                var root = Math.sqrt(i);
                var cuberoot = Math.cbrt(i);
                if (root%1 == 0 && cuberoot%1 == 0){
                    return Integer.toString(i);
                }
            }
        }

        if (question.startsWith("Which of the following numbers are primes:")) {
            var numbers = getNumbersFromString(question);
            String result = "";
            for(int i: numbers){
                if (isPrime(i)){
                    result += i + ", ";
                }
            }
            return result.substring(0, result.length() - 2);
        }

        if (question.startsWith("Which of the following is an anagram of")) {
            var firstWord = question.split(":")[0];
            var firstWordList = firstWord.split(" ");
            firstWord = firstWordList[firstWordList.length-1];

            var wordString = question.split(": ")[1];
            var wordList = wordString.split(", ");
            for (String word:wordList) {
                if (isAnagram(firstWord, word)){
                    return word;
                }
            }
        }

        if (question.startsWith("What is the scrabble score of")) {

            var wordList = question.split(" ");
            var lastWord = wordList[wordList.length-1];
            return ScrabbleScore.score(lastWord.toUpperCase());
        }

        if (question.startsWith("What is your name")) {
            return "ns";
        }

        return "Not answered";
    }
//
//    private String addmult(int[] numbers, String question) {
//        Pattern p = Pattern.compile("multiplied by|plus|minus");
//        Matcher m = p.matcher(question);
//        int result=numbers[0];
//        ArrayList<String> commands = new ArrayList<>();
//        while (m.find()) {
//            switch m.group(){
//                case "multiplied by":
//                    result*=numbers[1];
//
//            }
//            numbers.add(Integer.parseInt(m.group()));
//        }
//
//        if (power.matcher(question).find()) {
//            var numbers = getNumbersFromString(question);
//
//            var p = pow(numbers[0], numbers[1]);
//
//            return BigDecimal.valueOf(p).toBigInteger().toString();
//        }
//    }

    private boolean isAnagram(String firstWord, String secondWord) {

        for (int i = 0; i < firstWord.length(); i++) {
            StringBuilder s = new StringBuilder(secondWord);
            var c = firstWord.charAt(i);
            var at = String.valueOf(s).indexOf(c);
            if(at == -1){
                return false;
            }
            else {
                secondWord = String.valueOf(s.deleteCharAt(at));
            }
        }
        if (secondWord.isEmpty()) {
            return true;
        }
        return false;
    }

    private int getMax(String s) {
        String numbers = s.split(":")[1].replace(" ","");
        int[] singleNumbers = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(singleNumbers)
                .max()
                .getAsInt();
    }

    private int [] getNumbersFromString(String s) {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(s);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }

}
