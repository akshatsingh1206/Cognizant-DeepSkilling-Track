// Exercise 2: Implementing the Factory Method Pattern

// 1. Common Interface
interface Document {
    void open();
    void close();
}

// 2. Concrete Product - PDF
class PdfDocument implements Document {
    public void open() { System.out.println("Opening PDF Document: Reading layout metadata..."); }
    public void close() { System.out.println("Closing PDF Document."); }
}

// 3. Concrete Product - Word
class WordDocument implements Document {
    public void open() { System.out.println("Opening Word Document: Loading text styles..."); }
    public void close() { System.out.println("Closing Word Document."); }
}

// 4. Creator Class / Factory
class DocumentFactory {
    public static Document createDocument(String type) {
        if (type == null || type.isEmpty()) return null;
        switch (type.toUpperCase()) {
            case "PDF":
                return new PdfDocument();
            case "WORD":
                return new WordDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}

// 5. Client Execution
public class DocumentFactoryDemo {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern Demo ---");
        
        // Request a PDF document from the factory
        Document myPdf = DocumentFactory.createDocument("PDF");
        myPdf.open();
        myPdf.close();

        System.out.println();

        // Request a Word document from the factory
        Document myWord = DocumentFactory.createDocument("WORD");
        myWord.open();
        myWord.close();
    }
}