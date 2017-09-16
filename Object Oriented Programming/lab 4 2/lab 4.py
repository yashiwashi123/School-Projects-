#Yashar Hashemi <yh7900@bard.edu> 
#March 3 2016
#cmsc 143
#Lab 4
#For this project, I received assistance from Paul Duhe, Elias Posen, and Khondanker Salehin. 
from Myro import *
from math import *

setForwardness('scribbler-forward')

def normalize(v):
   return 1.0 - v/5000.0

def lightSeeker(time):
       
    startTime = currentTime()
        
    while(currentTime()-startTime) < time: 
        L = getLight("left")
        R = getLight("right")
        C = getLight("center")
		
		#we included the variables in the loop so the computer keeps applying them. 
        #without them the robot will move continuously in a straight line
        
        if L < C and L < R:
            normalize(L)
            motors(-L, L)
              
        elif C < L and C < R:
            normalize(C)
            motors(C, C)
            
        elif R < C and R < L:
            normalize(R)
            motors(R, -R)
          
      
    stop()    
            

        
            # lightSeeker(time - 1)

def avoid(time): 
   
    startTime= currentTime()
    
    while (currentTime()-startTime) < time: 
      
       L, R = getIR()
       L = 1-L
       R = 1-R
       
       if L and R:
        motors(-1,-1)
        
       elif L:
        motors(-1,0)
        #the robot will turn right if it detects an obstacle on the left and visa versa
        
       elif R: 
        motors(0,-1)
        
       else:
        motors(.6, .6) 
        # while the robot does not detect obstacles, it will continue to move straight until it encounters one
    
    stop()
    

def securityGuard(time):

	light = getLight() 

	startTime = currentTime()

	while(currentTime()-startTime) < time: 
   
    	light = getLight('center')
    	p = takePicture()
    
    	if light < 5500:
        	p  #should run takePicture
        	show(p)
        	beep(5, 600)
        
        else:
        	securityGuard(time)
    
def digitalCamera(time): 
    
    startTime= currentTime() 
    
    while (currentTime()-startTime) < time: 
        
        if getLight("left") > 6300:
            #since the value of complete darkness is 6400, we gave it a 100 point threshold to make sure the robot takes a picture when you place your finger over the sensor
            
            p= takePicture()
            show(p)
            
        elif getLight("right") > 6300:
            p= takePicture('gray')
            show(p)
            
        else: 
            print("put your finger on either the left or right sensor")