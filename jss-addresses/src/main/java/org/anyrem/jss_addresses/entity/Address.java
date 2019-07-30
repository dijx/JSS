package org.anyrem.jss_addresses.entity;

import javax.persistence.*;

@Entity
@Table(schema = "jss")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
