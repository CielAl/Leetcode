/**
* Problem Link: https://leetcode.com/problems/flipping-an-image/description/
*
* @author Ciel


*/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        // binary data -> invert by xor 1
        int isOdd = len - ((len>>1)<<1);
        int j;
        
        for(int i =0; i<len; i++){
            for(j = 0; j<(len>>1); j++){
                //Swap
                A[i][j] += A[i][len-j-1] ^ 1;
                A[i][len-j-1] = (A[i][j]- (A[i][len-j-1] ^ 1))^1;
                A[i][j] -= A[i][len-j-1]^1; 
            }
            //Middle Point -> ^0 idendical map. ^1 invert . Even ->isodd 0
            // j here is len/2
            A[i][j] ^= isOdd; 
        }
        return A;
    }
}