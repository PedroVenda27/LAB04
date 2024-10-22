import org.example.StringCaseChanger;
import org.example.StringDrink;
import org.example.StringInverter;
import org.example.StringReplacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformUndoTest {

    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        si.execute(drink);
        cc.execute(drink);
        sr.execute(drink);

        sr.undo(drink); // Reverter substituição
        assertEquals("dCbA-DcBa", drink.getText());

        cc.undo(drink); // Reverter mudança de maiúsculas/minúsculas
        assertEquals("DcBa-dCbA", drink.getText());

        si.undo(drink); // Reverter inversão
        assertEquals("AbCd-aBcD", drink.getText());
    }

}
