import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PortTest {
    @Test
    public void firstMethodRightInput(){
        Port port = new Port(new ArrayList<>());
        port.getIndexes().add("1,3-5");
        port.getIndexes().add("2");
        port.getIndexes().add("3-4");
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<>(Arrays.asList(1,3,4,5)));
        expectedResult.add(new ArrayList<>(Arrays.asList(2)));
        expectedResult.add(new ArrayList<>(Arrays.asList(3,4)));
        Assert.assertEquals(expectedResult,port.convertIndexes());
    }
    @Test
    public void secondMethodWork(){
        Port port = new Port(new ArrayList<>());
        port.getIndexes().add("1,3-5");
        port.getIndexes().add("2");
        port.getIndexes().add("3-4");
        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<>(Arrays.asList(1,2,3)));
        expectedResult.add(new ArrayList<>(Arrays.asList(1,2,4)));
        expectedResult.add(new ArrayList<>(Arrays.asList(3,2,3)));
        expectedResult.add(new ArrayList<>(Arrays.asList(3,2,4)));
        expectedResult.add(new ArrayList<>(Arrays.asList(4,2,3)));
        expectedResult.add(new ArrayList<>(Arrays.asList(4,2,4)));
        expectedResult.add(new ArrayList<>(Arrays.asList(5,2,3)));
        expectedResult.add(new ArrayList<>(Arrays.asList(5,2,4)));
        Assert.assertEquals(expectedResult,port.getUniqueGroups());
    }
}
