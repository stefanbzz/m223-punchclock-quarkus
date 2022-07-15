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

public Long getId() {
    return id;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getGender() {
    return gender;
}

public void setId(Long id) {
    this.id = id;
}
}
