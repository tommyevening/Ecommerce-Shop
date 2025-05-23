package pja.tpo.ecommerceshop.Specification;

import org.springframework.data.jpa.domain.Specification;
import pja.tpo.ecommerceshop.Model.Client;

public class ClientSpecification {
    public static Specification<Client> hasFirstName(String firstName) {
        return (root, query, cb) -> (firstName == null || firstName.trim().isEmpty()) ? null :
                cb.like(cb.lower(root.get("firstName")), "%" + firstName.trim().toLowerCase() + "%");
    }

    public static Specification<Client> hasLastName(String lastName) {
        return (root, query, cb) -> (lastName == null || lastName.trim().isEmpty()) ? null :
                cb.like(cb.lower(root.get("lastName")), "%" + lastName.trim().toLowerCase() + "%");
    }

    public static Specification<Client> hasEmail(String email) {
        return (root, query, cb) -> (email == null || email.trim().isEmpty()) ? null :
                cb.like(cb.lower(root.get("email")), "%" + email.trim().toLowerCase() + "%");
    }

    public static Specification<Client> hasPhoneNumber(String phoneNumber) {
        return (root, query, cb) -> (phoneNumber == null || phoneNumber.trim().isEmpty()) ? null :
                cb.like(cb.lower(root.get("phoneNumber")), "%" + phoneNumber.trim().toLowerCase() + "%");
    }

    public static Specification<Client> hasAddress(String address) {
        return (root, query, cb) -> (address == null || address.trim().isEmpty()) ? null :
                cb.like(cb.lower(root.get("street")), "%" + address.trim().toLowerCase() + "%");
    }
}