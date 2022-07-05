import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PortTest {
    @Test
    public void firstMethodRightInputShouldBeCorrect(){
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
    public void secondMethodRightInputShouldBeCorrect(){
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
    @Test(expected = NumberFormatException.class)
    public void wrongInputSymbolShouldThrowException(){
        Port port = new Port(new ArrayList<>());
        port.getIndexes().add("1&-2");
        port.getUniqueGroups();
    }
    @Test(expected = NumberFormatException.class)
    public void wrongInputLetterShouldThrowException(){
        Port port = new Port(new ArrayList<>());
        port.getIndexes().add("1a-2");
        port.getUniqueGroups();
    }
}
