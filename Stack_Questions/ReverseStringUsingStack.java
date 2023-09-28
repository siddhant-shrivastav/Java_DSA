import java.util.Stack;

public class ReverseStringUsingStack {

    public static String reverse(String str){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            st.push(ch);
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
    public static void main(String [] args){
        String str = "Siddhant";
        System.out.println(reverse(str));
    }
}
