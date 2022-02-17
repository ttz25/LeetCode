package com.ttz;

import java.util.*;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-14 22:55
 * 描述：20. 有效的括号
 **/
public class Question_20 {

    /**
     * 我的尝试：失败
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length() ==0) return true;
        if(s.length()%2 != 0) return false;
        boolean flag ;
        Set<Integer> set  = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(i)) continue;
            flag = false;
            int j = s.length()-1;
            while(j>i){
                if((j-i)%2 !=1) {
                    j--;
                    continue;
                }
                if((s.charAt(i) == '(' && s.charAt(j)==')') || (s.charAt(i) == '{' && s.charAt(j)=='}')
                        || (s.charAt(i) == '[' && s.charAt(j)==']')){
                    set.add(j);
                    flag = true;

                    break;
                }
                j --;
            }
            if(!flag){
                return false;
            }
        }
        return  true;
    }

    /**
     * 我的尝试：失败
     * @param s
     * @return
     */
    public boolean isValid_1(String s) {
        if(s.length() ==0) return true;
        if(s.length()%2 != 0) return false;
        int j;
        boolean flag ;
        for(int i=0;i<s.length();i++){
            flag = false;
            j = s.length()-1-i;
            while(j>0) {
                if ((s.charAt(i) == '(' && s.charAt(j) == ')') || (s.charAt(i) == '{' && s.charAt(j) == '}')
                        || (s.charAt(i) == '[' && s.charAt(j) == ']')) {
                    flag = true;
                    if (j - i == 1) {
                        i++;
                    }
                    break;
                } else {
                    j -= 2;
                }
            }
            if(!flag){
                return false;
            }
        }
        return  true;
    }

    /**
     * 评论区解答：直接使用字符串替换
     * @param s
     * @return
     */
    public boolean isValid_2(String s) {
        while(s.indexOf("()") !=-1 || s.indexOf("[]") !=-1 || s.indexOf("{}") !=-1){
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
        }
        return s.equals("");
    }

    /**
     * 官方解答，自己实现，使用栈,遇到左括号就push进栈，遇上右括号就判断stack的顶元素是否匹配，
     * @param s
     * @return
     */
    public boolean isValid_3(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){

                char top = stack.empty()? '#':stack.pop();

                if(top != map.get(s.charAt(i))){
                    return false;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();

    }

    /**
     * 以下是官方解答
     */
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Question_20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid_answer(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
    /***************************************************************************/

    public static void main(String[] args) {
        Question_20 test = new Question_20();
        System.out.println(test.isValid_2("[({(())}[()])]"));
    }
}