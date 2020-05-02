package com.shiv;

import static com.shiv.Node.findCommonElements;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //q14 test code here
//        Node l1 = new Node(1);
////        l1.nextNode = new Node(2);
////        l1.nextNode.nextNode = new Node(3);
////        l1.nextNode.nextNode.nextNode = new Node(4);
////        l1.nextNode.nextNode.nextNode.nextNode = new Node(6);
////
////        Node l2 = new Node(2);
////        l2.nextNode = new Node(4);
////        l2.nextNode.nextNode = new Node(6);
////        l2.nextNode.nextNode.nextNode = new Node(8);
////
////        Node common = findCommonElements(l1,l2);

        //q15 test code here
//        Node l1 = new Node(3);
//        l1.nextNode = new Node(6);
//        l1.nextNode.nextNode = new Node(9);
//        l1.nextNode.nextNode.nextNode = new Node(15);
//        l1.nextNode.nextNode.nextNode.nextNode = new Node(30);
//
//        Node l2 = new Node(10);
//        l2.nextNode = new Node(15);
//        l2.nextNode.nextNode = new Node(30);
//
//        Integer common = Node.detectLinked(l1,l2);
//
//
        //q17 test test code here
//        Node l1 = new Node(1);
//        l1.nextNode = new Node(2);
//        l1.nextNode.nextNode = new Node(3);
//        l1.nextNode.nextNode.nextNode = new Node(4);
//        l1.nextNode.nextNode.nextNode.nextNode = new Node(5);
//
//        Node common = Node.segregateEvenOdd(l1);

        //q18, q19 test code here
        Node l1 = new Node(1);
        l1.nextNode = new Node(2);
        l1.nextNode.nextNode = new Node(3);
        l1.nextNode.nextNode.nextNode = new Node(4);
        l1.nextNode.nextNode.nextNode.nextNode = new Node(5);

        Node common = Node.reverseEveryKNodes(l1,2);

        //q20 test code here
//        Node l1 = new Node(5);
//        l1.nextNode = new Node(10);
//        l1.nextNode.nextNode = new Node(15);
//        l1.nextNode.nextNode.nextNode = new Node(40);
//
//        Node l2 = new Node(2);
//        l2.nextNode = new Node(3);
//        l2.nextNode.nextNode = new Node(20);
//
//        Node Decr = Node.mergeReversed(l1,l2);
//
    }


}
