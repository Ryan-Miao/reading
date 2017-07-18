package com.test.reading.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ryan on 6/29/17.
 */
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = -866544616736226780L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 32)
    private String name;

    @Column
    private String introduction;

    @Column(length = 10)
    private String tag;

    @Column(updatable = false)
    private Date createDate;

    @Column
    private Date updateDate;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Book(String name, String tag) {

        this.name = name;
        this.tag = tag;
    }

    public Book(String name, String introduction, String tag, Date createDate, Date updateDate) {
        this.name = name;
        this.introduction = introduction;
        this.tag = tag;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Book(String name, String tag, Date createDate) {
        this.name = name;
        this.tag = tag;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", tag='" + tag + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
