import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 作者： 周婷婷
 * 日期： 2021-05-20 23:00
 * 描述： 前K个高频单词
 **/
public class Question_692 {

    public static void main(String[] args) {
        Question_692 question_692 = new Question_692();

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = question_692.topKFrequent(words, k);
        for (String str : strings){
            System.out.println(str);
        }
    }

    /**
     * 我的 ： 哈希表+排序
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {

        Map<String ,Integer> map = new TreeMap<>();
        List<String> list = new ArrayList<>(k);

        for (String str : words) {
            map.merge(str ,1, Integer::sum);
        }

        for (Map.Entry<String, Integer> mapping :map.entrySet()) {
            list.add(mapping.getKey());

        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) {
                    return o1.compareTo(o2);
                }
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        return list.subList(0,k);
    }

    /**
     *  stream 流
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent2(String[] words, int k) {

        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else{
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    /**
     *  优先队列
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent3(String[] words, int k) {
        Map<String ,Integer> map = new TreeMap<>();
        List<String> list = new ArrayList<>(k);

        for (String str : words) {
            map.merge(str ,1, Integer::sum);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()==o2.getValue()? o2.getKey().compareTo(o1.getKey()) : o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size()>k){
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            list.add(pq.poll().getKey());
        }
        Collections.reverse(list);

        return list;
    }

}