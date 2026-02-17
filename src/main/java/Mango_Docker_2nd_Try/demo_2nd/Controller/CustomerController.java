package Mango_Docker_2nd_Try.demo_2nd.Controller;

import Mango_Docker_2nd_Try.demo_2nd.Model.Customer;
import Mango_Docker_2nd_Try.demo_2nd.Service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    CustomerService service = new CustomerService();

    public CustomerController() {
        // no service injection; controller uses DBdata directly
    }
//    @GetMapping("")
//    public String redirect() {
//        return "Welcome to The Manga Spot Customer API!";
//    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int id) {
        Customer e = service.getCustomersById(id);
        if (e == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(e);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer employee) {
        Customer created = CustomerService.createCustomers(employee);
        if (created == null) return ResponseEntity.badRequest().body("Email already exists");
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Customer employee) {
        Customer updated = service.updateCustomers(id, employee);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean ok = service.deleteCustomers(id);
        if (!ok) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Customer deleted");
    }
    @GetMapping("/redirectToLocalhostApi")
    public ResponseEntity<Void> redirectToTarget() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/api/customers"));
        // Use HttpStatus.FOUND (302) for a temporary redirect
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
