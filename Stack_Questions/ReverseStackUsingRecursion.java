import java.util.Stack;

public class ReverseStackUsingRecursion{
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int poped = st.pop();
        reverse(st);
        insertAtBottom(st,poped);
        
    }

    public static void insertAtBottom(Stack<Integer> st, int poped){
        if(st.isEmpty()){
            st.push(poped);
            return;
        }
        int top = st.pop();
        insertAtBottom(st,poped);
        st.push(top);
        return;

    }
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        reverse(st);

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}