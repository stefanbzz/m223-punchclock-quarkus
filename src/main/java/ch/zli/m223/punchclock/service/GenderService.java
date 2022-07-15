package ch.zli.m223.punchclock.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Gender;

@ApplicationScoped
public class GenderService {
    @Inject
    private EntityManager entityManager;

    
    /** 
     * @param gender
     * @return Gender
     */
    @Transactional
    public Gender createGender(Gender gender) {
        entityManager.persist(gender);
        return gender;
    }
}
