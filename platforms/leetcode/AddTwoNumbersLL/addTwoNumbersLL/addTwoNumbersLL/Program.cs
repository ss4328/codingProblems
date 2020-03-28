using System;

namespace addTwoNumbersLL
{
    class Program
    {
        
         
        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }


        public string stringReverse(string s)
        {
            char[] charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }

        public double returnIntFromLinkedList(ListNode listElem)
        {
            int tenPower = 0;
            double result = 0;
            while (listElem != null)
            {
                double multiplier = 0;
                multiplier = Math.Pow(10, tenPower);
                result += listElem.val * multiplier;
                tenPower++;
                listElem = listElem.next;
            }
            Console.WriteLine(result.ToString());
            return result;
        }

        public ListNode convertNumberToLinkedList(double resultNumber)
        {
            ListNode resultLL = new ListNode(0);
            ListNode dummy = resultLL;
            string numberToString = resultNumber.ToString();
            numberToString = stringReverse(numberToString);
            foreach (char c in numberToString)
            {
                resultLL.next = new ListNode(c - '0');
                Console.WriteLine(c);
                resultLL = resultLL.next;
            }

            // resultLL=null;
            // ListNode dummy = resultLL;

            return dummy.next;
        }
        public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            double resultInt = returnIntFromLinkedList(l1) + returnIntFromLinkedList(l2);
            ListNode answer = convertNumberToLinkedList(resultInt);

            return answer;



        }

        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
