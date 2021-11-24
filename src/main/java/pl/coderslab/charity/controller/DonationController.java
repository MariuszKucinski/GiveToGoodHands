package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class DonationController {

    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    @Autowired
    public DonationController(DonationService donationService,InstitutionService institutionService, CategoryService categoryService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }



    @GetMapping("/form")
    public String getForm(Model model) {
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        List<Category> categoryList = categoryService.findAllCategories();
        System.out.println(categoryList);
        model.addAttribute("categoryList", categoryList);
        List<Institution> institutionList = institutionService.findAllInstitutions();
        model.addAttribute(("institutionList"), institutionList);

        int[] tab = {1,2,3,4,5};
        return "form";
    }

    @PostMapping(value = "/form")
    public String formPost(Donation donation) {
        System.out.println(donation);
        donationService.addDonation(donation);
        return "redirect:/formconfirm";
    }

    @GetMapping(value = "/formconfirm")
    public String formConfirm() {
        return "formconfirm";
    }


}
