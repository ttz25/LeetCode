package com.ttz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-15 19:41
 * 描述：17. 电话号码的字母组合
 **/
public class Question_17 {

    /**
     * 我的解答：使用遍历的方式将所有数字对应的字母串联起来，最后将符合条件的字符串返回
     * @param digits
     * @return
     */
    public List<String> my_1(String digits) {

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        //先将第一个数字对应的字符放入
        if(digits.length()>=1){
            String str = map.get(digits.charAt(0));
            for(int j = 0;j<str.length();j++){
                list.add(str.charAt(j)+"");
            }
        }
        //遍历所有的数字
        for(int i = 1;i<digits.length();i++){
            List<String> temp = new ArrayList<>();
            //数字对应的字母串
            String str = map.get(digits.charAt(i));
            //遍历字母串
            for(int j = 0;j<str.length();j++){
                for(String s : list){
                    temp.add(s+str.charAt(j));
                }
            }
            list.addAll(temp);
        }
        //剔除不符合的字符串
        for(String s : list) {
            if (s.length() == digits.length()) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question_17 test = new Question_17();
        System.out.println(test.my_1(""));
    }

}
