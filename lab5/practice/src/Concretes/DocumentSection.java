package Concretes;

import java.util.ArrayList;
import java.util.List;

import Behaviours.IDocumentElement;

public class DocumentSection implements IDocumentElement {
    private List<IDocumentElement> elements = new ArrayList<>();
    private String sectionName;

    public DocumentSection(String sectionName) {
        this.sectionName = sectionName;
    }

    public void addElement(IDocumentElement element) {
        elements.add(element);
    }

    public void removeElement(IDocumentElement element) {
        elements.remove(element);
    }

    @Override
    public void render() {
        System.out.println("\n=== " + sectionName + " Start ===");
        for (IDocumentElement element : elements) {
            element.render();
        }
        System.out.println("\n=== " + sectionName + " End ===");
    }

    @Override
    public int getCharCount() {
        return elements.stream()
                .mapToInt(
                        IDocumentElement::getCharCount)
                .sum();
    }
}
