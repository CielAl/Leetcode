/**
* Problem Link: https://leetcode.com/problems/find-anagram-mappings/description/
*
* @author Ciel
*/
import java.util.Arrays;
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
        int[] result = new int[len];
        int[] index = new int[len];
        int loopIndex = 0;
        for(;loopIndex<len;loopIndex++){
		
			//Previous use 100, but use 128 so shift can be applied instead of division
            index[loopIndex] = B[loopIndex]*128+loopIndex; 
        }
        Arrays.sort(index);
        int min,max,mid,value;
        for(loopIndex=0 ;loopIndex<len;loopIndex++){
            //find 100*A in index reversed
             min = 0;
             max = len-1;
            while(min<=max){
                 
                mid = min+ ((max-min)>>1);
                
                value = reverseVal(index[mid]);
                if(value==A[loopIndex]){
                    result[loopIndex] = reversePos(index[mid]);
                    break;
                }else if (value<A[loopIndex]){
                    min = mid+1;
                }else if(value >A[loopIndex]){
                    max = mid-1;
                }
            }
            
        }


        return result;
    }
    //128*value+pos = composition and pos is [0~99]
    public int reverseVal(int composition){
            return composition>>7;
    }
     public int reversePos(int composition){
            return composition - ((composition>>7)<<7);
    }
   
}	