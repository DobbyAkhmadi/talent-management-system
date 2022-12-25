package com.product.bootstrap;

import com.github.javafaker.Faker;
import com.product.domain.Partner;
import com.product.repository.PartnerRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Profile({"dev","qa"})
public class AllLoader implements ApplicationListener<ApplicationReadyEvent> {
    private final PartnerRepository partnerRepository;
    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {
        List<Partner> partnerList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String streetAddress = faker.address().streetAddress();
            Partner partner = Partner.builder()
                    .address(streetAddress)
                    .name(name).build();
            partnerList.add(partner);
        }
        partnerRepository.saveAll(partnerList);
    }
}
