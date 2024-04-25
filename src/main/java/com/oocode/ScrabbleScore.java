package com.oocode;


public class ScrabbleScore {
    public static String score(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++){
            char calculatedLetter = s.charAt(i);
            switch (calculatedLetter) {
                case 'A':
                case 'E':
                case 'I':
                case 'L':
                case 'N':
                case 'O':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                    score +=1; break;
                case 'D':
                case 'G':
                    score +=2; break;
                case 'B':
                case 'C':
                case 'M':
                case 'P':
                    score +=3; break;
                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y':
                    score +=4; break;
                case 'K':
                    score +=5; break;
                case 'J':
                case 'X':
                    score +=8; break;
                case 'Q':
                case 'Z':
                    score +=10; break;
                default: break;
            }
        }
        return Integer.toString(score);
    }

}
