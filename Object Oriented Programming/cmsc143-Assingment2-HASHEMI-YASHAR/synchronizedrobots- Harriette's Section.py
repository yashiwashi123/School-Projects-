from Myro import *

setForwardness('scribbler-forward')


question = input('Hit OK on all computers at the same time when you are ready to go!')

if question == (''):

    startTime = currentTime()
    time = 17
    while (currentTime() - startTime) < time:
        motors(1, 0.5)
          
    stop()
   
    motors(-1, -0.5)
    wait(4.1)
    stop()


    speak("Hello")
    wait(3)
    speak("I like yours too")
    
    motors(-1, -0.5)

    beep(1, 800) #11 seconds
    beep(.3, 1005)
    beep(.6, 900)
    beep(.2, 1005)
    beep(.4, 970)
    beep(2, 850)
    beep(.5, 945)
    beep(2, 800)
    beep(.7, 945)
    beep(2, 780)
    beep(.3, 800)
    beep(3, 970)