package Abstracts;

import Behaviours.IDocumentElement;

public class DocumentDecorator implements IDocumentElement {
    protected IDocumentElement element;

    public DocumentDecorator(IDocumentElement element) {
        this.element = element;
    }

    @Override
    public void render() {
        element.render();
    }

    @Override
    public int getCharCount() {
        return element.getCharCount();
    }
}
