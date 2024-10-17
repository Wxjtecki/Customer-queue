//Autor Kamil Pajączkowski
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Customer {
    private int id;
    private int serviceTime;

    public Customer(int id, int serviceTime) {
        this.id = id;
        this.serviceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public int getServiceTime() {
        return serviceTime;
    }
}

class QueueSimulator {
    private Queue<Customer> queue;
    private int totalServiceTime;
    private int totalWaitTime;
    private int customersServiced;

    public QueueSimulator() {
        queue = new LinkedList<>();
        totalServiceTime = 0;
        totalWaitTime = 0;
        customersServiced = 0;
    }

    public void addCustomerToQueue(Customer customer) {
        queue.add(customer);
        System.out.println("Customer " + customer.getId() + " added to queue. Service time: " + customer.getServiceTime());
    }

    public void serveCustomer() {
        if (!queue.isEmpty()) {
            Customer customer = queue.poll();
            System.out.println("Serving Customer " + customer.getId() + " for " + customer.getServiceTime() + " seconds.");
            totalServiceTime += customer.getServiceTime();
            totalWaitTime += totalServiceTime;
            customersServiced++;
        } else {
            System.out.println("No customers in the queue.");
        }
    }

    public void displayStatistics() {
        if (customersServiced > 0) {
            System.out.println("Total Customers Serviced: " + customersServiced);
            System.out.println("Average Wait Time: " + (totalWaitTime / customersServiced) + " seconds.");
        } else {
            System.out.println("No customers have been serviced yet.");
        }
    }

    public static void main(String[] args) {
        QueueSimulator simulator = new QueueSimulator();
        Random rand = new Random();

        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer(i, rand.nextInt(10) + 1);
            simulator.addCustomerToQueue(customer);
        }

        while (!simulator.queue.isEmpty()) {
            simulator.serveCustomer();
        }

        simulator.displayStatistics();
    }
}
