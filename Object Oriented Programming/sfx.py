#Yashar Hashemi <yh7900@bard.edu>
#4/9/16
#Assignment 3: Special Effects
#For this assignment, I received help from Elias Posen

from Myro import *
first= makePicture("dog1.jpg")
second = makePicture("dog2.jpg")

def splitScreen(image1, image2):  
    x = getWidth(image1)
    y = getHeight(image1)
    
     
    split = makePicture(2*x, y)
    #multiply x by 2 to set the width to accomodate both images
    for pixel in getPixels(split):
        spx = getX(pixel)
        spy = getY(pixel)
        if spx > x :
            pi2 = getPixel(image2, spx - x, spy)
            setPixel(split, spx, spy, getColor(pi2)) 
        
        else: 
            pi1 = getPixel(image1, spx , spy) 
            setPixel(split, spx, spy, getColor(pi1))
         
    return(split) 
     
def seeingRed(image) :
    
    for pixel in getPixels(image): 
        setGreen(pixel, (getGreen(pixel)-30))
        setBlue(pixel, (getBlue(pixel)-30))
        setRed(pixel, (getRed(pixel)+50)) 
        #set's all the rgb values of each pixel to give each pixel a shade of red
    return(image) 
    
    
    
def extendedExposure(image1, image2): 
    
    copy = copyPicture (image1)
    
    for pixel in getPixels(copy): 
        cx = getX(pixel)
        cy = getY(pixel) 
        onepx= getPixel(image1, cx, cy)
        twopx= getPixel(image2, cx, cy)
        
        if (getRed(onepx)+getGreen(onepx)+getBlue(onepx))/3 > (getRed(twopx)+ getGreen(twopx)+getBlue(twopx))/3:
            setPixel(copy, cx, cy, getColor(onepx))
        
        else: 
            setPixel(copy, cx, cy, getColor(twopx))
        #this code takes the lightest pixels from each image and includes them in the final.  
    
    return(copy)
     
        
        
   