from Myro import * 
from Graphics import * 

init('sim')
win= Window("littlerobot", 500, 500)

p1 = Point(100, 125)
p2 = Point(250, 125)
p3 = Point(400, 125)

pname= Point(250, 50)


c1 = Circle(p1, 25)
c2 = Circle(p2, 25)
c3 = Circle(p3, 25)

c1.setFill(Color('red'))
c2.setFill(Color("blue"))
c3.setFill(Color('yellow'))

c1.draw(win)
c2.draw(win)
c3.draw(win) 
'''

'''

name= Text(pname, getName())
name.fill = Color('purple')
name.draw(win)
keepGoing=True

while keepGoing:
    p = takePicture() 
    savePicture(p, "interfacepicture.jpg")
    picture = Picture("interfacepicture.jpg")
    picture.draw(win)  
    picture.setX(250)
    picture.setY(300) 

    if getKeyPressed('Up'): 
        motors(1, 1)
    
    if getKeyPressed('Down'):
        motors(-1,-1)
        
    if getKeyPressed('Left'):
        motors(-1, 1)   
    
    if getKeyPressed('Right'):
        motors(1,-1)
    
    else:
        stop()         
        
    if getMouseNow()>(75,150) and getMouseNow()<(125, 100):
        battery=Text(p1, str(getBattery())) 
        battery.fill = Color('green')
        battery.draw(win)
    else:
        battery = Text(p1, '')
        battery.draw(win)    
    
    if getMouseNow()> (225, 150) and getMouseNow()<(275, 100):
        light=Text(p2, str(getLight('center')))
        light.fill = Color('orange')
        light.draw(win)
    else:
        light = Text(p2, '')
        light.draw(win)
   
    if getMouseNow()> (375, 150) and getMouseNow()<(425, 100):
        IR=Text(p3, str(getIR()))
        IR.fill = Color('purple')
        IR.draw(win)
    else: 
        IR= Text(p3, '')
        IR.draw(win)
        
        
            