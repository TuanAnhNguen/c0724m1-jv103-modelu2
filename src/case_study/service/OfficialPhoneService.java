package case_study.service;

import case_study.model.OfficialPhone;
import case_study.repository.OfficialPhoneRepo;

import java.util.ArrayList;
import java.util.List;

public class OfficialPhoneService implements IOfficialPhoneService {
    private static OfficialPhoneRepo officialPhoneRepo = new OfficialPhoneRepo();
    @Override
    public List<OfficialPhone> getAll() {
        List<OfficialPhone> officialPhones = officialPhoneRepo.getAll();
        return officialPhones;
    }

    @Override
    public void add(OfficialPhone officialPhone) {
        officialPhoneRepo.add(officialPhone);
    }

    @Override
    public void deleteById(int id) {
        officialPhoneRepo.deleteById(id);
    }

    @Override
    public OfficialPhone findById(int id) {
        return officialPhoneRepo.findById(id);
//        List<OfficialPhone> officialPhones = officialPhoneRepo.getAll();
//        for (OfficialPhone officialPhone : officialPhones) {
//            if (officialPhone.getId() == id) {
//                return officialPhone;
//            }
//        }
    }

    @Override
    public void update(OfficialPhone officialPhone) {
        officialPhoneRepo.update(officialPhone);
    }

    @Override
    public OfficialPhone findByName(String name) {
        List<OfficialPhone> officialPhones = officialPhoneRepo.getAll();
        for (OfficialPhone officialPhone : officialPhones) {
            if (officialPhone.getNamePhone().equals(name)) {
                return officialPhone;
            }
        }
        return null;
    }
}
