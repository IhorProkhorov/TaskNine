package com.hillel.IhorProkhorov.HomeTaskNine;

import java.util.Collection;

public class MyLinkedList implements CustomCollection {

    private int size = 0;
    private Node<String> first;
    private Node<String> last;

    @Override
    public boolean add(String str) {
        final Node<String> lastNode = last;
        final Node<String> newNode = new Node<>(lastNode, str, null);
        last = newNode;
        if (lastNode == null)
            first = newNode;
        else
            lastNode.next = newNode;
        this.size++;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            add(strArr[i]);
            i++;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        String[] stockArr = (String[]) strColl.toArray(new String[strColl.size()]);
        addAll(stockArr);
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index >= 0 && index < size) {
            Node<String> tempNode = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    final Node<String> next = tempNode.next;
                    final Node<String> prev = tempNode.previous;
                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        tempNode.previous = null;
                    }
                    if (next == null) {
                        last = prev;
                    } else {
                        next.previous = prev;
                        tempNode.next = null;
                    }
                    tempNode.data = null;
                    size--;
                    break;
                }
                tempNode = tempNode.next;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String str) {
        boolean flag = false;
        Node<String> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.data == str) {
                final Node<String> next = temp.next;
                final Node<String> prev = temp.previous;
                if (prev == null) {
                    first = next;
                } else {
                    prev.next = next;
                    temp.previous = null;
                }
                if (next == null) {
                    last = prev;
                } else {
                    next.previous = prev;
                    temp.next = null;
                }
                temp.data = null;
                size--;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index < size) {
            Node<String> x = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    break;
                }
                x = x.next;
            }
            return x.data;
        }
        return "Index is out of range";
    }

    @Override
    public boolean contains(String str) {
        boolean flag = false;
        Node<String> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.data == str) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    @Override
    public boolean clear() {
        Node<String> temp = first;
        while (temp != null) {
            Node<String> x = temp.next;
            temp.data = null;
            temp.next = null;
            temp.previous = null;
            temp = x;
        }
        first = last = null;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean trim() {
        return false;
    }

    @Override
    public boolean compare(Collection coll) {
        String[] stockArr = (String[]) coll.toArray(new String[coll.size()]);
        boolean flag = false;
        for (int i = 0; i < stockArr.length; i++) {
            if (contains(stockArr[i])) flag = true;
        }
        return flag;
    }
}

 class Node<String> {
     public String data;
     public Node<String> next;
     public Node<String> previous;

     Node(Node<String> previous, String data, Node<String> next) {
         this.previous = previous;
         this.data = data;
         this.next = next;
     }
 }

