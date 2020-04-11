package com.sona.tree;

import java.util.Objects;

public class TreeAnyType implements Comparable<TreeAnyType> {

    private Integer data;

    public TreeAnyType(Integer data) {
        this.data = data;
    }

    @Override
    public int compareTo(TreeAnyType o) {
        return this.data.compareTo(o.data);
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeAnyType)) return false;
        TreeAnyType that = (TreeAnyType) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
