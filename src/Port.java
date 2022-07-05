import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<String> indexes;
    public List<List<Integer>> convertIndexes(){
        return new Parser().convertStringsToNumbers(indexes);
    }
    public List<List<Integer>> getUniqueGroups(List<List<Integer>> array){
        return new Parser().getUniqueGroups(convertIndexes());
    }
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
}
