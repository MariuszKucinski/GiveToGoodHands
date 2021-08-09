package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @Autowired
    public HomeController(InstitutionService institutionService, DonationService donationService){
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionService.findAllInstitutions();
        model.addAttribute("institutions", institutions);
        int donationsQuantity = donationService.getDonationQuantity();
        model.addAttribute("donationsQuantity", donationsQuantity);
        int donationsCount = donationService.findAllDonations().size();
        model.addAttribute("donationsCount", donationsCount);
        return "index";
    }

}
