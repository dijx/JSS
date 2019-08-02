package org.anyrem.jssCustomerViewer.model;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class Customer {

    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Long> addresses;
    private Set<Address> addressesFull;

    public Customer() {
    }

    public Customer(@NotNull String login, @NotNull String password) {
        this.login = login;
        this.password = password;
    }

    public Customer(@NotNull String login, @NotNull String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(@NotNull String login, @NotNull String password, Set<Long> addresses) {
        this.login = login;
        this.password = password;
        this.addresses = addresses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Long> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Long> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Long id) {

        this.addresses.add(id);
    }

    public Set<Address> getAddressesFull() {
        return addressesFull;
    }

    public void setAddressesFull(Set<Address> addressesFull) {
        this.addressesFull = addressesFull;
    }

    public void addAddressFull(Address address) {
        addressesFull.add(address);
    }

}
