import java.util.Stack;

public class InsertElementAtBottomOfStack {

    public static void insertAtBottom(Stack<Integer> st,int n){
        if(st.isEmpty()){
            st.push(n);
            return;
        }
        int poped = st.pop();
        insertAtBottom(st,n);
        st.push(poped);
        return;
    }
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        int n = 10;
        insertAtBottom(st,n);

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
    
}
