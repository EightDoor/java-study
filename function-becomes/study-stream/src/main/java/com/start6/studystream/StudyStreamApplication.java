package com.start6.studystream;

import com.start6.studystream.entity.Author;
import com.start6.studystream.entity.Book;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhoukai
 */
public class StudyStreamApplication {
    public static void main(String[] args) {
//        List<Author> authors = getAuthors();
//        authors.stream()    // 把集合转换流
//                .distinct()
//                .filter(author -> author.getAge() < 18)
//                .forEach(author -> System.out.println(author.getName()));

//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
        test21();
    }

    private static void test21() {
        List<Author> authors = getAuthors();
        Optional<Integer> integer = authors.stream()
                .map(author -> author.getAge())
                .reduce(new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result > element ? element : result;
                    }
                });
        integer.ifPresent(integer1 -> System.out.println(integer1));
    }

    private static void test20() {
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result > element ? element : result);
        System.out.println(sum);
    }

    private static void test19() {
        //    使用reduce求作者中年龄最大值
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(sum);
    }

    private static void test18() {
        //     ■ 使用reduce求所有作者年龄的和
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(sum);

    }

    private static void test17() {
        List<Author> authors = getAuthors();
        Optional<Author> optionalAuthor = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .distinct()
                .findFirst();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test16() {
        List<Author> authors = getAuthors();
        Optional<Author> optionalAuthor = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() >= 100);
        System.out.println(b);
    }

    private static void test14() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);

        boolean b1 = authors.stream()
                .allMatch(author -> author.getAge() > 30);
        System.out.println(b1);
    }

    private static void test13() {
//            ■ 获取一个Map集合，map的key为作者名，value为List<Book>
        List<Author> authors = getAuthors();
        Map<String, List<Book>> collect = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(collect);
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream()
                .map(author -> author.getName())
                .collect(Collectors.toList());
        System.out.println(collect);

        Set<String> collect1 = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .collect(Collectors.toSet());
        System.out.println(collect1);
    }

    private static void test11() {
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(book -> book.getScore())
                .max((o1, o2) -> o1 - o2);
        System.out.println(max.get());

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(book -> book.getScore())
                .min((o1, o2) -> o1 - o2);
        System.out.println(min.get());
    }

    private static void test10() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test09() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    private static void test08() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test06() {
        //      ● 打印除了年龄最大的作家外的其他作家，要求不能有重复数据，并且按照年龄降序排序。
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test05() {
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家的姓名。
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test04() {
        List<Author> authors = getAuthors();
//        authors.stream()
//                .distinct()
//                .sorted()
//                .forEach((author -> System.out.println(author.getAge())));
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(author -> System.out.println(author));
    }

    private static void test03() {
        // 打印所有的作家名称，并且要求是不能重复元素的。
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author));
    }

    private static void test02() {
        // 打印所有作家的姓名
        List<Author> authors = getAuthors();
//        authors.stream()
//                .forEach(o -> System.out.println(o.getName()));
//        authors.stream().map(author -> author.getName()).forEach(s -> System.out.println(s));
        authors.stream()
                .map((author)->author.getAge())
                .map((age)->age+10)
                .forEach(age -> System.out.println(age));

    }

    private static void test01() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        // 数据初始化
        Author author = new Author(1L, "蒙多1", 33, "一个从菜单中明悟哲理的祖安人1", null);
        Author author2 = new Author(2L, "蒙多2", 15, "一个从菜单中明悟哲理的祖安人2", null);
        Author author3 = new Author(3L, "蒙多3", 14, "一个从菜单中明悟哲理的祖安人3", null);
        Author author4 = new Author(3L, "蒙多3", 14, "一个从菜单中明悟哲理的祖安人3", null);

        // 书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "测试1","测试分类1", 88,"简介1"));
        books1.add(new Book(2L, "测试2","测试分类2", 99,"简介2"));

        books2.add(new Book(3L, "测试3","测试分类3", 85,"简介3"));
        books2.add(new Book(3L, "测试3","测试分类3", 85,"简介3"));
        books2.add(new Book(4L, "测试4","测试分类3", 56,"简介4"));

        books3.add(new Book(5L, "测试5","测试分类5", 56,"简介5"));
        books3.add(new Book(6L, "测试6","测试分类6", 100,"简介6"));
        books3.add(new Book(6L, "测试6","测试分类6", 100,"简介6"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}