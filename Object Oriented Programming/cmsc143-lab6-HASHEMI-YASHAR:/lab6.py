#Yashar Hashemi <yh7900@bard.edu>
#7 April, 2016
#Lab 6: Motion Detection
#I received help on this project form Elias Posen
 
from Myro import *
background= makePicture('background.jpg')

image= makePicture('foreground.jpg')

def frameDifference (background, image):

    copy=copyPicture(background)

    for p in getPixels(copy):
        x = getX(p)
        y = getY(p)

        bpx = getPixel (background, x, y)
        ipx = getPixel (image, x, y)

        difference = abs(getGray(bpx) - getGray(ipx))

        setGray(p, difference)

    return(copy)
#savePicture(frameDifference (background, image), "framedifference.jpg")


def detectChanges (background, image, threshold):
    copy = copyPicture(image)
    count = 0
    for p in getPixels(copy):
        x = getX (p)
        y= getY(p)

        bpx = getPixel(background, x, y)
        ipx = getPixel (image, x ,y)

        difference = abs(getGray(bpx)- getGray(ipx))
    
        if difference > threshold:
            setGray(p, getGray(ipx))
            count = count + 1
            
        else:
            setGray(p, 0)
         
    return (copy, count)
    
pic, cnt = detectChanges(background, image, 50)
     
savePicture(pic, "detectChanges50.jpg")
print(cnt) 

def securityGuard(time): 
    startTime= currentTime() 
    background= takePicture("gray") 
    while (currentTime()-startTime) < time: 
        image = takePicture("gray") 
        newPic, count = detectChanges (background, image, 75)
        
        if count > 1000: 
            beep(2, 800) 
            savePicture(image, "intruder.jpg") 
            
        
    