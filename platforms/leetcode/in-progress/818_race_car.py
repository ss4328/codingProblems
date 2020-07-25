class Solution(object):
    def racecar(self, target):
        """
        :type target: int
        :rtype: int
        """
        pos = 0
        speed = 1
        ins = ""
        
        #gen combination of A and R instructions that generate target
        while(pos!=target):
            print("Pos: "+str(pos))
            print("Speed: "+str(speed))
            print("ins: "+ins +"\n")
            if((pos<target and speed>0) or (pos>target and speed<0)):
                
                ins+="A"
                pos+=speed
                speed*=2
            else:
                ins+="R"
                speed = -1 if speed>0 else 1
        
        #sort by length, choose smallest one possible
        
        return len(ins)
        
        