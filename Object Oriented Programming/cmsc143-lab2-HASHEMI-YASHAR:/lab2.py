from Myro import *
from math import *

def pianoToScrib(k):
    return 440*2**((k-49)/12)

def playPiano(t, k):
    beep(t, pianoToScrib(k))   
    
def testPiano():
    beep(.5, pianoToScrib(52))
    playPiano(.5, 54)
    playPiano(.5, 56)
    playPiano(.5, 57)
    playPiano(.5, 59)
    playPiano(.5, 61)
    playPiano(.5, 63)
    playPiano(.5, 64) 
    
def power(f):
    return (f)*1.5       
    
def playPower(t, f):
    beep(t, f, power(f))
        
def testGuitar():
    f = pianoToScrib(57)
    g = pianoToScrib(59)
    playPower(.15, f)
    for i in range(5):
        playPower(.15, g)
        playPower(.15, g)
        playPower(.15, f)
        playPower(.15, g)
        wait(.5)
        playPower(.5, f)
         
  

def frequencyToPitch(f): 
    return 69+12*log((f/440),2)
    
def pitchToFreq(p):
    return 440*2**((p-69)/12)
    
def playMajorScale(p):
    beep(.5, pitchToFreq(p))
    beep(.5, pitchToFreq(p+2))
    beep(.5, pitchToFreq(p+4))
    beep(.5, pitchToFreq(p+5))
    beep(.5, pitchToFreq(p+7))
    beep(.5, pitchToFreq(p+9))
    beep(.5, pitchToFreq(p+11))
    beep(.5, pitchToFreq(p+12))      
    
def pitchClass(f):
    p = frequencyToPitch(f)
    while p>11:
        p = p-12
    return p