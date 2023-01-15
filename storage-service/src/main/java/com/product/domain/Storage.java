package com.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UuidGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Storage {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", columnDefinition = "char(36)")
    private UUID id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_url")
    private String fileUrl;
    @Column(name = "flag_code")
    private String flagCode;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "file_size")
    private Long fileSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Storage partner = (Storage) o;
        return id != null && Objects.equals(id, partner.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
