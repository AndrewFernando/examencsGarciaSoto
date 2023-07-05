package com.example.Controlador.Modelo;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(catalog = "javafx", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Estudiantes.seleccionaTodos", query = "SELECT p FROM Persons p"),
    @NamedQuery(name = "Estudiantes.seleccionaPorId", query = "SELECT e FROM Persons p WHERE p.id = :id")})

public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "street")
    private String street;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "birthday")
    private LocalDate birthday;

	public Person() {
    this(null, null, null, 0, null, null);
	}

	public Person(String firstName, String lastName, String street, int postalCode, String city, LocalDate birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.birthday = birthday;
	}

	public Integer getid(){
		return id;
	}
	public void setId (Integer id){
		this.id = id;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
		
	public StringProperty firstNameProperty() {
		return new SimpleStringProperty(firstName);
	}
		
	public StringProperty lastNameProperty() {
		return new SimpleStringProperty(lastName);
	}
	public StringProperty streetProperty() {
		return new SimpleStringProperty(street);
	}
		
	public IntegerProperty postalCodeProperty() {
		return new SimpleIntegerProperty(postalCode);
	}
	public StringProperty cityProperty() {
		return new SimpleStringProperty(city);
	}
	public ObjectProperty<LocalDate> birthdayProperty() {
		return new SimpleObjectProperty<>(birthday);
	}
}