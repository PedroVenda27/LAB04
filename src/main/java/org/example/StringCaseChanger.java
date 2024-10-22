package org.example;

public class StringCaseChanger implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        StringBuilder sb = new StringBuilder();
        String text = drink.getText();

        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        drink.setText(sb.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}


