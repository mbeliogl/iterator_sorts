package com.maxim;

class Node {
    private int value;
    private Node previous;
    private Node next;

    public Node(int var1) {
        this.value = var1;
        this.previous = null;
        this.next = null;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int var1) {
        this.value = var1;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public void setNext(Node var1) {
        this.next = var1;
    }

    public void setPrevious(Node var1) {
        this.previous = var1;
    }
}
