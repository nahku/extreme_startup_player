package com.oocode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Answerer {
    public String answerFor(String question) {
        question = question.replace("?", "");

        if (question.startsWith("Which of the following numbers is the largest:")){
            return Integer.toString(getMax(question));
        }

        Pattern addition = Pattern.compile("What is (\\d+) plus (\\d+)");
        if (addition.matcher(question).find()) {
            var numbers = getNumbersFromString(question);
            return Integer.toString(IntStream.of(numbers).sum());
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


        //"What is (\\d+) plus (\\d+)?"

        switch (question){
            case "What is your name":
                return "ns";
            default:
                return "Someone";
        }
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
}
