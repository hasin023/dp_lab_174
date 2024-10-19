package Decorators;

import Abstracts.DocumentDecorator;
import Behaviours.IDocumentElement;

public class HighlightDecorator extends DocumentDecorator {
    public HighlightDecorator(IDocumentElement element) {
        super(element);
    }

    @Override
    public void render() {
        System.out.print("[[");
        super.render();
        System.out.print("]]");
    }

    @Override
    public int getCharCount() {
        return super.getCharCount() + 4;
    }
}
