package com.example.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    /**
     *  - 데이터를 담고 있는 저장고(컬렉션)이 아니다
     *  - 스트림이 처리하는 데이터 소스는 변경하지 않는다.
     *  - 스트림은 한번만 처리한다.
     *  - 중계 오퍼레이터
     *      Stream 리턴
     *  - 종료 오퍼레이터
     *      Stream 리턴 X
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> collect = list.stream()
                .map(String::toUpperCase) // 이상태는 실행하지 않음, 종료가 있어야함
                .collect(Collectors.toList()); // 종료 오퍼레이터

        // 병렬 처리 parallelStream()
        // 기본
        List<String> collect1 = list.stream().map(String::toUpperCase)
                .collect(Collectors.toList());

        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        Map<String,String> map3 = new HashMap<>();
        map1.put("data","1");
        map2.put("data","2");
        map3.put("data","3");

        List<Map<String,String>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);

        // 걸러내기
        mapList.stream()
                .filter(m -> m.get("data").startsWith("1"))
                .forEach(data -> System.out.println(data));

        // 변경
        mapList.stream()
                .map(m -> m.get("data"))
                .forEach(s -> System.out.println(s));

        // 단일 원소로
        mapList.stream()
                .flatMap(m -> m.values().stream())
                .forEach(value -> System.out.println(value));

        // 10 부터 1씩 증가하는 무제한 스트림
        Stream.iterate(10, i -> i+1)
                .skip(5)
                .limit(5)
                .forEach(m -> System.out.println(m));

        // value가 1인 값 있는지
        boolean test = mapList.stream()
                .anyMatch(m -> m.get("data").equals("1"));
        System.out.println(test);

    }
}
