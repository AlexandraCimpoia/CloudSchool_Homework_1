package ex2;

import java.util.Queue;

//CONSUMER
public class Printer implements Runnable{
    private Queue<Document> documentsQueue;

    public Printer(Queue<Document> documentsQueue) {
        this.documentsQueue = documentsQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Document document;
                synchronized (documentsQueue) {
                    while (documentsQueue.isEmpty()) {
                        documentsQueue.wait();
                    }
                    document = documentsQueue.poll();
                    documentsQueue.notifyAll();
                }
                System.out.println("Printer printed document " + document.getDocumentId() + " with title " + document.getDocumentTitle());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
