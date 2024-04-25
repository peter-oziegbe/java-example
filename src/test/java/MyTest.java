import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyTest {

    @Test
    void testAddition(){
        Mathematics mathematics = new Mathematics();
        var result = mathematics.add(5, 10);
        Assertions.assertEquals(result, 15);
    }

}
