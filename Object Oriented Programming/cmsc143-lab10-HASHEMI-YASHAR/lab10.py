#Yashar Hashemi <yh7900@bard.edu>
#5/5/16
#lab10: frogger game
#For this project I modified a code originally made by Khondaker Salein with help from Elais Posen 

from Myro import *
from Graphics import *
from random import *

class Car:
    """Creates an object Car at position (xaxis, yaxis) with speed dx in the Graphics window.
    """

    MAX_SIZE = 90
    MIN_SIZE = 50
    SPEED = 2

    def __init__(self, xaxis, yaxis, dx, win):
        """ Creates a Car object with position and speed information in the game window.
        """
        
        self.win = win
        self.width = uniform(Car.MIN_SIZE, Car.MAX_SIZE)
        self.height = self.width/2
        self.dx = dx * Car.SPEED
        self.dy = 0
        self.shape = Rectangle(Point(xaxis - self.width/2, yaxis - self.height/2), Point(xaxis + self.width/2, yaxis + self.height/2))
        self.shape.setFill(Color(choice(["aqua", "fuchsia", "lavender", "yellow"]))) 
        self.shape.setOutline(Color("Black"))
        self.shape.draw(win) 

    def step(self):
        """ Movement of the Car object along the horizontal axis at a given speed.
        """
        
        self.shape.move(self.dx, self.dy)       
        if (self.shape.x < 0):
            self.shape.move(self.win.getWidth(), 0)
        else:
            if (self.shape.x > self.win.getWidth()):
                self.shape.move(-self.win.getWidth(), 0)
                

    def checkCollision(self, other):
        """ Check if the object Car collides with other object to return True if that is the case. """
        
        myX1 = self.shape.x - self.width/2
        myY1 = self.shape.y - self.height/2
        myX2 = self.shape.x + self.width/2
        myY2 = self.shape.y + self.height/2
        otherX1 = other.x - other.getWidth()/2
        otherY1 = other.y - other.getHeight()/2      
        otherX2 = other.x + other.getWidth()/2
        otherY2 = other.y + other.getHeight()/2   
                
        return ((myX1 < otherX2) and (myX2 > otherX1) and (myY1 < otherY2) and (myY2 > otherY1))
         
         
        
class LillyPad(Car):
    """ A type of an obstacles which inherits properties from parent object Car.
    """
    
    def __init__(self, xaxis, yaxis, dx, win):
        """ Initialize new obstacle type LillyPad. """
        
        Car.__init__(self, xaxis, yaxis, dx, win)
        self.shape.undraw()
        p = makePicture("lilypad.png")
        p.setX(self.shape.x)    # same as the following line of code
        #p.setX(self.shape.getX())
        p.setY(self.shape.y)    # same as the following line of code
        #p.setY(self.shape.getY())
        p.draw(self.win)
        self.shape = p
        #print(self.shape)  ## same as the following line of code 
        #self.shape.draw(win)
        
    def checkCollision(self, other):
        return False

class PowerUp: 
    #power up that speeds up the player
    
    
    
    def __init__(self, win): 
        self.win= win
        self.shape= Circle(Point(win.getWidth()/randrange(1, 9), win.getHeight()/2,) 10) 
        self.shape.setFil(Color("blue"))
        self.shape.draw(self.win)
        self.height=20
        self.width=20
    
    def checkPowerUpCollision(self, other):
        #checks if PowerUp collides with something
        
        myX1 = self.shape.x - (self.width/2)
        myX2 = self.shape.x + (self.width/2)
        myY1 = self.shape.y - (self.height/2)
        myY2 = self.shape.y + (self.height/2)
        otherX1= other.x - other.getWidth()/2
        otherX2 = other.x + other.getWidth()/2
        otherY1 = other.y - other.getHeight()/2
        otherY2 = other.y + other.getHeight()/2
        
        return((myX1 < otherX2) and (myX2 > otherX1) and (myY1 < otherY2) and (myY2 > otherY1))  
    
class Player:
    """ The main player in the froggers name. 
    """
    
    DEAD = 0
    RUNNING = 1
    FINISHED = 2
    
    def __init__(self, p, win):
        """Initiates Player object using a picture 'p' as the player appearance
        """
        
        self.speed = 0.5
        self.startTime = currentTime()
        self.state = Player.RUNNING
        self.win = win
        #self.shape = Circle(Point(win.getWidth()/2, 10), 10)
        #self.shape.setFill(Color("green"))
        self.shape = p
        self.shape.x = win.getWidth()/2
        self.shape.y = win.getHeight()
        self.scoreGraphics = Text(Point(100, win.getHeight()-50), "0")
        self.scoreGraphics.setFill(Color("Red"))
        self.scoreGraphics.fontSize = 32
        self.scoreGraphics.draw(win)
        self.shape.draw(win)


    def move(self, dx, dy, cars, lillyPads, PowerUp):
        """ Moves the frog and check for collisions."""
        
        self.shape.move(dx*self.speed, dy*self.speed)
        
        if (self.shape.getX() < 0):
            self.shape.move(self.win.getWidth(), 0)
        elif (self.shape.getX() > self.win.getWidth()):
            self.shape.move(-self.win.getWidth(),0)
        elif (self.shape.getY() < 0):
            self.state = Player.FINISHED
            
        for car in cars:
            if car.checkCollision(self.shape):
                self.win.setBackground(Color("crimson"))
                self.state = Player.DEAD
        
        if PowerUp.checkPowerUpCollision(self.shape): 
            speed= speed + 2
            PowerUp.shape.undraw()        

def playGame():
    """Starts froggers game
    """
    
    win = Window("Froggers Video Game", 900, 500)
    win.setBackground(Color("AntiqueWhite"))
    
    #test = Car(50, 300, 1, win)
    #test1 = LillyPad(20, 50, 2, win)
    
    #frog = Player(makePicture("frog.png"), win)
    
    cars = []
    lillyPads = []
    powerUps = []
    
    powerUps.append(PowerUp(win.getWidth()*random(), 150, .15, win))
    
    # Add a cars to the game
    cars.append(Car(win.getWidth()*random(), 150, .15, win))
    
    l = Line(Point(0,125), Point(win.getWidth(),125))
    l.setOutline(Color("black"))
    l.draw(win)
   
    cars.append(Car(win.getWidth()*random(), 175, -.25, win))
    
    l = Line(Point(0, 175), Point(win.getWidth(), 175))
    l.setOutline(Color("Black"))
    l.draw

    cars.append(Car(win.getWidth()*random(), 350, .5, win))
    lillyPads.append(LillyPad(win.getWidth()*random(), 225, .73, win))
    
    l = Line(Point(0, 400), Point(win.getWidth(),400))    
    l.setOutline(Color("black"))
    l.draw(win)
        
    # Introduce the player
    frog = Player(makePicture("frog.png"), win)
    
    #print(frog.state)
    
    while (frog.state == Player.RUNNING):
        buttons = getGamepadNow("axis")
        #print(buttons)
        frog.move(buttons[0], buttons[1], cars, lillyPads, powerUps)
        #test.step()
        #test1.step()        
        #cars[0].step()
        #cars[1].step()
        #cars[2].step()
        #lillyPads[0].step()        
        for car in cars:
            car.step()            
        for lilly in lillyPads:
            lilly.step()
        
            
    # Create a GAMEOVER message
    if (frog.state == Player.FINISHED):
        center = Point(win.getWidth()/2, win.getHeight()/2)
        message = Text(center, "Congratulations")
        message.setFill(Color("Blue"))
        message.fontSize = 32
        message.draw(win)
        
    if (frog.state == Player.DEAD):
        center = Point(win.getWidth()/2, win.getHeight()/2)
        message = Text(center, "Game Over")
        message.setFill(Color("Blue"))
        message.fontSize = 32
        message.draw(win)
        
    #wait(1)
        
        
playGame()
