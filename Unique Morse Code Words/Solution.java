/**
* Problem Link: //https://leetcode.com/problems/unique-morse-code-words/description/
*
* @author Ciel


*/
class Solution {
     public static final String[] codeBook =  {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        //Overhead here is still the hash. (But it makes the code simpler).
        HashSet<String> record= new HashSet<String>();
        int result = 0;
        int len = words.length;
        StringBuilder code = new StringBuilder(3);
        for(int i =0;i<len;i++){
              getMorse(words[i],code);
              record.add(code.toString());
                          
        }
        //record contains unique representations.
        return record.size();
    }
    // By reference - reuse the object
    public void getMorse(String word, StringBuilder code){
        int len = word.length();
        //Omit the check null stage
        
        //Rounded average length of the codex are ~3 -> size = 3*length
      
            //Clear the old record
            code.delete(0,code.length());           
            //Ensure the capacity - if it is large enough then there will be no reallocation.
            code.ensureCapacity(len+(len<<1));
        
       // word = word.toLowerCase();
        for(int i = 0;i<len;i++){
            /*
                Filter the input. Since the input here is guaranteed, 
                skip this step.
            */
            code.append(codeBook[word.charAt(i)-97]);
        }
    }    
    //Original version: for test only.
    public StringBuilder getMorse(String word){
        int len = word.length();
        StringBuilder code = new StringBuilder();
        word = word.toLowerCase();
        for(int i = 0;i<len;i++){
            /*
                Filter the input. Since the input here is guaranteed, 
                skip this step.
            */
            code.append(codeBook[word.charAt(i)-97]);
        }
        return code;
    }
    
}