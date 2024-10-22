package org.example;

public class StringReplacer implements StringTransformer {
    private char target;
    private char replacement;

    public StringReplacer(char target, char replacement) {
        this.target = target;
        this.replacement = replacement;
    }

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        String replacedText = text.replace(target, replacement);
        drink.setText(replacedText);
    }

    @Override
    public void undo(StringDrink drink) {
        String text = drink.getText();
        String undoneText = text.replace(replacement, target);
        drink.setText(undoneText);
    }
}

