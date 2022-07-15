package ch.zli.m223.punchclock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private Entry entry;

    @ManyToOne
    @JoinColumn(name="gender_id", nullable=false)
    private Gender gender;

    
    /** 
     * @param username
     * @param password
     */
    public void createUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    /** 
     * @return Long
     */
    public Long getId(){
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getUsername() {
        return username;
    }

    
    /** 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }    

    
    /** 
     * @return String
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * @return Gender
     */
    public Gender getGender() {
        return this.gender;
    }

    
    /** 
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
