package org.anyrem.jssCustomerViewer.model;

public class Address {

    private Long id;
    private LocationUnit locationUnit;
    private String unitName;
    private String building;
    private String flat;
    private String city;
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
