package ch.zli.m223.punchclock.util;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Gender;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.GenderService;
import ch.zli.m223.punchclock.service.UserService;
import io.quarkus.runtime.StartupEvent;


@Singleton
public class Startup {
    @Inject
    UserService userService;

    @Inject
    GenderService genderService;

    @Inject
    CategoryService categoryService;

    
    /** 
     * @param evt
     */
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        //Create test location
        Gender genderm = new Gender();
        Gender genderf = new Gender();
        genderm.setGender("male");
        genderf.setGender("female");
        genderService.createGender(genderm);
        genderService.createGender(genderf);

        
        //test user
        User user = new User();
        user.setGender(genderm);
        user.setUsername("Test-User");
        user.setPassword("12346789");

        userService.createUser(user);

        //test admin
        User admin = new User();
        admin.setGender(genderf);
        admin.setUsername("Test-Admin");
        admin.setPassword("123456789");

        userService.createUser(admin);

        //Create test category
        Category category = new Category();
        category.setTitle("Test category");
        categoryService.createCategory(category);
    }
}