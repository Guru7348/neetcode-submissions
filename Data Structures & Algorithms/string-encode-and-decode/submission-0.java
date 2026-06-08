class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        
        while (index < str.length()) {
            // Find the position of '#'
            int delimiterIndex = str.indexOf("#", index);
            int length = Integer.parseInt(str.substring(index, delimiterIndex));

            // Extract the actual string
            res.add(str.substring(delimiterIndex + 1, delimiterIndex + 1 + length));

            // Move index to the start of the next length-prefixed string
            index = delimiterIndex + 1 + length;
        }
        
        return res;
    }
}