package manager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"mia@gmail.com","Mia12345$"});
        list.add(new Object[]{"bella@gmail.com","Bella12345$"});
        list.add(new Object[]{"linaX@gmail.com", "Lina12345$"});
        list.add(new Object[]{"sveta.mail.il@gmail.com", "Sveta2022$"});

        return list.iterator();
    }
}
