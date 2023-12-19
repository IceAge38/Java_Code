package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "offices")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "OFFICE.FIND_ALL", query = "select o from Office o"),
        @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY", query = "select o from Office o where o.country like :countryParam"),  //countryParam ตั้งชื่ออะไรก็ได้ ซึ่งการใส่ : คือเรียกใช้ parameter
        @NamedQuery(name = "OFFICE.FIND_BY_CITY_OR_COUNTRY", query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country")
})
public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    @Column(name = "phone")
    private String phoneNumber;
    private String territory;

    //บอกความสัมพันธ์
    @OneToMany(mappedBy = "officeCode")          // one Office || many Employee + mappedBy กับ foreign key office ใน Employee
    private List<Employee> employeeList;
}
