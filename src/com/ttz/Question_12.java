package com.ttz;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-06 11:21
 * 描述：12.整数转罗马数字
 **/
public class Question_12 {

    /**
     * 将数字按位提取出来，如58，提取出8，50，依次转化，先判断特殊的（4，9...），再判断普通的（1，5...）
     * @param num
     * @return
     */
    public String my_1(int num) {
        if (num <= 0) {
            return "0";
        }
        int i = 1;
        StringBuilder str = new StringBuilder();
        List<String> list = new ArrayList<>();
        //将数字按位提取出来，如58，提取出8，50，依次转化
        while (num > 0) {
            if(!toDoubleRoman((num % 10) * i).equals("")){
                list.add(toDoubleRoman((num % 10) * i));
            }else{
                list.add(toSingleRoman((num % 10) * i));
            }
            num = num / 10;
            i *= 10;
        }
        for (int j = list.size() - 1; j >=0; j--) {
            if (!list.get(j).equals("")) {
                str.append(list.get(j));
            }
        }
        return str.toString();
    }

    public String toDoubleRoman(int num) {
        if (num == 4) {
            return "IV";
        }
        if (num == 9) {
            return "IX";
        }
        if (num == 40) {
            return "XL";
        }
        if (num == 90) {
            return "XC";
        }
        if (num == 400) {
            return "CD";
        }
        if (num == 900) {
            return "CM";
        }
        return "";
    }

    public String toSingleRoman(int num) {
        StringBuilder str = new StringBuilder();
        while (num / 1000 != 0) {
            str.append("M");
            num = num - 1000;
        }
        while (num / 500 != 0) {
            str.append("D");
            num = num - 500;
        }
        while (num / 100 != 0) {
            str.append("C");
            num = num - 100;
        }
        while (num / 50 != 0) {
            str.append("L");
            num = num - 50;
        }
        while (num / 10 != 0) {
            str.append("X");
            num = num - 10;
        }
        while (num / 5 != 0) {
            str.append("V");
            num = num - 5;
        }
        while (num / 1 != 0) {
            str.append("I");
            num = num - 1;

        }
        return str.toString();
    }

    public static void main(String[] args) {
        Question_12 test = new Question_12();
        System.out.println("58-->"+test.my_1(58));
    }


}
