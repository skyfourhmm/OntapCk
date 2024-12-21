package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.services.AddressService;

import java.util.List;

@Controller
@RequestMapping("/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAddressForm() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<Address> addresses = addressService.getListAll();
        modelAndView.addObject("addresses", addresses);
        return modelAndView;
    }

    @GetMapping("/editAddress")
    public String editAddress(@RequestParam("id") Long id, Model model) {
        Address address = addressService.getById(id);  // Tìm address theo id
        if (address == null) {
            return "error";  // Nếu không tìm thấy address, trả về trang lỗi
        }
        model.addAttribute("address", address);  // Thêm address vào model
        return "editAddress";  // Trả về view editAddress
    }

    @PostMapping("/updateAddress")
    public String updateAddress(@ModelAttribute("address") Address address) {
        addressService.updateAddress(address);
        return "redirect:/";
    }

    @PostMapping("/deleteAddress")
    public String deleteAddress(@RequestParam("id") Long id) {
        addressService.deleteAddress(id);
        return "redirect:/";
    }

    @GetMapping("/addAddress")
    public String addAddress(Model model) {
        model.addAttribute("address", new Address());
        return "addAddress";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("address") Address address) {
        addressService.SaveAddress(address);
        return "redirect:/";
    }
}
