package Concretes;

import Behaviours.IDocumentElement;

public class TextElement implements IDocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.print(text);
    }

    @Override
    public int getCharCount() {
        return text.length();
    }
}
