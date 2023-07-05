package com.example.Controlador.view;


import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.example.Controlador.Modelo.Person;

public class PersonController {
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    private EntityManagerFactory emf;

    public PersonController() {
        this.emf = Persistence.createEntityManagerFactory("BaseDatos");
    }

    public ObservableList<Person> loadPersons() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> persons = query.getResultList();

            // Add persons to the observable list
            personData.addAll(persons);

            return personData;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return personData;
    }

    public void insertPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Person findPerson(String name, String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.name = :name AND p.email = :email");
            query.setParameter("name", name);
            query.setParameter("email", email);
            List<Person> results = query.getResultList();
            if (!results.isEmpty()) {
                return results.get(0);
            }
        } finally {
            em.close();
        }
        return null; // If no person is found with the provided data
    }
}
