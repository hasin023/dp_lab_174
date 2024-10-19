# Lab Assignment: Document Formatting System Using Design Patterns

## Background
A publishing company needs a flexible document management system that can handle complex document structures with various formatting options. The system should be able to:
- Manage both simple text elements and composite document sections
- Apply multiple formatting styles to any text (bold, italic, highlighting, etc.)
- Calculate total character count including formatting characters
- Allow for easy addition of new formatting options in the future
- Support nested document structures of arbitrary depth

## Task Description
Design and implement a document formatting system that combines the Composite and Decorator patterns to meet the following requirements:

### Core Requirements
1. Create a base component interface (`DocumentElement`) that defines:
   - A method to render the content
   - A method to calculate character count

2. Implement the Composite pattern with:
   - A leaf class for basic text elements
   - A composite class for document sections that can contain other elements
   - Methods to add and remove elements from sections

3. Implement the Decorator pattern with:
   - A base decorator class
   - At least three concrete decorators for different formatting options:
     * Bold formatting (adds ** around text)
     * Italic formatting (adds _ around text)
     * Highlighting (adds [[ ]] around text)

### Additional Requirements
4. All formatting decorators must:
   - Properly update the character count to include formatting characters
   - Maintain the ability to be nested (e.g., bold and italic text)

5. The document section must:
   - Have a name/title
   - Calculate total character count for all contained elements
   - Provide proper visual separation when rendering

### Technical Requirements
- Use Java programming language
- Follow SOLID principles
- Provide clear documentation for each class
- Include a demonstration class showing various use cases

## Example Usage
Your implementation should support operations like:
```java
DocumentSection document = new DocumentSection("Main Document");
DocumentElement boldText = new BoldDecorator(new TextElement("Important"));
DocumentElement complexText = new ItalicDecorator(new BoldDecorator(new TextElement("Both")));
document.addElement(boldText);
document.addElement(complexText);
```

## Bonus Challenges
1. Add a new decorator for underlined text
2. Implement a method to export the document in HTML format
3. Add support for document statistics (word count, paragraph count, etc.)

## Notes
- Focus on design pattern implementation rather than complex formatting logic
- Consider edge cases in character counting and nested formatting
- Think about how your design would accommodate future formatting options
