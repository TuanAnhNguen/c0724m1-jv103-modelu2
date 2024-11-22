package case_study.controller;

import case_study.model.OfficialPhone;
import case_study.service.OfficialPhoneService;

import java.util.List;

public class OfficialPhoneController {
    private static final OfficialPhoneService officialPhoneService = new OfficialPhoneService();

    public List<OfficialPhone> getAll() {
        List<OfficialPhone> officialPhones = officialPhoneService.getAll();
        return officialPhones;
    }

    public void add(OfficialPhone officialPhone) {
        officialPhoneService.add(officialPhone);
    }

    public boolean isExists(int id) {
        return officialPhoneService.findById(id) != null;
    }

    public OfficialPhone findById(int id) {
        return officialPhoneService.findById(id);
    }

    public void deleteById(int id) {
        officialPhoneService.deleteById(id);
    }

    public void update(OfficialPhone o) {
        officialPhoneService.update(o);
    }

    public OfficialPhone findByName(String name) {
        return officialPhoneService.findByName(name);
    }
}
