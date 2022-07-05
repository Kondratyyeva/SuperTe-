import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {
    private List<Integer> workWithString(String string){
        List<Integer> integers = new ArrayList<>();
        boolean isSequence=false;
        StringBuilder result=new StringBuilder();
        int i=0;
        int length = string.length();
        while(i<length-1){
            while(string.charAt(i)!=','&&string.charAt(i)!='-'){
                result.append(string.charAt(i));
                if(i!=length-1){
                    i++;
                }else{
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
        return integers;
    }
    public List<List<Integer>> convertStringsToNumbers(List<String> strings){
        List<List<Integer>> integers = new ArrayList<>();
        for(String s: strings){
            integers.add(workWithString(s));
        }
        return integers;
    }
    public List<List<Integer>> getUniqueGroups(List<List<Integer>> array){
        List<List<Integer>> resultList = new ArrayList<>();
        for (List<Integer> arrayItem: array){
            Collections.sort(arrayItem);
        }
        

    }
}
