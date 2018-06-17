/**
* Problem Link: https://leetcode.com/problems/hamming-distance/description/
*
* @author Ciel


*/
class Solution {
    public int hammingDistance(int x, int y) {
        //Bitwise  x^y
        int countBits = x^y;
        int result = 0;
        while(countBits>0){
            result+= countBits & 1; 
            countBits  = countBits >>1;
        }
        return result;
    }
}