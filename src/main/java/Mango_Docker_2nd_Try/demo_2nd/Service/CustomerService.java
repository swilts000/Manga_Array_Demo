package Mango_Docker_2nd_Try.demo_2nd.Service;

import Mango_Docker_2nd_Try.demo_2nd.CustomerDAO.DBdata;
import Mango_Docker_2nd_Try.demo_2nd.Model.Customer;

import java.util.ArrayList;
import java.util.List;

import static Mango_Docker_2nd_Try.demo_2nd.CustomerDAO.DBdata.DB;
import static Mango_Docker_2nd_Try.demo_2nd.CustomerDAO.DBdata.idSeq;

public class CustomerService {
    public List<Customer> getAllCustomers() {
        DBdata DBdata = new DBdata();
        return new ArrayList<>(DB); // return copy
    }

    public Customer getCustomersById(int id) {
        synchronized (DB) {
            return DB.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        }
    }

    public static Customer createCustomers(Customer e) {
        synchronized (DB) {
            // enforce unique email at create time
            boolean exists = DB.stream().anyMatch(x -> x.getEmail().equalsIgnoreCase(e.getEmail()));
            if (exists) return null;
            e.setId(idSeq.getAndIncrement());
            DB.add(e);
            return e;
        }
    }

    public Customer updateCustomers(int id, Customer e) {
        synchronized (DB) {
            for (int i = 0; i < DB.size(); i++) {
                Customer cur = DB.get(i);
                if (cur.getId() == id) {
                    // update fields (allow changing email; adjust constraints if needed)
                    cur.setFirstName(e.getFirstName());
                    cur.setLastName(e.getLastName());
                    cur.setEmail(e.getEmail());
                    return cur;
                }
            }
            return null; // not found
        }
    }

    public boolean deleteCustomers(int id) {
        synchronized (DB) {
            return DB.removeIf(x -> x.getId() == id);
        }
    }
}
