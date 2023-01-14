package com.product.bootstrap;

import com.github.javafaker.Faker;
import com.product.domain.Storage;
import com.product.repository.StorageRepository;
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
    private final StorageRepository storageRepository;
    @Override
    public void onApplicationEvent(@NonNull ApplicationReadyEvent event) {
        List<Storage> storageList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String streetAddress = faker.address().streetAddress();
            Storage partner = new Storage();
                    partner.setFileUrl(streetAddress);
                    partner.setFileName(name);
            storageList.add(partner);
        }
        storageRepository.saveAll(storageList);
    }
}
