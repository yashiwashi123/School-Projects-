#Yashar Hashemi <yh7900@bard.edu>
#4/14/16
#Lab 7
#for this project I received help form Elias Posen

from Myro import *

image = makePicture("dog.jpg")


def resize(image, factor): 
    oldpic = copyPicture(image)
    x = getWidth(oldpic)
    y = getHeight(oldpic) 
    newx = x*factor
    newy = y*factor
    
    newPic = makePicture(newx, newy)
    for x in range(newx):
        for y in range(newy): 
            setPixel(newPic, x, y, getPixel(oldpic, x/factor, y/factor))
    
    return(newPic)    
      
def mirror(image):
    newPic = copyPicture(image) 
    for y in range (getHeight(image)):
        for x in range (getWidth(image)): 
            setPixel(newPic, x-(2*x), y, getPixel(image, x ,y))
    return (newPic) 
    
def flip(image):
    newPic = copyPicture(image) 
    for y in range (getHeight(image)):
        for x in range (getWidth(image)): 
            setPixel(newPic, x, y- (2*y), getPixel(image, x ,y))
    return (newPic) 
              
def photobooth(listofimages): 
    
    x = getWidth(listofimages[0])
    y = getHeight(listofimages[0])
    
    boothHeight = y *len(listofimages)
    
    booth = makePicture(x, boothHeight)
    counter= 0
    while counter < len(listofimages):
       
        for px in range (getWidth(listofimages[0])):
            for py in range (getHeight(listofimages[0])): 
                setPixel(booth, px, py+(getHeight(listofimages[0])*counter), getPixel(listofimages[counter], px, py))    
                
        counter= counter +1    
        
    return(booth)      
        
lst = [image, mirror(image), flip(image)]
show(photobooth(lst))

def scribblerPhotoBooth(): 
    wait(1)
    beep(1, 880)
    a= takePicture()
    wait(1) 
    beep(1, 880)
    b= takePicture()
    wait(1)
    beep(1, 880)
    c= takePicture() 
    wait(1) 
    beep(1, 880)
    d= takePicture() 
    wait(1)
    beep(1, 880)
    e= takePicture() 
    scribpb= [a, b, c, d, e]
    return(photobooth(scribpd))
        
      
def fairey(image):
     
    
    for pixel in getPixels(image): 
       
        r, g, b= getRGB(pixel)
        sumrgb = r + g + b
        
        if sumrgb <= 181: 
            setColor (pixel, makeColor(0, 51, 76))
        elif sumrgb >= 182 and sumrgb <= 363:
            setColor (pixel, makeColor(217, 26, 33))
        elif sumrgb >= 364 and sumrgb <= 545: 
            setColor (pixel, makeColor(112, 150,158))
        elif sumrgb >= 546 and sumrgb <= 765:
            setColor (pixel, makeColor(252, 227, 116))
            
    return (image)   

          
        
        
     
   