    public void removeDuplicatesSorted(Node root){
        Node cur = root;
        int curVal = cur.data;
        while(cur.nextNode!=null){
            while(cur.nextNode.data==cur.data){
                //null check needed here
                cur = cur.nextNode;
            }
            Node nextNode = cur.nextNode;
            root.nextNode = nextNode;

        }
    }
