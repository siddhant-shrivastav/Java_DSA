import java.util.Stack;

public class DeleteMiddleElementFromStack {

    public static void deleteMiddle(Stack<Integer> st, int n){
        if(st.size() == (n/2)+1){
            st.pop();
            return;
        }
        int top = st.pop();
        deleteMiddle(st, n);
        st.push(top);
    }

    // Another method
    public static void deleteMiddle2(Stack<Integer> st, int n){
        Stack<Integer> temp = new Stack<>();
        int count = 0;
        while(count != n/2){
            int poped = st.pop();
            count++;
            temp.push(poped);
        }
        st.pop();

        while(!temp.isEmpty()){
            int top = temp.pop();
            st.push(top);
        }
    }


    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        int n = 5;

        deleteMiddle(st,n);
        // deleteMiddle2(st, n);
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
        
    }
}
