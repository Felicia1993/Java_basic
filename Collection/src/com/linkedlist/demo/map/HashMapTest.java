package com.linkedlist.demo.map;

import java.util.HashMap;

public class HashMapTest{
    public static void main(String[] args) {
        HashMap<String, Employee> map = new HashMap<>();
        map.put("123123", new Employee("Amy Lee"));
        map.put("123124", new Employee("Harry Lee"));
        map.put("123125", new Employee("Gary Lee"));
        map.put("123126", new Employee("Francesca Lee"));
        System.out.println(map);

        map.remove("123124");

        map.put("123126", new Employee("new Name"));
        map.forEach((k,v) -> {
            System.out.println("key = " + k + ", value =" + v.toString());
        });
    }
}
