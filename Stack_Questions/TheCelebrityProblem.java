import java.util.Stack;

public class TheCelebrityProblem {


    public static int celebrityBruteForce(int arr[][], int n)
    {
    	for(int i =0; i<n; i++){
    	    boolean celebrity = true;
    	    for(int j =0; j<n; j++){
    	        if(arr[i][j] == 1){
    	            celebrity = false;
    	            break;
    	        }
    	    }
    	    boolean confirmationOfCelebrity = true;
    	    for(int j = 0; j<n; j++){
    	        if(i!=j && arr[j][i] == 0){
    	            confirmationOfCelebrity = false;
    	        }
    	    }
    	    
    	    if(celebrity == true && confirmationOfCelebrity == true){
    	        return i;
    	    }
    	}
    	return -1;
    }

    // optimized Approach TC -> O(n)

    public static int celebrity(int arr[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	// Insert all elements in stack
    	for(int i = 0; i<n; i++){
    	    st.push(i);
    	}
    	
    	while(st.size()>1){
    	    int a = st.pop();
    	    int b = st.pop();
    	    
    	    if(knows(arr,a,b)){
    	        st.push(b);
    	    }else{
    	        st.push(a);
    	    }
    	}
    	
    	int celebrity = st.peek();
    	boolean confirmation = true;
    	for(int i = 0; i<n; i++){
    	    if(arr[celebrity][i] == 1){
    	        confirmation = false;
    	        break;
    	    }
    	}
    	
    	boolean peopleKnows = true;
    	for(int i =0; i<n; i++){
    	    if(celebrity != i && arr[i][celebrity] == 0){
    	        peopleKnows = false;
    	    }
    	}
    	
    	if(confirmation == true && peopleKnows == true){
    	    return celebrity;
    	}else{
    	    return -1;
    	}
    	
    }
    
    public static boolean knows(int[][] arr,int a, int b){
        if(arr[a][b] == 1){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        int arr[][] = {
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };

        int n = arr.length;
        System.out.println(celebrity(arr, n));
        System.out.println(celebrityBruteForce(arr, n));
    }
    
}
