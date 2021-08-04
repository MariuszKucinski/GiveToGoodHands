package pl.coderslab.charity.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepo;
import pl.coderslab.charity.service.DonationService;

import java.util.List;

public class DonationServiceImpl implements DonationService {
    public final DonationRepo donationRepo;

    @Autowired
    public DonationServiceImpl(DonationRepo donationRepo){
        this.donationRepo = donationRepo;
    }

    @Override
    public List<Donation> findAllDonations() {
        return donationRepo.findAll();
    }

    @Override
    public int getDonationQuantity() {
        List<Donation>  donations =  findAllDonations();
        int counter = 0;
        for(int i = 0; i < donations.size(); i++){
            counter += ((Donation)donations.get(i)).getQuantity();
        }
        return counter;
    }

    @Override
    public void addDonation(Donation donation) {
            donationRepo.save(donation);
    }
}
