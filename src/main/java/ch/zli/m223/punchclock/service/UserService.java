package ch.zli.m223.punchclock.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.springframework.security.crypto.bcrypt.BCrypt;

import ch.zli.m223.punchclock.domain.User;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    public UserService() {
    }

    @Transactional 
    public void createUser(User user) {
        String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pw_hash);
        entityManager.persist(user);
    }

    @Transactional
    public User updateUser(User user) {
        //If the password was not set by the update, use the password of the existing user
        if(user.getPassword() == "" || user.getPassword() == null) {
            User toEditUser = entityManager.find(User.class, user.getId());
            user.setPassword(toEditUser.getPassword());
        }else {
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())); //Hash the users new password
        }
        entityManager.merge(user);
        return user;
    }

    @Transactional
    public User deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }

    @Transactional 
    public Optional<User> findUser(String username) {
        return entityManager.createNamedQuery("findUserByUsername", User.class)
            .setParameter("username", username)
            .getResultStream()
            .findFirst();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }
}