package com.linkedlist.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListController {
    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.add("Amy");
        s.add("Carl");
        s.add("Erica");

        LinkedList<String> s2 = new LinkedList<>();
        s2.add("Bob");
        s2.add("Doug");
        s2.add("Frances");
        s2.add("Gloria");
        ListIterator<String> sIter = s.listIterator();
        Iterator<String> iterator = s2.iterator();

        while(iterator.hasNext()) {
            if (sIter.hasNext()) {
                sIter.next();
            }
            sIter.add(iterator.next());
        }
        System.out.println(s);

        iterator = s2.iterator();
        while(iterator.hasNext()) {
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        System.out.println(s2);

        s.removeAll(s2);
        System.out.println(s);
    }
}
