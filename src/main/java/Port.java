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
        if(!string.contains(",")&&!string.contains("-")){
            integers.add(Integer.parseInt(string));
        }else{
            boolean isSequence=false;
            StringBuilder result=new StringBuilder();
            int i=0;
            while(i<string.length()){
                while(string.charAt(i)!=','&&string.charAt(i)!='-'){
                    result.append(string.charAt(i));
                    if(i!=string.length()-1){
                        i++;
                    }else{
                        i++;
                        break;
                    }
                }
                if(isSequence){
                    int end=Integer.parseInt(result.toString());
                    for(int k=integers.get(integers.size()-1)+1;k<=end;k++){
                        integers.add(k);
                    }
                    isSequence=false;
                    result=new StringBuilder();
                }else if(string.charAt(i) =='-') {
                    integers.add(Integer.parseInt(result.toString()));
                    result = new StringBuilder();
                    isSequence = true;
                    i++;
                } else if (string.charAt(i) == ','){
                    if (!result.isEmpty()) {
                        integers.add(Integer.parseInt(result.toString()));
                        result=new StringBuilder();
                    }
                    i++;
                }
            }
            if(!result.isEmpty()){
                integers.add(Integer.parseInt(result.toString()));
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
