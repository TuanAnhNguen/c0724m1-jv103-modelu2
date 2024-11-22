package case_study.repository;

import case_study.model.OfficialPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OfficialPhoneRepo {
    public static final String SRC_OFFICIAL = "src/case_study/data/officialPhone.csv";

    public List<OfficialPhone> getAll() {
        List<OfficialPhone> officialPhones = new ArrayList<>();
        File file = new File(SRC_OFFICIAL);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            OfficialPhone officialPhone;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                officialPhone = new OfficialPhone(Integer.parseInt(temp[0]), temp[1],Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),temp[4],Integer.parseInt(temp[5]));
                officialPhones.add(officialPhone);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return officialPhones;
    }

    public void add(OfficialPhone o) {
        File file = new File(SRC_OFFICIAL);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(o.getId() + "," + o.getNamePhone() + "," + o.getPrice() + "," + o.getQuantity() + "," + o.getManufacturer() + "," + o.getWarrantyPeriod());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    public void deleteById(int id) {
        List<OfficialPhone> officialPhones = getAll();
        for (OfficialPhone officialPhone : officialPhones) {
            if (officialPhone.getId() == id) {
                officialPhones.remove(officialPhone);
                break;
            }
        }
        saveList(officialPhones);
    }

    public OfficialPhone findById(int id) {
        List<OfficialPhone> officialPhones = getAll();
        for (OfficialPhone officialPhone : officialPhones) {
            if (officialPhone.getId() == id) {
                return officialPhone;
            }
        }
        return null;
    }

    public static void saveList(List<OfficialPhone> officialPhone) {
        File file = new File(SRC_OFFICIAL);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (OfficialPhone o: officialPhone) {
                bufferedWriter.write(o.getId() + "," + o.getNamePhone() + "," + o.getPrice() + "," + o.getQuantity() + "," + o.getManufacturer() + "," + o.getWarrantyPeriod());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    public void update(OfficialPhone officialPhone) {
        List<OfficialPhone> officialPhones = getAll();
        for (int i = 0; i < officialPhones.size(); i++) {
            if (officialPhones.get(i).getId() == officialPhone.getId()) {
                officialPhones.set(i, officialPhone);
                break;
            }
        }
        saveList(officialPhones);
    }
}
