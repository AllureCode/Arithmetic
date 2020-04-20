package java_dataStructure.TenCommonAlgorithms;

import java.util.*;

/**
 * 贪心算法
 */
public class greedyAlgorithm {
    public static void main(String[] args) {
        //创建一个HashMap保存广播电台
        Map<String, HashSet<String>> broadcast = new HashMap<>();
        //创建一个HashSet保存各个城市
        HashSet<String> city1 = new HashSet<>();
        city1.add("北京");
        city1.add("上海");
        city1.add("天津");
        HashSet<String> city2 = new HashSet<>();
        city2.add("广州");
        city2.add("北京");
        city2.add("深圳");
        HashSet<String> city3 = new HashSet<>();
        city3.add("成都");
        city3.add("上海");
        city3.add("杭州");
        HashSet<String> city4 = new HashSet<>();
        city4.add("上海");
        city4.add("天津");
        HashSet<String> city5 = new HashSet<>();
        city5.add("杭州");
        city5.add("大连");
        broadcast.put("K1", city1);
        broadcast.put("K2", city2);
        broadcast.put("K3", city3);
        broadcast.put("K4", city4);
        broadcast.put("K5", city5);
        System.out.println(broadcast);
        //创建一个hashSet存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("杭州");
        allAreas.add("深圳");
        allAreas.add("大连");
        allAreas.add("成都");
        //创建一个list存放选择的电台
        List<String> select = new ArrayList<>();
        //创建一个临时的hashSet
        HashSet<String> temp = new HashSet<>();
        //遍历allAreas
        while(allAreas.size()!=0){
            //maxKey用于记录集合中被覆盖元素最大的那个K值
            String maxKey=null;
            for (String key:broadcast.keySet()){
                temp.clear();
                HashSet<String> area = broadcast.get(key);
                temp.addAll(area);
                //返回当前Key对应的城市在所有城市中的共同城市
                temp.retainAll(allAreas);
                if (temp.size()>0 &&(maxKey==null || temp.size()>broadcast.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if(maxKey!=null){
                select.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
            }
        }
        System.out.println(select);
    }
}
