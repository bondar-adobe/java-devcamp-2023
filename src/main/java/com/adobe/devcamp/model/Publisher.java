package com.adobe.devcamp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A publisher is a place to display that message
 */
public final class Publisher {
 private final String name;
    private final Set<Domain> domains;
    private final List<Integer> users;
    private final List<Integer> advertisers;

    @JsonCreator
    public Publisher(@JsonProperty(value = "name") String name,
                     @JsonProperty(value= "domains") Set<Domain> domains,
                     @JsonProperty(value = "users") List<Integer> users,
                     @JsonProperty(value = "advertisers") List<Integer> advertisers) {
        this.name = name;
        this.domains = domains;
        this.users = users;
        this.advertisers = advertisers;
    }

    public String getName() {
        return name;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public List<Integer> getAdvertisers() {
        return advertisers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getDomains(), publisher.getDomains()) &&
                Objects.equals(getUsers(), publisher.getUsers()) &&
                Objects.equals(getAdvertisers(), publisher.getAdvertisers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDomains(), getUsers(), getAdvertisers());
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", domains=" + domains +
                ", users=" + users +
                ", advertisers=" + advertisers +
                '}';
    }
}
