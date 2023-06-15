import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class TestForAnimal
{
    private final String animalKind;
    private final List<String> expected;

    public TestForAnimal(String family, List<String> expected) {
        this.animalKind = family;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getFamilies()
    {
        return new Object[][]
                {
                    {"Травоядное", List.of("Трава", "Различные растения")},
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                };
    }

    @Test
    public void getFood() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals("Диета соответствует заявленной", expected, animal.getFood(animalKind));
    }
}
