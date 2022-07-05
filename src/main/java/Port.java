import java.util.*;

public class Port {
    private List<String> indexes;
    public Port() {
        indexes = new ArrayList<>();
    }
    public Port(List<String> indexes) {
        this.indexes = indexes;
    }
    public List<String> getIndexes() {
        return indexes;
    }
    public void setIndexes(List<String> indexes) {
        this.indexes = indexes;
    }
    public List<List<Integer>> convertIndexes(){
        List<List<Integer>> integers = new ArrayList<>();
        for(String s: indexes){
            integers.add(workWithString(s));
        }
        return integers;
    }
    public List<List<Integer>> getUniqueGroups(){
        List<List<Integer>> sourceArrays = convertIndexes();
        List<List<Integer>> resultArrays = generateGroups(sourceArrays);
        resultArrays.sort((x, y) -> {
            for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
                if (!Objects.equals(x.get(i), y.get(i))) {
                    return x.get(i) - y.get(i);
                }
            }
            return x.size() - y.size();
        });
        return resultArrays ;
    }
    private List<Integer> workWithString(String string){
        List<Integer> integers = new ArrayList<>();
        String[] strings = string.split(",");
        for(String item: strings){
            if(!item.contains("-")){
                integers.add(Integer.parseInt(item));
            }else{
                String[] array = item.split("-");
                int begin = Integer.parseInt(array[0]);
                int end = Integer.parseInt(array[1]);
                for(int k=begin;k<=end;k++){
                    integers.add(k);
                }
            }
        }
        return integers;
    }
    private List<List<Integer>> generateGroups(List<List<Integer>> sets) {
        List<List<Integer>> result = new ArrayList<>();
        int solutions = 1;
        for(int i = 0; i < sets.size(); solutions *= sets.get(i).size(), i++);
        for(int i = 0; i < solutions; i++) {
            int j = 1;
            List<Integer> tempList = new ArrayList<>();
            for(List<Integer> set : sets) {
                tempList.add(set.get((i/j)%set.size()));
                j *= set.size();
            }
            result.add(tempList);
        }
        return result;
    }
}
