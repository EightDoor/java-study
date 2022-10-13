package com.start6.studystream;

import com.start6.studystream.entity.Author;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author zhoukai
 */
public class OptionalDemo {
    public static void main(String[] args) {
//        Author author = getAuthor();
//        Optional<Author> author1 = Optional.ofNullable(author);
//        author1.ifPresent(author2 -> System.out.println(author2));
//        Optional<Author> optional = getAuthorOptional();
//        optional.ifPresent((author -> System.out.println(author.getName())));
//        test01();
        test02();
    }

    private static void test02() {
        Author author = getAuthor();
        Optional<Author> author1 = Optional.ofNullable(author);
        Author author2 = author1.orElseGet(() -> new Author());
        System.out.println(author2);
    }

    private static void test01() {
        Author author = new Author();
        Optional<Author> author1 = Optional.of(null);
        System.out.println(author1);
    }

    public static Optional<Author> getAuthorOptional() {
        Author author = getAuthor();
        return Optional.ofNullable(author);
    }

    public static Author getAuthor() {
        Author author = new Author(1L, "蒙多",33, "一个菜刀中明悟哲理的祖安人", null);
        return null;
    }
}
