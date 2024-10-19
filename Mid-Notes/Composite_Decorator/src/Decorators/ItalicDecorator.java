package Decorators;

import Abstracts.DocumentDecorator;
import Behaviours.IDocumentElement;

public class ItalicDecorator extends DocumentDecorator {
    public ItalicDecorator(IDocumentElement element) {
        super(element);
    }

    @Override
    public void render() {
        System.out.print("_");
        super.render();
        System.out.print("_");
    }

    @Override
    public int getCharCount() {
        return super.getCharCount() + 2;
    }
}
