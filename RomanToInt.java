public class RomanToInt {
    class Solution {
        public int romanToInt(String s) {
            int length = s.length();
            int res = 0;
            for (int i = 0; i < length; i++) {
                //System.out.println(i);
                char c = s.charAt(i);
                if (c == 'M') {
                    res += 1000;
                }
                else if (c == 'D') {
                    res += 500;
                }
                else if (c == 'L') {
                    res += 50;
                }
                else if (c == 'V') {
                    res += 5;
                }
                else if (c == 'C') {
                    if (i < length - 1) {
                        if (s.charAt(i + 1) == 'D') {
                            res += 400;
                            i++;
                        }
                        else if (s.charAt(i + 1) == 'M') {
                            res += 900;
                            i++;
                        }
                        else {
                            res += 100;
                        }
                    }
                    else {
                        res += 100;
                    }
                }
                else if (c == 'X') {
                    if (i < length - 1) {
                        if (s.charAt(i + 1) == 'L') {
                            res += 40;
                            i++;
                        }
                        else if (s.charAt(i + 1) == 'C') {
                            res += 90;
                            i++;
                        }
                        else {
                            res += 10;
                        }
                    }
                    else {
                        res += 10;
                    }
                }
                else if (c == 'I') {
                    //System.out.println("here");
                    if (i < length - 1) {
                        if (s.charAt(i + 1) == 'V') {
                            res += 4;
                            i++;
                        }
                        else if (s.charAt(i + 1) == 'X') {
                            res += 9;
                            i++;
                        }
                        else {
                            res += 1;
                        }
                    }
                    else {
                        res += 1;
                    }
                }
            }
            return res; 
        }
    }
}
