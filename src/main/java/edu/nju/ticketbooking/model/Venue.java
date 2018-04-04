package edu.nju.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "venues")
public class Venue implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vid", updatable = false)
    private int venueId;

    @Column(name = "vname")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "vpassword")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "vdesc")
    private String description;

    @Column(name = "is_approved")
    private boolean isApproved = false;     // 场馆申请是否通过

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "vid")
    private List<VenueSeatType> seatTypes;

    public Venue() {

    }

    public Venue(String name, String password, String address, String description) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.description = description;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int id) {
        this.venueId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("VENUE"));
    }

    public String getPassword() {
        return password;
    }

    /**
     * 指的是UsernamePasswordAuthentication中的"username"，即用于登陆的key
     */
    @JsonIgnore
    @Override
    public String getUsername() {
        return Integer.toString(this.venueId);
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public List<VenueSeatType> getSeatTypes() {
        return seatTypes;
    }

    public void setSeatTypes(List<VenueSeatType> seatTypes) {
        this.seatTypes = seatTypes;
    }
}
