package com.example.predator.shunting_yard;
import java.util.StringTokenizer;



public class ShYard
{

        private String Stringv;
        public LinkedList getOutput()

        {
        return Output;
         }

    private LinkedList Output;
        private String ops = "+-*/";
        private LinkedList Tokens;
        private LinkedList Stack;

        public ShYard(String Stringv)
        {
            this.Stringv = Stringv;
            this.Tokens = new LinkedList();

            StringTokenizer st;
            st = new StringTokenizer(this.Stringv, this.ops, true);
            String temp;
            while(st.hasMoreTokens())
            {
                temp = st.nextToken().trim();
                if(temp.length() > 0)
                {
                    this.Tokens.addEnd(temp);
                }
            }
        }

        public void convert()
        {
            this.Output = new LinkedList();
            this.Stack = new LinkedList();
            String currToken;
            while(this.Tokens.hasMoreElements())
            {
                currToken = this.Tokens.removeFront();
                if(this.ops.indexOf(currToken) == -1)
                {
                    this.Output.addEnd(currToken);
                }
                else
                {

                    String currOp = this.Stack.pop();

                            this.Output.addEnd(currOp);
                            currOp = this.Stack.pop();

                }
            }

            while(this.Stack.hasMoreElements())
            {
                this.Output.addEnd(this.Stack.pop());
            }
        }

        public void process()
        {
            LinkedList theProcessStack = new LinkedList();
            String currElement;
            while(this.Output.hasMoreElements())
            {
                currElement = this.Output.pop();
                if(this.ops.indexOf(currElement) == -1)
                {
                    theProcessStack.addFront(currElement);
                }
                else
                {
                    double op1 = Double.parseDouble(theProcessStack.pop());
                    double op2 = Double.parseDouble(theProcessStack.pop());
                    if(currElement.equals("+"))
                    {
                        theProcessStack.addFront("" + (op2 + op1));
                    }
                    else if(currElement.equals("-"))
                    {
                        theProcessStack.addFront("" + (op2 - op1));
                    }
                    else if(currElement.equals("*"))
                    {
                        theProcessStack.addFront("" + (op2 * op1));
                    }
                    else if(currElement.equals("/"))
                    {
                        theProcessStack.addFront("" + (op2 / op1));
                    }

                }
            }
            theProcessStack.display();
        }
    }

