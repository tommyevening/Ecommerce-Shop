package pja.tpo.ecommerceshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pja.tpo.ecommerceshop.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}
