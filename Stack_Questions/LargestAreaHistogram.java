import java.util.Arrays;
import java.util.Stack;

public class LargestAreaHistogram{

    public static int largestArea(int[] height){
        int n = height.length;
        // Find next smaller element's index
        int[] next = nextSmaller(height);
        // Find prev smalller element's index
        int[] prev = prevSmaller(height);
        int max = -1;
        for(int i =0; i<height.length; i++){
            int length = height[i];
            if(next[i] == -1){
                next[i] = n;
            }
            int width = next[i] - prev[i] -1;
            int area = length * width;
            if(area>max){
                max = area;
            }
        }
        return max;

    }


    // Next Smaller element's index.

    public static int[] nextSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] temp = new int[arr.length];
        for(int i =arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!st.isEmpty() && curr <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                temp[i] = -1;
            }else{
                temp[i] = st.peek();
            }
            st.push(i);
        }
        return temp;
    }

    // Previous Smaller element's index
    public static int[] prevSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= curr){
                st.pop();
            }
            if(st.isEmpty()){
                temp[i] = -1;
            }else {
                temp[i] = st.peek();
            }
            st.push(i);
        }
        return temp;
    }

    public static void main(String[] args){
        int[] height = {2,1,5,6,2,3};
        System.out.println(Arrays.toString(nextSmaller(height)));
        System.out.println(Arrays.toString(prevSmaller(height)));
        System.out.println(largestArea(height));
    }
}