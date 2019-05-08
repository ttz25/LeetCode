package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-17 10:10
 * 描述：22. 括号生成
 **/
public class Question_22 {

    /**
     *我的思路：使用字符串替换的方式，失败
     * @param n
     * @return
     */
    public List<String> my_1(int n) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        list.add("()");

        for(int i = 0;i<n;i++){
            List<String> temp = new ArrayList<>();
            for(String str : list){
                temp.add(str.replace("()","(())"));
                temp.add(str.replace("()","()()"));
            }
            list.addAll(temp);
        }

        for(String str : list){
            if(!set.contains(str) && str.length() == n*2) set.add(str);
        }

        for(String str : set){
            res.add(str);
        }
        return res;
    }

    /**
     * 官方思路：递归添加'(',')'，添加前判断字符串是否符合要求的长度
     * @param n
     * @return
     */
    public List<String> answer_1(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans,"",0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans,String cur,int open,int close,int max){
        //添加前判断字符串是否符合要求的长度
        if(cur.length() == max*2){
            ans.add(cur);
            return;
        }
        if(open<max){
            backtrack(ans,cur+"(",open+1,close,max);
        }
        if(close<open){  //一定是先有左括号，再有右括号
            backtrack(ans,cur+")",open,close+1,max);
        }
    }

    public static void main(String[] args) {
        Question_22 test = new Question_22();
        System.out.println(test.answer_1(3));
    }
}
