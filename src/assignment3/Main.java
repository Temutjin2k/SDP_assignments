package assignment3;

abstract class Document {
    public abstract void createDocument();
}

class PDFDocument extends Document {
    @Override
    public void createDocument() {
        System.out.println("PDF Document created.");
    }
}

class WordDocument extends Document {
    @Override
    public void createDocument() {
        System.out.println("Word Document created.");
    }
}

// Abstract factory class for creating different documents
abstract class DocumentFactory {
    public abstract Document createDocument();
}

class PDFDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a PDF document.
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.createDocument();

        // Creating a Word document.
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.createDocument();
    }
}
