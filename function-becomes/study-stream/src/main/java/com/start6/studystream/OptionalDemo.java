package com.start6.studystream;

import com.start6.studystream.entity.Author;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
//        test02();
        test03();
    }

    private static void test03() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer integer = stream.parallel().filter(num -> num > 5)
                .peek(integer1 -> System.out.println(integer1 + Thread.currentThread().getName()))
                .reduce((result, ele) -> result + ele).get();
        System.out.println(integer);
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
