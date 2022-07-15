package ch.zli.m223.punchclock.domain;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Gender {
    private Long id;

    private String gender;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;


/** 
 * @return Long
 */
public Long getId() {
    return id;
}


/** 
 * @param gender
 */
public void setGender(String gender) {
    this.gender = gender;
}


/** 
 * @return String
 */
public String getGender() {
    return gender;
}


/** 
 * @param id
 */
public void setId(Long id) {
    this.id = id;
}
}
