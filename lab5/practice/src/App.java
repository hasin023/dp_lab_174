import Behaviours.IDocumentElement;
import Concretes.DocumentSection;
import Concretes.TextElement;
import Decorators.BoldDecorator;
import Decorators.HighlightDecorator;
import Decorators.ItalicDecorator;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a document structure
        DocumentSection document = new DocumentSection("Main Document");

        // Create a subsection
        DocumentSection section1 = new DocumentSection("Introduction");

        // Create and decorate some text elements
        IDocumentElement title = new BoldDecorator(
                new TextElement("Document Title"));

        IDocumentElement highlight = new HighlightDecorator(
                new TextElement("Important Note"));

        IDocumentElement emphasisText = new ItalicDecorator(
                new TextElement("This is emphasized"));

        // Create a nested decorated element
        IDocumentElement complexText = new BoldDecorator(
                new ItalicDecorator(new HighlightDecorator(new TextElement("Bold, italic, and highlighted text"))));

        // Build the document structure
        section1.addElement(title);
        section1.addElement(new TextElement("\n"));
        section1.addElement(highlight);
        section1.addElement(new TextElement("\n"));
        section1.addElement(emphasisText);
        section1.addElement(new TextElement("\n"));
        section1.addElement(complexText);

        document.addElement(section1);

        // Render the document
        document.render();

        // Show total character count
        System.out.println("\nTotal characters: " + document.getCharCount());
    }

}
