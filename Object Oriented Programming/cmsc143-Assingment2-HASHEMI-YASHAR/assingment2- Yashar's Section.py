from Myro import *

setForwardness('scribbler-forward')
if ask('Hit Enter on all computers at the smae time when you are ready to go!')==(""):
    
    startTime= currentTime()
    time= 17
    while(currentTime()-startTime)< time:
        motors(1, .5)
        
    stop()
    
    motors(1, .5)
    wait(3.7)
    stop()
    wait(2)
    speak('I, I like your Fluke card!')
    wait(3)
    speak('lets dance')
                                         
    motors(1,.5)
    beep(1, 900)
    beep(.4, 970)
    beep(.3, 880)
    beep (3, 780)
    beep(.6, 890)
    beep(.7, 1100)
    beep(2, 700)
    beep(3, 777)
    
    stop()