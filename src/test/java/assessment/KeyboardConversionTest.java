package assessment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import static assessment.KeyboardConversion.characterList;

public class KeyboardConversionTest {

    @Test
    public void testCharacterList(){
        List<Character> result = KeyboardConversion.characterList();
        assertEquals(result.get(0),'1');
        assertEquals(result.get(10),'q');
        assertEquals(result.get(39),'?');
    }

    @Test
    public void testFlipHorizontally(){
        List<Character> before = KeyboardConversion.characterList();
        List<Character> after = KeyboardConversion.flipHorizontally(before);

        assertEquals(after.get(11), 'o');
        assertEquals(after.get(24), 'h');
        assertEquals(after.get(34), 'n');
    }

    @Test
    public void testFlipVertically(){
        List<Character> before = KeyboardConversion.characterList();
        List<Character> after = KeyboardConversion.flipVertically(before);

        assertEquals(after.get(11), 's');
        assertEquals(after.get(24), 't');
        assertEquals(after.get(34), '5');
    }
}

