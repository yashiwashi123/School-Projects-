from Myro import *



def stopWheels():
    motors(0,0)
    
def goForward():
    motors(1,1)

def goBackward():
    motors(-1,-1)    
            
def spinLeft():
    motors(-1,1)

def spinRight():
    motors(1,-1)
    
def test():
    goForward()
    wait(1)
    spinLeft()
    wait(.1)
    stopWheels()    

def goBackward(p):
    motors(-p,-p)

def goBackwardAndStop(p, secs):    
    motors(-p,-p)
    wait(secs)
    stopWheels()
    
def goForward(p):
    motors(p,p)
    
def goForwardAndStop(p, secs):
    motors(p,p)
    wait(secs)
    stopWheels()     
    
def spinLeft(p):
    motors(-p,p)

def spinLeftAndStop(p, secs):
    motors(-p,p)
    wait(secs)
    stopWheels()

def spinRight(p):
    motors(p,-p)
    
def spinRightAndStop(p, secs):
    motors(p,-p)
    wait(secs)
    stopWheels()
    
def test2():
    goBackwardAndStop(1, .5)
    goForwardAndStop(1, 1.5)
    spinLeftAndStop(.9, .5)
    goForward(.5)
    goBackward(1)
    spinRight(.9)
    spinLeft(.9)
    spinRightAndStop(.9, .5)     
    
def square():
    goForwardAndStop(1, 1)
    spinLeftAndStop(1, .65)
    goForwardAndStop(1, 1)
    spinLeftAndStop(1, .65)
    goForwardAndStop(1, 1)
    spinLeftAndStop(1, .65)
    goForwardAndStop(1, 1)
 
   
                  