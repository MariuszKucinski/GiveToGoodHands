package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Donation;

import java.util.List;

public interface DonationService {

    List<Donation> findAllDonations();
    int getDonationQuantity();
    void addDonation(Donation donation);
}
