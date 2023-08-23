package ex2;

import java.util.Queue;
import java.util.Random;

//PRODUCER
public class Device implements Runnable{

    private String deviceId;
    private Queue<Document> documentsQueue;
    private Random random = new Random();

    public Device(String id, Queue<Document> queue) {
        this.deviceId = id;
        this.documentsQueue = queue;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                Document document = new Document("Document " + i);
                System.out.println("Device " + deviceId + " produced document " + document.getDocumentId() + " with title " + document.getDocumentTitle());
                synchronized (documentsQueue) {
                    while (documentsQueue.size() >= 5) {
                        documentsQueue.wait();
                    }
                    documentsQueue.add(document);
                    documentsQueue.notifyAll();
                }
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
