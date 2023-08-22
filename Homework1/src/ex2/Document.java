package ex2;

import java.util.UUID;

public class Document {
    private String documentId;
    private String documentTitle;

    public Document() {}
    public Document(String documentTitle) {
        this.documentId = UUID.randomUUID().toString();
        this.documentTitle = documentTitle;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                '}';
    }
}
