public class LicenseKeyFormatting {
    class Solution {
        public String licenseKeyFormatting(String s, int k) {
            String[] strs = s.split("-");
            int length = strs.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                strs[i] = strs[i].toUpperCase();
                sb.append(strs[i]);
            }
            String entire = sb.toString();
            sb.delete(0, sb.length());
            int idx = entire.length() - k;
            while (idx >= 0) {
                sb.insert(0, entire.substring(idx, idx + k));
                sb.insert(0, "-");
                idx -= k;
            }
            if (idx > -k) {
                sb.insert(0, entire.substring(0, idx + k));
            }
            else {
                sb.delete(0, 1);
            }
            return sb.toString();
        }
    }
}
