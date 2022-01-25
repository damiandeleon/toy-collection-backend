package com.company.collection.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
@Entity
@JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
@Table(name = "toy")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String toyName;
    private String toyLine;
    private String faction;
    private String maxForAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public String getToyLine() {
        return toyLine;
    }

    public void setToyLine(String toyLine) {
        this.toyLine = toyLine;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getMaxForAge() {
        return maxForAge;
    }

    public void setMaxForAge(String maxForAge) {
        this.maxForAge = maxForAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return maxForAge == toy.maxForAge && Objects.equals(id, toy.id) && Objects.equals(toyName, toy.toyName) && Objects.equals(toyLine, toy.toyLine) && Objects.equals(faction, toy.faction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, toyName, toyLine, faction, maxForAge);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", toyName='" + toyName + '\'' +
                ", toyLine='" + toyLine + '\'' +
                ", faction='" + faction + '\'' +
                ", maxForAge=" + maxForAge +
                '}';
    }
}
