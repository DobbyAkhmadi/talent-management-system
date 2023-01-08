package com.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Partner {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", columnDefinition = "char(36)")
    private UUID id;
    private String name;
    private String address;
    @UpdateTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @Column(name = "deleted_at")
    private boolean isDeleted= Boolean.FALSE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Partner partner = (Partner) o;
        return id != null && Objects.equals(id, partner.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
