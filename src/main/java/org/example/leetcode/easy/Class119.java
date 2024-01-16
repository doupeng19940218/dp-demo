package org.example.leetcode.easy;

import java.util.*;

/**
 * @author walker.dou
 */
public class Class119 {

    public List<Integer> getRow(int rowIndex) {
        final Map<Element, Integer> temp = new HashMap<>();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(getValue(rowIndex + 1, i, temp));
        }
        return result;
    }

    private Integer getValue(int rowIndex, int i, Map<Element, Integer> temp) {
        final Element key = new Element(rowIndex, i);
        if (temp.containsKey(key)){
            return temp.get(key);
        }
        if (i == 0) {
            return 1;
        }
        if (i == (rowIndex - 1)) {
            return 1;
        }
        final Integer first = getValue(rowIndex - 1, i - 1, temp);
        temp.put(new Element(rowIndex - 1, i - 1), first);
        return first + getValue(rowIndex - 1, i, temp);
    }

    public static class Element {
        public Element(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        int rowIndex;
        int columnIndex;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return rowIndex == element.rowIndex && columnIndex == element.columnIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowIndex, columnIndex);
        }
    }


}
