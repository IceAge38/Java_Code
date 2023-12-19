package sit.int202.classicmodels;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import sit.int202.classicmodels.entities.Customer;
import sit.int202.classicmodels.repositories.CustomerRepository;

public class TestArgon2 {
    public static void main(String[] args) {
        //สมมติว่า ใช้ customerNumber แทน Password ก่อนเพราะว่า ไม่มีเวลามาใส่ password ให้กับแต่ละตัว
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d,16,16);
        CustomerRepository repository = new CustomerRepository();
        Customer customer = repository.findByName("Jean King");
        char[] password1 = "abcdefg".toCharArray();
        char[] password2 = "112".toCharArray();
        System.out.println(argon2.verify(customer.getPassword(), password1));  // return Boolean
        System.out.println(argon2.verify(customer.getPassword(), password2));

    }
}

// เอาประโยคนี้ไปใส่ใน console เมื่อต้องการที่จะเพิ่ม field ใน table ;D
//  alter table classicmodels.customers ADD password varchar(255);
