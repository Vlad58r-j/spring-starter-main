package com.t_bank.exam;

import java.util.*;

public class Second {
    static final String t = "tbank";
    static final String s = "study";

    public static void main(String[] args) {
        var text = new Scanner(System.in).next();
        var length = text.length() - (text.length() % 10);
        var replace = 0;
        var sameT1 = 0;
        var sameS1 = 0;
        var sameT2 = 0;
        var sameS2 = 0;
        int different;
        for (int i = 0; i < length; i += 10) {
            var substring = text.substring(i, i + 10);

            if (substring.equals(t + s) || substring.equals(s + t))
                continue;

            for (int j = 0; j < 10; j++) {
                if (j < 5) {
                    if (substring.charAt(j) == t.charAt(j))
                        sameT1++;
                    else if (substring.charAt(j) == s.charAt(j))
                        sameS1++;
                } else {
                    different = 5;
                    if (substring.charAt(j) == t.charAt(j - different)) {
                        sameT2++;
                    } else if (substring.charAt(j) == s.charAt(j - different)) {
                        sameS2++;
                    }
                }
            }

            if (sameT1 > sameS1 && sameT1 > sameS2 && sameT1 > sameT2) {
                replace += (5 - sameT1) + (5 - sameS2);
            } else if (sameS1 > sameT1 && sameS1 > sameS2 && sameS1 > sameT2) {
                replace += (5 - sameS1) + (5 - sameT2);
            } else if (sameS2 > sameT2 && sameS2 > sameS1 && sameS2 > sameT1) {
                replace += (5 - sameS2) + (5 - sameT1);
            } else if (sameT2 > sameS2 && sameT2 > sameS1 && sameT2 > sameT1) {
                replace += (5 - sameT2) + (5 - sameS1);
            } else if (sameS1 == sameT1 && sameS1 == sameT2 && sameS2 == sameT2) {
                replace += (5 - sameT2) + (5 - sameS1);
            } else if (sameS1 == sameT1) {
                if (sameT2 > sameS2 && sameT2 > sameT1) {
                    replace += (5 - sameT2) + (5 - sameS1);
                } else {
                    replace += (5 - sameS2) + (5 - sameT1);
                }
            } else if (sameS2 == sameT2) {
                if (sameT1 > sameS1 && sameT1 > sameT2) {
                    replace += (5 - sameT1) + (5 - sameS2);
                } else {
                    replace += (5 - sameS1) + (5 - sameT2);
                }
            } else {
                replace += 10;
            }
        }

        System.out.println(replace);
    }
}