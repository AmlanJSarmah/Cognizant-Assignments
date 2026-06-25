package DesignPatterns;

interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() { System.out.println("Opening Word document"); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening PDF document"); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening Excel document"); }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

public class Exercise2 {
    public static void main(String[] args) {
        DocumentFactory[] factories = { new WordFactory(), new PdfFactory(), new ExcelFactory() };
        for (DocumentFactory f : factories) {
            Document doc = f.createDocument();
            doc.open();
        }
    }
}
