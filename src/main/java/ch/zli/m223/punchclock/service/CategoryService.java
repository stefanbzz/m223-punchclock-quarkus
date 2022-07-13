package ch.zli.m223.punchclock.service;

import java.lang.reflect.Constructor;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ch.zli.m223.punchclock.domain.Category;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    public CategoryService(){

    }

    @Transactional 
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Transactional 
    public Category deleteCategory(long id) {
        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
        return category;
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }
}
