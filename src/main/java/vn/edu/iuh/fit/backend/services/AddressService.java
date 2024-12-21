package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getListAll() {
        return addressRepository.findAll();
    }

    public Address getById(long id) {
        return addressRepository.findByAddressId(id);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public void SaveAddress(Address address) {
        addressRepository.save(address);
    }
}
