package com.linkedin.jakarta.book_service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional //Every Method as Transaction
@ApplicationScoped // Instantiation as Singleton
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book b){
        entityManager.persist(b);
    }

    public List<Book> findAll(){
        return entityManager
                .createQuery("FROM "  + Book.class.getSimpleName() + " b", Book.class)
                .getResultList();
    }

    public List<Book> findBookByAuthor(String author) {
        return entityManager
                .createQuery("SELECT b from Book b where b.author like :authorName", Book.class)
                .setParameter("authorName", author)
                .getResultList();
    }
}
