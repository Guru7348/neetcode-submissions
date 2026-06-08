class Solution {
    public boolean isAnagram(String s, String t) {
        int i=0;
        Map<Character,Integer> anagram = new HashMap<>();
        for(i=0;i<s.length();i++){
            anagram.put(s.charAt(i),anagram.getOrDefault(s.charAt(i),0)+1);
        }
        for(i=0;i<t.length();i++){
            if(!anagram.containsKey(t.charAt(i))){
                return false;
            }
                anagram.put(t.charAt(i),anagram.get(t.charAt(i))-1);
                if(anagram.get(t.charAt(i))==0){
                    anagram.remove(t.charAt(i));
                }
            
            
        }
        return anagram.isEmpty();
    }
}
