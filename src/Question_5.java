package src;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者： 周婷婷
 * 日期： 2019-03-28 10:48
 * 描述：5.给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 **/
public class Question_5 {

    /**
     * 尝试1：超时
     * 我的解答：遍历每个字符，从最后字符开始判断是否相等，
     * @param s
     * @return
     */
    public String my_1(String s) {
        if(s.length()==0 || s==null){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for(int i = 0;i<s.length()-1;i++){
            for(int j = s.length()-1;j>i;j--){
                if(s.charAt(i) != s.charAt(j)){
                    continue;
                }
               if(judge(s,i,j)){
                   if((j-i+1)> res.length()){
                       res.delete(0, res.length());
                       res.append(s.substring(i,j+1));
                   }
               }
            }


        }
        return res.toString();
    }

    //判断是否是回文字符串
    public boolean judge(String s,int start,int end){
        for(int i = start+1,j = end-1;i<=end && i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    /**
     * 尝试2：解答错误
     * @param s
     * @return
     */
    public String my_2(String s) {
        if(s.length()==0 || s==null){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for (int i = 0;i<s.length();i++){
           if(map.containsKey(s.charAt(i))) {
               if (judge(s, Math.min(map.get(s.charAt(i)), i), Math.max(map.get(s.charAt(i)), i))) {
                   if(Math.abs(map.get(s.charAt(i))-i)+1> res.length()) {
                       res.delete(0, res.length());
                       res.append(s.substring(Math.min(map.get(s.charAt(i)), i), Math.max(map.get(s.charAt(i)), i) + 1));
                   }
               }
           }
           map.put(s.charAt(i),i);

        }

        return res.toString();
    }

    /**
     * 官方解答1：先将字符串反转s2，s与s2的最长公共字串就是
     *          解答失败
     * @param s
     * @return
     */
    public String answer_1(String s) {
        StringBuilder s2 = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = s.length()-1;i>-1;i--){
            s2.append(s.charAt(i));
        }
        for(int i = 0;i<s.length();i++){
            for(int j = 0,n = i;j<s2.length() && n<s2.length();j++) {
                char c1 = s.charAt(n);
                char c2 = s2.charAt(j);
                if (n == i && s.charAt(n) != s2.charAt(j)) {
                    continue;
                }
                if (n != i && s.charAt(n) != s2.charAt(j)) {
                    j=n-i;
                    n=i;

                    continue;
                }
                if(s.charAt(n) == s2.charAt(j)){
                    n++;
                }
                if(n != i ) {
                    if ((n - i + 1) > res.length()) {
                        res.delete(0, res.length());
                        res.append(s.substring(i, n));
                    }
                }

            }
        }
        return res.toString();
    }

    /**
     * 官方解答2：中心扩展算法
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1 个这样的中心。
     * @param s
     * @return
     */
    public String answer_2(String s) {
        if(s.length() <1 || s == null) return "";
        int start = 0,end = 0;
        for(int i = 0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s,int left,int right){
        int L = left,R = right;
        while(L >=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }



    public static void main(String[] args) {
        Question_5 test = new Question_5();
        System.out.println("result:"+test.answer_2("aaabaaaa"));



    }

}