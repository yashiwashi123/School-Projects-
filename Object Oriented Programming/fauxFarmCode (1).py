from Myro import *
from Graphics import *
from random import *


class Plant(object):
    ''' The Plant class that represents a vegetable or fruit to be grown on the Faux Farm'''
    
    # Class attributes
    WIDTH = 50
    HEIGHT = 50
    
    COST = 0
    PROFIT = 0
    HARVEST_TIME = 0
    
    GROWING = 0
    RIPE = 1
    ROTTEN = 2 

    def __init__(self, p, win):
        ''' The Plant constructor takes where to place the plant (a Point) as an argument'''
    
        # Make sure the x and y locations of the plants are on a grid
        self.x = int(p.x) // Plant.WIDTH * Plant.WIDTH
        self.y = int(p.y) // Plant.HEIGHT * Plant.HEIGHT
    
        self.plant_time = currentTime()
    
        # A variable to keep track of the state of the plant
        self.state = Plant.GROWING
        self.appearance = Rectangle(Point(self.x, self.y), Point(self.x + Plant.WIDTH, self.y + Plant.HEIGHT))
        self.appearance.setOutline(Color(255, 255, 255))
        self.appearance. setWidth(2)
        self.appearance.draw(win)
        self.computeTimes()

              
    def computeTimes(self):
        ''' Compute the time until the plant is ripe and rotten'''
        
        self.ripe_time  = self.plant_time + self.HARVEST_TIME
        self.wilt_time = self.plant_time + self.HARVEST_TIME * 2


    def step(self):
        ''' Take a step in the plant simulation: the plant can turn ripe (i.e., ready to harvest) or rotten'''

        if currentTime() > self.wilt_time:
            if random() < self.VOLATILITY:
                #brown = Color(140, 70, 20)
                self.appearance.setFill(Color(140, 70, 20))
                self.appearance.setOutline(Color(140, 70, 20))
                self.state = Plant.ROTTEN
        elif self.state == Plant.GROWING and currentTime() > self.ripe_time:
            self.emphasize()
            self.state = Plant.RIPE
            
            
    def harvest(self):
        ''' Pick the plant and returns the profit from the harvesting the plant'''
        
        self.appearance.undraw()
        if self.state == Plant.RIPE:
            return self.PROFIT 
        else:
            return 0

    def selected(self, p):
        ''' Returns True if plant p is inside the plant list and False otherwise'''
        
        if p.x >= self.x and p.x <= self.x + self.WIDTH and p.y >= self.y and p.y <= self.y + self.HEIGHT:
            return True
        else:
            return False
            
            
    def deemphasize(self):
        self.appearance.setWidth(0)

                
    def emphasize(self):
        self.appearance.setWidth(4)
        self.appearance.setOutline(Color(255, 255, 255))


class Strawberry(Plant):
    ''' A strawberry plant class'''
    
    COST = 10
    PROFIT = 35
    HARVEST_TIME = 8
    VOLATILITY = 0.5
    
    def __init__(self, p, win):
        Plant.__init__(self, p, win)
        self.appearance.setFill(Color("red"))
        self.appearance.setOutline(Color("red"))
        

class Pumpkin(Plant):
    ''' A pumpkin plant class'''
    
    COST = 30
    PROFIT = 68
    HARVEST_TIME = 16
    VOLATILITY = 0.15
    
    def __init__(self, p, win):
        Plant.__init__(self, p, win)
        self.appearance.setFill(Color("orange"))
        self.appearance.setOutline(Color("orange"))


class Eggplant(Plant):
    ''' An eggplant plant class'''
    
    COST = 35
    PROFIT = 87
    HARVEST_TIME = 49
    VOLATILITY = 0.74
    
    def __init__(self, p, win):
        Plant.__init__(self, p, win)
        self.appearance.setFill(Color("purple"))
        self.appearance.setOutline(Color("purple"))
        

class Corn(Plant):
    ''' A corn plant class'''
    
    COST = 125
    PROFIT = 180
    HARVEST_TIME = 25
    VOLATILITY = 0.24
    
    def __init__(self, p, win):
        Plant.__init__(self, p, win)
        self.appearance.setFill(Color("yellow"))
        self.appearance.setOutline(Color("yellow"))
             
      
win = Window("Farm Game", 500, 500)
win.setBackground(Color(50, 200, 50))

bank = 500 # Initial amount of money avaialble in bank
plants = [] # Plants in Faux Farmville

# Text display showing money available in bank
t = Text(Point(50, 25), "$" + str(bank) + ".00")
t.setFill(Color(0, 50, 0))
t.fontSize = 20
t.draw(win)

# Game title
title = Text(Point(win.getWidth()//2, 25), "Faux Farmville")
title.setFill(Color(255, 0 ,0))
title.fontSize = 36
title.draw(win)

# Game cursor object
cursor = Circle(Point(win.getWidth()//2, win.getHeight()//2), 10)
#cursor.setFill(Color(200,200,200))
cursor.setOutline(Color("yellow"))
cursor.setWidth(2)
cursor.draw(win)
speed = 0.05

# Run games for X seconds
for time in timer(180):
    
    ''' Get a gamepad move from the user'''
    gamepad = getGamepadNow()
    dx, dy = gamepad["axis"]    ## Same as dx, dy = getGamepadNow("axis")
    cursor.move(speed*dx, speed*dy)
    cursorPos = cursor.getCenter()
    
    t.text = "$" + str(bank) + ".00"
    
    selected = None
    
    for p in plants:
        p.step()    # tell each plant to take a step
        if p.selected(cursorPos):   # Check if any plant has been seleted
            selected = p

    if selected != None:
        ''' harvest plant if the last butten is pressed'''
        if gamepad["button"][7] == 1:
            bank = bank + selected.harvest()
            plants.remove(selected)
    else:
        ''' Create a new plant ojbect based on the user's selection
            button 0: Strawberry
            button 1: Pumpkin
            button 2: Eggplant
            button 3: Corn'''
            
        if gamepad["button"][0] == 1 and bank >= Strawberry.COST:
            s = Strawberry(cursorPos, win)
            bank = bank - s.COST
            plants.append(s)
        elif gamepad["button"][1] == 1 and bank >= Pumpkin.COST:
            p = Pumpkin(cursorPos, win)
            bank = bank - p.COST
            plants.append(p)
        elif gamepad["button"][2] == 1 and bank >= Eggplant.COST:
            e = Eggplant(cursorPos, win)
            bank = bank - e.COST
            plants.append(e)
        elif gamepad["button"][3] == 1 and bank >= Corn.COST:
            c = Corn(cursorPos, win)
            bank = bank - c.COST
            plants.append(c)
                        
      
        

