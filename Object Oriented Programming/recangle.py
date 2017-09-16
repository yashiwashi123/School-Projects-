from Myro import *
from Graphics import *

p= makePicture (100, 100, makeColor(255, 255, 255))


for i in range(getWidth(p)): 
    pixel = getPixel (p, i, 25)
    setBlue (pixel, 255)
    setGreen (pixel, 0)
    setRed (pixel, 0)

for i in range(getWidth(p)): 
    pixel = getPixel (p, i, 75)
    setBlue (pixel, 255)
    setGreen (pixel, 0)
    setRed(pixel, 0)
    
for i in range (getHeight(p)): 
    pixel= getPixel (p, 25, i)
    setBlue (pixel, 255)
    setGreen (pixel, 0)
    setRed (pixel, 0)
    
for i in range (getHeight(p)): 
    pixel = getPixel (p, 75, i)
    setBlue (pixel, 255)
    setGreen(pixel, 0)
    setRed (pixel, 0)
    
show(p)