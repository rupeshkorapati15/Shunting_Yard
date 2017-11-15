package com.example.predator.shunting_yard;


public class LinkedList
{
    public Node getHead() {
        return head;
    }

    private Node head;
    private String Operators = "+-*/";
    private String Precedence = "2233";
    private String Associative = "LLLL";


    public LinkedList()
    {
        this.head = null;
    }

    public void addFront(String value)
    {
        Node n = new Node(value);
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            n.setNextNode(this.head);
            this.head = n;
        }
    }

    public String pop()
    {
        return this.removeFront();
    }


    public boolean push(String op)
    {
        if(this.head == null )
        {
            Node n = new Node(op);
            n.setNextNode(this.head);
            this.head = n;
            return true;
        }

        int topPos = this.Operators.indexOf(this.head.getPayload());
        int topPrec = Integer.parseInt("" + this.Precedence.charAt(topPos));
        char topAss = this.Associative.charAt(topPos);

        int newPos = this.Operators.indexOf(op);
        int newPrec = Integer.parseInt("" + this.Precedence.charAt(newPos));
        char newAss = this.Associative.charAt(newPos);

        if(newPrec > topPrec)
        {
            Node n = new Node(op);
            n.setNextNode(this.head);
            this.head = n;
            return true;
        }
        return false;
    }

    public boolean hasMoreElements()
    {
        return this.head != null;
    }

    public void addEnd(String value)
    {
        Node n = new Node(value);
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            Node currNode = this.head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(n);
        }
    }

    public String removeFront()
    {
        if(this.head == null)
        {
            return null;
        }
        else
        {
            String valueToReturn = this.head.getPayload();
            this.head = this.head.getNextNode();
            return valueToReturn;
        }
    }

    public void display()
    {
        if(this.head == null)
        {
            System.out.println("Empty List");
        }
        else
        {

            this.head.display();

        }
    }
}
