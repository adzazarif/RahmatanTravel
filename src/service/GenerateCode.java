
package service;

import java.util.Random;

public class GenerateCode {
    private String text;

    public GenerateCode() {
        this.text = generateText();
    }

    private String generateText() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    

    public String getText() {
        return this.text;
    }
}
