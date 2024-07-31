package com.procheck.distributerservice;

import com.procheck.distributerservice.repository.DistributerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

@Data
@RequiredArgsConstructor
public class SampleDataLoader implements CommandLineRunner {
    private final DistributerRepository distributerRepository;

    // List of distributor names
    /*private final List<String> distributerNames = List.of(
            "IWACO", "GO COM", "TENORDISTRIB", "ESHOP", "INWIDISTRIB", "IWACO-DEALER", "GOCOM-DEALER", "BOOMING",
            "TENOR-DEALER", "ADAM PHONE", "ESHOP-DEALER", "CORE MARKET", "INCONNU",
            "AXSEELAGENCY", "ANDNA MED", "MARCOM EDGE", "2 A TELECOM", "CILICEVENT", "AGENCE121"
            , "IWACO CHANLLENG", "ESHOP CHANLLENG", "TENOR CHANLLENG", "GOCOM CHANLLENG"
    );
    Random random = new Random();*/

    @Override
    public void run(String... args) throws Exception {
        // Create initial data for Distributer and Reception
        /*List<Distributer> distributerList = distributerRepository.findAll();
        List<City> cityList = cityRepository.findAll();

        Region region = regionRepository.findAll().stream().findFirst().orElse(null);
        region.setCityList(cityList);
        regionRepository.save(region);

        City city = cityRepository.findAll().stream().findFirst().orElse(null);
        city.setDistributerList(distributerList);
        cityRepository.save(city);
*/
        /*for (String dis : distributerNames) {
            Distributer distributer = new Distributer();
            distributer.setIsActivated(true);
            distributer.setIsDeleted(false);
            distributer.setCreatedAt(LocalDateTime.now());
            distributer.setName(dis);
            distributer.setAddress("Address of " + dis);
            distributer.setCity(city);
            distributerList.add(distributer);
            // Save the Distributeur first
        }
        distributerRepository.saveAll(distributerList);*/
    }
}