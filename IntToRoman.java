public class IntToRoman {
    class Solution {
        public String intToRoman(int num) {
            int[] numbers = {1000, 500, 100, 50, 10, 5, 1};
            String[] romanStrings = {"M", "D", "C", "L", "X", "V", "I"};
            String res = "";
            for (int i = 0; i < 7; i++) {
                if (num >= numbers[i]) {
                    int times = num / numbers[i];
                    if (times == 4) {
                        if (i == 6) {
                            res += "IV";
                        }
                        if (i == 4) {
                            res += "XL";
                        }
                        if (i == 2) {
                            res += "CD";
                        }
                        num %= numbers[i];
                    }
                    else if (num == 9) {
                        res += "IX";
                        num %= 9;
                    }
                    else if (num >= 90 && num < 100) {
                        res += "XC";
                        num %= 90;
                    }
                    else if (num >= 900 && num < 1000) {
                        res += "CM";
                        num %= 900;
                    }
                    else {
                        for (int j = 0; j < times; j++) {
                            res += romanStrings[i];
                        }
                        num %= numbers[i];
                    }
                }
            }
            return res;
        }
    }
}
