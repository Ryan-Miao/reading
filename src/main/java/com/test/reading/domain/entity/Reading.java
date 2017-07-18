package com.test.reading.domain.entity;

import com.test.reading.domain.entity.user.UserInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ryan on 6/30/17.
 */
@Entity
public class Reading implements Serializable {

    private static final long serialVersionUID = 7790582961144916158L;
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Book book;
    @ManyToOne
    private UserInfo userInfo;

    @Column(nullable = false)
    private int page;
    private String comment;

    @Column(nullable = false)
    private Integer nums;

    @Column(nullable = false, updatable = false)
    private Date time;

    public Reading() {
    }

    public Reading(Book book, UserInfo userInfo, int page, String comment, Integer nums, Date time) {
        this.book = book;
        this.userInfo = userInfo;
        this.page = page;
        this.comment = comment;
        this.nums = nums;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "id=" + id +
                ", book=" + book +
                ", userInfo=" + userInfo +
                ", page=" + page +
                ", comment='" + comment + '\'' +
                ", nums=" + nums +
                ", time=" + time +
                '}';
    }
}