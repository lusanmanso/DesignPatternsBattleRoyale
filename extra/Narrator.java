package extra;

import java.util.ArrayList;
import java.util.List;

public class Narrator {
    private static final int DELAY = 50; // Milisegundos entre cada letra
    private List<String> textsToNarrate;
    private int currentIndex;

    public Narrator() {
        this.textsToNarrate = new ArrayList<>();
        this.currentIndex = 0;
    }

    public void addText(String text) {
        textsToNarrate.add(text);
    }

    public void startNarration() {
        if (currentIndex < textsToNarrate.size()) {
            String text = textsToNarrate.get(currentIndex);
            narrate(text);
            currentIndex++;
        }
    }

    private void narrate(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
