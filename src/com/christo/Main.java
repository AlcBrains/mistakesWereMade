package com.christo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>() {{
            add(7);
            add(4);
            add(5);
            add(12);
        }};

        PriorityQueue<TmpObject> queue = new PriorityQueue<>(integerList.size(), Comparator.comparing(TmpObject::getVal));
        for (int i = 0; i < integerList.size(); i++) {
            TmpObject object = new TmpObject(integerList.get(i), i);
            queue.offer(object);
        }

        int adjustedPriority = 1;

        while (!queue.isEmpty()) {
            TmpObject tmp = queue.poll();
            integerList.set(tmp.getPos(), adjustedPriority++);
        }
        System.out.println(integerList);
    }

}

