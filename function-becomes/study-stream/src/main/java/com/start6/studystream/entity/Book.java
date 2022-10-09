package com.start6.studystream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zhoukai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {
    private Long id;
    /**
     * 书名
     */
    private String name;
    /**
     * 分类
     */
    private String category;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 介绍
     */
    private String intro;
}
