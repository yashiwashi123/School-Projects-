#Yashar Hashemi <yh7900@bard.edu>
#May 18, 2016
#Assignment 5:Final Assignment
#I worked alone on this project

from Myro import *
from Graphics import *
from random import * 

class Obstacle(object): 
    
    Width = 30
    Height = 40
    
    def __init__(self, xaxis, yaxis, win): 
        
        self.win = win
        self.width = Obstacle.Width
        self.height = Obstacle.Height
        self.shape = Rectangle(Point(xaxis - self.width/2, yaxis - self.height/2), Point(xaxis + self.width/2, yaxis + self.height/2))
        self.shape.setFill(Color(choice(["blue","red", "purple", "yellow"])))
        self.shape.draw(win)
        
    def checkCollision(self, other): 
        myX1 = self.shape.x - self.width/2
        myY1 = self.shape.y - self.height/2 
        myX2 = self.shape.x + self.width/2
        myY2 = self.shape.y + self.width/2
        otherX1 = other.x - other.getWidth()/2
        otherY1 = other.y - other.getHeight()/2
        otherX2 = other.x + other.getWidth()/2
        otherY2 = other.y + other.getHeight()/2
        
        return ((myX1 < otherX2) and (myX2 > otherX1) and (myY1 < otherY2) and (myY2 > otherY1))
        
class thinWall(Obstacle): 
    
    Width = 75
    Height = 15
    
    def __init__(self, xaxis, yaxis, win):
        Obstacle.__init__(self, xaxis, yaxis, win)
        
    
    
class squareWall(Obstacle): 
    
    Width = 50
    Height = 50
    
    def __init__(self, xaxis, yaxis, win):
        Obstacle.__init__(self, xaxis, yaxis, win)
        
 
class Points():
        
        p1 = (random() *500)
        p2 = (random() * 500)
        wid= 15
        hei= 15 
       
        
        
        def __init__(self, win):
            self.win = win
            self.width = self.wid
            self.height = self.hei
            self.point_time = currentTime()
            self.appearance=Circle(Point(self.p1, self.p2), 10)
            self.appearance.setOutline(Color("black"))
            self.appearance.setFill(Color("yellow"))
            self.appearance.draw(win)
            
        def checkCollisionPoint(self, other): 
            myX1 = self.appearance.x - self.width/2
            myY1 = self.appearance.y - self.height/2
            myX2 = self.appearance.x + self.width/2
            myY2 = self.appearance.y + self.height/2
            otherX1 = other.x - 5
            otherY1= other.y - 5
            otherX2 = other.x + 5
            otherY2 = other.y + 5
            
            return((myX1 < otherX2) and (myX2 > otherX1) and (myY1 < otherY2) and (myY2 > otherY1))
            
        
      
        
        
win = Window("Don't Get Hit", 500, 500)
win.setBackground(Color(46, 232, 207))

score = 0 

obstacles = [] 

points= []

t = Text(Point(50, 25), "Score: " + str(score))
t.setFill(Color(255,255,255))
t.fontSize= 20
t.draw(win)

cursor = Circle(Point(win.getWidth()//2, win.getHeight()//2), 10)
cursor.setFill(Color(199, 20, 62))
cursor.setWidth(2)
cursor.draw(win)
speed = 0.05

points.append(Points(win))

points.append(Points(win))
points.append(Points(win))
points.append(Points(win))
points.append(Points(win))
points.append(Points(win))
points.append(Points(win))

obstacles.append(thinWall(win.getWidth()*random(), win.getHeight()*random(), win))
obstacles.append(squareWall(win.getWidth()*random(), win.getHeight()*random(), win))
obstacles.append(thinWall(win.getWidth()*random(), win.getHeight()*random(), win))
obstacles.append(squareWall(win.getWidth()*random(), win.getHeight()*random(), win))


for t in timer(60): 
    gamepad = getGamepadNow()
    dx, dy = gamepad["axis"]
    cursor.move(speed*dx, speed*dy)
    cursorPos = cursor.getCenter()
    
    #t.text = "Score:" + str(score)
    '''
    obstacles.append(thinWall(win.getWidth()*random(), win.getHeight()*random(), win))
    obstacles.append(squareWall(win.getWidth()*random(), win.getHeight()*random(), win))
    obstacles.append(thinWall(win.getWidth()*random(), win.getHeight()*random(), win))
    obstacles.append(squareWall(win.getWidth()*random(), win.getHeight()*random(), win))
    
    points.append(Points(win))
    points.append(Points(win))
    points.append(Points(win))
    points.append(Points(win))
    points.append(Points(win))
    points.append(Points(win))
    points.append(Points(win))
    '''
    for point in points:
        if point.checkCollisionPoint(cursor): 
            score = score + 10
            Points.undraw
    for wall in obstacles:    
        if thinWall.checkCollision == True: 
            center = Point(win.getWidth()/2, win.getHeight()/2)
            message = Text(center, "GAME OVER")
            message.setFill(Color("black"))
            message.draw(win) 
    
        if squareWall.checkCollision == True: 
            center = Point(win.getWidth()/2, win.getHeight()/2)
            message = Text(center, "GAME OVER")
            message.setFill(Color("black"))
            message.draw(win)








