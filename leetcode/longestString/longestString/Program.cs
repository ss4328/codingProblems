using System;
using System.Collections.Generic;



public class Program
{
    public static void Main()
    {
        Console.WriteLine(LengthOfLongestSubstring("aa"));
    }
    public static int LengthOfLongestSubstring(string s)
    {
        if (s.Length == 0) { return 0; }
        if (s.Length == 1) { return 1; }
        int result = 0;
        int tempRes = 1;
        List<char> encountered = new List<char>();
        char current;
        for (int i = 0; i < s.Length; i++)
        {
            current = s[i];
            encountered.Add(current);
            for (int j = i + 1; j < s.Length; j++)
            {
                //if a new character is encountered
                if (!encountered.Contains(s[j]))
                {
                    //add new char to encountered list
                    encountered.Add(s[j]);
                    tempRes++;
                    if (tempRes > result)
                    {
                        result = tempRes;
                    }
                }
                //if a recurring character occurs
                else
                {
                    if (tempRes > result)
                    {
                        result = tempRes;

                    }
                    encountered.Clear();
                    tempRes = 1;
                    break;
                }

            }
        }
        return result;
    }
}