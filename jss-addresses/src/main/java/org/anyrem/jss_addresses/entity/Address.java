package org.anyrem.jss_addresses.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "jss", name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_unit")
    private LocationUnit locationUnit;

    
    @Column(name = "unit_name")
    private String unitName;

    
    @Column(name = "building")
    private String building;
    
    @Column(name = "flat")
    private String flat;
    
    @Column(name = "city")
    private String city;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;


    public Address() {
    }

    public Address( LocationUnit locationUnit,
                    String unitName,
                    String building,
                    String flat,
                    String city,
                    Country country
    ) {
        this.locationUnit = locationUnit;
        this.unitName = unitName;
        this.building = building;
        this.flat = flat;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationUnit getLocationUnit() {
        return locationUnit;
    }

    public void setLocationUnit(LocationUnit locationUnit) {
        this.locationUnit = locationUnit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {

        Address compared = (Address) obj;

        if (compared.locationUnit.equals(this.locationUnit) &&
                compared.unitName.equals(this.unitName) &&
                compared.building.equals(this.building) &&
                compared.flat.equals(this.flat) &&
                compared.city.equals(this.city) &&
                compared.country.equals(this.country)
        ) {
            return true;
        } else {
            return false;
        }
    }
}
