package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    
    /** 
     * @param Id
     * @return Entry
     */
    public Entry getEntryById(Long Id){
        return entityManager.find(Entry.class, Id);
    }

    
    /** 
     * @param entry
     * @return Entry
     */
    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    
    /** 
     * @param id
     */
    @Transactional 
    public void delete(long id) {
        Entry entry = entityManager.find(Entry.class, id);
        entityManager.remove(entry);

    }

    
    /** 
     * @param entry
     * @return Entry
     */
    @Transactional 
    public Entry updateEntity(Entry entry) {
        entityManager.merge(entry);
        return entry;
    }

    
    /** 
     * @return List<Entry>
     */
    @SuppressWarnings("unchecked")
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }
}
