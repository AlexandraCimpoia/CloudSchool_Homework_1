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
                synchronized (documentsQueue) { //synchronized block -> only one thread at a time can access the documentsQueue
                    while (documentsQueue.isEmpty()) {
                        documentsQueue.wait();
                    }
                    document = documentsQueue.poll(); //dequeues a document
                    documentsQueue.notifyAll(); //printer thread notifies all waiting threads (devices) that there is space available in the queue
                }
                System.out.println("Printer printed document " + document.getDocumentId() + " with title " + document.getDocumentTitle());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
