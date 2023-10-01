import java.util.Stack;

public class SortStack{

    public static void sort(Stack<Integer> st){
        // base case
        if(st.size()==1){
            return;
        }
        int poped = st.pop();
        // recursive call
        sort(st);
        solve(st,poped);
    }

    public static void solve(Stack<Integer> st, int poped){
        if(st.isEmpty() || st.peek() < poped){
            st.push(poped);
            return;
        }

        int top = st.pop();
        solve(st, poped);
        st.push(top);
        return;
    }
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(10);
        st.push(6);
        st.push(4);
        st.push(7);

        sort(st);

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}