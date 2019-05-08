package src;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-07 19:28
 * 描述：10. 正则表达式匹配
 *      给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *      '.' 匹配任意单个字符。
 *      '*' 匹配零个或多个前面的元素。
 **/
public class Question_10 {

    public boolean my_1(String s, String p) {
        if(p.indexOf(".") == -1 && p.indexOf("*") == -1){
            if(s.equals(p)) return true;
            else return false;
        }
        s.matches(p);
        return false;
    }

    /**
     * 递归法，p[j]字符与s[i]比较，
     *      1.如果p[j+1]!='*',直接与s[i]比较，如果匹配上了，两个游标都后移一位，否则返回false
     *      2.如果p[j+1]=='*'，两种情况
     *                        第一，匹配0个，只需要跳过p中的这两个字符，继续
     *                        第二，匹配多个，将s的游标往后移一位，继续
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_0(String s,String p){
        if(p.length() <=0) return s.length() <=0;
        boolean match = s.length() >0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //'*'
        if(p.length() >1 && p.charAt(1) == '*'){
            return isMatch_0(s,p.substring(2)) || (match && isMatch_0(s.substring(1),p));
        }
        else{
            return match && isMatch_0(s.substring(1),p.substring(1));
        }
    }

    /**
     * 递归法优化-->动态规划
     *
     * @param s
     * @param p
     * @return
     */
    String[][] memo;
    public boolean isMatch_0_1(String s,String p){
        memo = new String[s.length()+1][p.length()+1];
        return match(0,0,s,p);
    }
    public boolean match(int i,int j,String s,String p){
        if(memo[i][j] != null){
            return memo[i][j].equals("true");
        }
        boolean ans;
        if(j == p.length()){
            return i == s.length();
        }
        else{
            boolean curMatch = (i <s.length() && (s.charAt(i)==p.charAt(j)|| p.charAt(j)=='.'));
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                ans = match(i,j+2,s,p) || (curMatch && match(i+1,j,s,p));
            }
            else{
                ans = curMatch && match(i+1,j+1,s,p);
            }
        }
        memo[i][j] = ans+"";
        return ans;
    }

    /**
     * 评论区答案，动态规划算法
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen+1][pLen+1];
        memory[0][0] = true;
        for(int i = 0; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                if(p.charAt(j-1) == '*') {
                    memory[i][j] = memory[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                            p.charAt(j-2) == '.') && memory[i-1][j]);
                }else {
                    memory[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                            && memory[i-1][j-1];
                }
            }
        }
        return memory[sLen][pLen];
    }

    /**
     * 在上面方法的基础上，由于每次都只使用了memory表中相邻的两行，因此可以进一步降低代码的空间复杂度如下
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[2][pLen+1];
        memory[0][0] = true;
        int cur = 0, pre = 0;
        for(int i = 0; i <= sLen; i++) {
            cur = i % 2;
            pre = (i + 1) % 2;
            if(i > 1) {
                for(int j = 0; j <= pLen; j++) {
                    memory[cur][j] = false;
                }
            }
            for(int j = 1; j <= pLen; j++) {
                if(p.charAt(j-1) == '*') {

                    memory[cur][j] = memory[cur][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                            p.charAt(j-2) == '.') && memory[pre][j]);
                }else {
                    memory[cur][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                            && memory[pre][j-1];
                }
            }
        }
        return memory[cur][pLen];
    }
}
