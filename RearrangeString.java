public class RearrangeString {
    public String restoreString(String s, int[] indices) {
        if (indices.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charSeq = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            charSeq[indices[i]] = s.charAt(i);
        }
        return sb.append(charSeq).toString();
    }
}