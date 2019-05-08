package src;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-03 17:20
 * 描述：13.罗马数字转整数
 **/
public class Question_13 {

    public int my_2(String s){
        s = s.replace("IV",",4")
              .replace("IX",",9")
              .replace("XL",",40")
                .replace("XC",",90")
                .replace("CD",",400")
                .replace("CM",",900");

        s = s.replace("I",",1")
                .replace("V",",5")
                .replace("X",",10")
                .replace("L",",50")
                .replace("C",",100")
                .replace("D",",500")
                .replace("M",",1000");

        String[] arr = s.substring(1,s.length()).split(",");
        int res = 0;
        for(String str : arr){
            res += Integer.parseInt(str);
        }
        return res;

    }

    public int my_1(String s) {
        int res = 0,temp=0;

        for(int i = 0;i<s.length();i++){
            if(i+2<s.length()) {
                temp = doubleRoman(s.substring(i, i + 2));
            }
            if(temp != 0){
                res += temp;
                i++;
            }
            else{
                res += singleRoman(s.charAt(i));
            }
            temp = 0;
        }
        return res;
    }

    public int doubleRoman(String s){
        if(s.indexOf("IV") != -1){
            return  4;
        }
        if(s.indexOf("IX") != -1){
            return 9;
        }
        if(s.indexOf("XL") != -1){
            return 40;
        }
        if(s.indexOf("XC") != -1){
            return 90;
        }
        if(s.indexOf("CD") != -1){
            return 400;
        }
        if(s.indexOf("CM") != -1){
            return 900;
        }
        return 0;
    }

    public int singleRoman(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;

        }
    }

    public static void main(String[] args) {
        Question_13 a = new Question_13();
        System.out.println(a.my_2("MCMXCIV"));
    }
}