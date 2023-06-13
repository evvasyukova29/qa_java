import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class TestForLion
{
    String sex;

    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setUp() throws Exception
    {
        feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittens()
    {
        int expected = 1;
        Assert.assertEquals("У льва один котенок", expected, lion.getKittens());
    }


    @Test
    public void getFood() throws Exception
    {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("У льва диета хищника", expected, lion.getFood());
    }
    @Test(expected = Exception.class)
    public void lionExceptionTest() throws Exception
    {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }
}
