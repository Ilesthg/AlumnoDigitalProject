package utilities.fakerUtils;

import java.util.ArrayList;
import java.util.List;

public class FakerBusinessClass {


    public List<String> validNames() {
        FakerServiceClass.listRandomFirstNames();
        return FakerServiceClass.listRandomFirstNames();
    }

    public List<String> invalidNames() {
        List<String> list = new ArrayList<>();
        for (String name : FakerServiceClass.listRandomFirstNames()) {
            {
                String a = name + "1234567890";
                list.add(name);
            }
        }
        return list;
    }
}
