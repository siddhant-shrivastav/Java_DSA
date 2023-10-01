import java.util.*;

public class RedundantBracket{
    public static boolean checkRedundant(String str){
        Stack<Character> st = new Stack<>();
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            if( ch == '('  || ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                st.push(ch);
            }else{
                if(ch == ')'){
                    int count = 0;
                    while(st.peek() != '('){
                        st.pop();
                        count++;
                    }
                    st.pop();
            
                    if(count==0){
                        return true;
                    }
                }
                
            }
        }
        return false;
    }

    public static void main(String[] args){
        String str = "(a+c*b)+(c))";
        System.out.println(checkRedundant(str));
    }
}