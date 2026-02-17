package Mango_Docker_2nd_Try.demo_2nd.CustomerDAO;

import Mango_Docker_2nd_Try.demo_2nd.Model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DBdata {
    // simple in-memory "DB"
    public static final List<Customer> DB = new ArrayList<>();
    public static final AtomicInteger idSeq = new AtomicInteger(1);

    static {
        DB.add(new Customer("John", "Doe", "john.doe@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("Jane", "Smith", "jane.smith@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("blake", "Doe", "blake.doe@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("sam", "Smith", "sam.smith@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("hank", "Doe", "hank.doe@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("phil", "Smith", "phil.smith@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("bob", "Doe", "bob.doe@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("mark", "Smith", "mark.smith@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("york", "Doe", "york.doe@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
        DB.add(new Customer("hellen", "Smith", "hellen.smith@example.com"));
        DB.get(DB.size() - 1).setId(idSeq.getAndIncrement());
    }
}
