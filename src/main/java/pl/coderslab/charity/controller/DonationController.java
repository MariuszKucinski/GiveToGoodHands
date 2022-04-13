package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import pl.coderslab.charity.service.implementation.CategoryServiceImpl;
import pl.coderslab.charity.service.implementation.DonationServiceImpl;
import pl.coderslab.charity.service.implementation.InstitutionServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    /**
     * TO DO:
     * FORM needs to check the right hour (currently picking an hour earlier than we chose in frontend)
     * FORM needs visually working checkboxes
     * FORM needs working confirmation
     */
    private final DonationServiceImpl donationService;
    private final InstitutionServiceImpl institutionService;
    private final CategoryServiceImpl categoryService;

    @Autowired
    public DonationController(DonationServiceImpl donationService, InstitutionServiceImpl institutionService, CategoryServiceImpl categoryService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @ModelAttribute("donation")
    public Donation donation(){
        return new Donation();
    }


    @GetMapping("/form")
    public String getForm(Model model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        List<Institution> institutionList = institutionService.findAllInstitutions();
        model.addAttribute("institutionList", institutionList);
        return "form";
    }

    @PostMapping(value = "/form")
    public String formPost(@Valid Donation donation, BindingResult bindingResult) {
        donationService.addDonation(donation);
        return "redirect:/formconfirm";
    }


    @GetMapping(value = "/formconfirm")
    public String formConfirm() {
        return "formconfirm";
    }




}
