package eventmanagemnetsystemgui;

import java.util.LinkedList;

public class RedBlackTree {
    private Node root;

    public RedBlackTree() {
        this.root = null;
    }

    public void insert(Event event) {
        Node newNode = new Node(event);
        if (root == null) {
            root = newNode;
            root.color = 0;  // Root is always black
        } else {
            Node current = root;
            Node parent = null;

            while (current != null) {
                parent = current;
                if (event.getEventID() < current.event.getEventID()) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (event.getEventID() < parent.event.getEventID()) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            newNode.parent = parent;
            balanceInsertion(newNode);
        }
    }

    private void balanceInsertion(Node node) {
        while (node != root && node.parent.color == 1) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == 1) {
                    node.parent.color = 0;
                    uncle.color = 0;
                    node.parent.parent.color = 1;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == 1) {
                    node.parent.color = 0;
                    uncle.color = 0;
                    node.parent.parent.color = 1;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = 0;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public Event search(int eventID) {
        Node current = root;
        while (current != null) {
            if (eventID == current.event.getEventID()) {
                return current.event;
            } else if (eventID < current.event.getEventID()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null; // Not found
    }

    public void inOrderTraversal(Node node, LinkedList<Event> eventList) {
        if (node != null) {
            inOrderTraversal(node.left, eventList);
            eventList.add(node.event);
            inOrderTraversal(node.right, eventList);
        }
    }

    public LinkedList<Event> getAllEvents() {
        LinkedList<Event> events = new LinkedList<>();
        inOrderTraversal(root, events);
        return events;
    }

    void remove(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private class Node {
        Event event;
        Node left, right, parent;
        int color;  // 0: Black, 1: Red

        public Node(Event event) {
            this.event = event;
            left = right = parent = null;
            color = 1;  // New node is always Red
        }
    }
}
