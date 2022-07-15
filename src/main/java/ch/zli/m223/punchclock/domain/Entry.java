package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime checkIn;

    @Column(nullable = false)
    private LocalDateTime checkOut;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    
    /** 
     * @param checkIn
     */
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    
    /** 
     * @param checkOut
     */
    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    
    /** 
     * @return Category
     */
    public Category getCategory(){
        return category;
    }

    
    /** 
     * @param category
     */
    public void setCategory(Category category){
        this.category = category;
    }
}