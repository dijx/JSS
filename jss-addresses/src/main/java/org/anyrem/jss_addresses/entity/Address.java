package org.anyrem.jss_addresses.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "jss", name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "location_unit")
    private LocationUnit locationUnit;

    @NotNull
    @Column(name = "unit_name")
    private String unitName;

    @NotNull
    @Column(name = "building")
    private String building;

    @Nullable
    @Column(name = "flat")
    private String flat;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "country")
    private Country country;


    public Address() {
    }

    public Address(@NotNull LocationUnit locationUnit,
                   @NotNull String unitName,
                   @NotNull String building,
                   @Nullable String flat,
                   @NotNull String city,
                   @NotNull Country country
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
}
