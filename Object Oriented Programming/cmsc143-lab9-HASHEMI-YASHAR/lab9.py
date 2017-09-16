#Yashar Hashemi <yh7900@bard.edu>
#April 28, 2016
#Lab 9: Turtle Code
#For this lab I extended a code written by Khondaker Salehin, I also received help from Elias Posen 

from Myro import *
from Graphics import *
from math import *

class Turtle(object):
    
    def __init__(self, win):
        self.win = win
        self.x = win.getWidth()//2
        self.y = win.getHeight()//2
        self.orientation = 0
        self.isPenDown = True
        self.penWidth = 2
        self.penColor = Color("red")
        self.body = Picture("turtle2.png")
        self.body.scale(0.5)
        self.body.setX(self.x)
        self.body.setY(self.y)
        self.body.draw(win) 
    
        
                
    def setPenDown(self): 
        self.isPenDown=True
    
    def setPenUp(self): 
        self.isPenDown=False
        
    def setLineWidth(self, width): 
        self.penWidth = width 
        
    def setPenColor(self, c):
        self.penColor = Color('c')
        
    def dropRectangle (self, width, height): 
        p1 = Point((self.x-(width/2)), (self.y- (height/2)))
        p2 = Point((self.x +(width/2)), (self.y+(height/2)))
        rect= Rectangle(p1, p2)
        rect.fill = pickAColor()
        rect.draw(self.win)  
        
    def dropCircle (self, radius): 
        p = (self.x, self.y)
        cir= Circle(p, radius)
        cir.fill = pickAColor()
        cir.draw(self.win)
                
    
                
    def __str__(self):
        return "(%d, %d), Orientation: %d" %(self.x, self.y, self.orientation)

        
    def forward(self, distance):
        rads = radians(self.orientation)
        dx = distance*cos(rads)
        dy = distance*sin(rads)
        if self.isPenDown:
            l = Line((self.x, self.y), (self.x+dx, self.y+dy))
            l.setColor(Color(self.penColor))
            l.setWidth(self.penWidth)
            l.draw(self.win)
        
        self.body.move(dx, dy)
        self.x = self.x + dx
        self.y = self.y + dy       
                        
    def left(self, degrees):
        self.orientation = self.orientation - degrees
        self.body.rotate(degrees)   
        
            
    def right(self, degrees): 
        self.left(-degrees)
        
    def backward(self, distance): 
        self.forward(-distance)
    
    def moveBy(self, t, r): 
       
        self.forward(t)
        self.left(r)    
        
     
                    
def moveWithGamepad(): 
    win = Window("Turtle Graphics", 500, 500)
    turtle= Turtle(win)
    for time in tiemr (60): 
        r, t = getGamepadNow("axis")
        turtle.moveBy(5*t, 2*r)
        wait(.1)    

def main():
    win = Window("Turtle Graphics", 500, 500)
    win.setBackground(Color("white"))
    
    bob = Turtle(win)
    print(bob)
   
    bob.left(230)
    wait(.5)
    bob.forward(200)
    wait(.5)
    bob.dropCircle(50)
    
    wait(.5)
    bob.left(30)
    bob.backward(60)
    bob.setPenUp() 
    bob.forward(100)
    bob.setPenDown()
    bob.forward(25)
    bob.dropCircle(10)
    #bob.reset()
    #if 
    
main() 