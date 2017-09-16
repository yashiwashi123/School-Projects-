from Myro import *


def tintRed(image): 
    for pixel in getPixels(image): 
        setGreen(pixel, (getGreen(pixel)-30))
        setBlue(pixel, (getBlue(pixel)-30))
        setRed(pixel, (getRed(pixel)+50))
    return(image)
    
def tintBlue(image):
    for pixel in getPixels(image): 
        setGreen(pixel, (getGreen(pixel)-30))
        setBlue(pixel, (getBlue(pixel)+50))
        setRed(pixel, (getRed(pixel)-30))
    return(image)
    
def tintGreen(image):
    for pixel in getPixels(image):
        setGreen(pixel, (getGreen(pixel)+50))
        setBlue(pixel, (getBlue(pixel)-30))
        setRed(pixel, (getRed(pixel)-30))   
        
def tintPurple(image): 
    for pixel in getPixels(image): 
        setGreen(pixel, (getGreen(pixel)-30)) 
        setBlue(pixel, (getBlue(pixel) + 50))
        setRed(pixel, (getRed(pixel) +50))
       
def takeMovie(shots):
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots):
        print ("shot #", idx)
        p = takePicture()
        film.append(p)
        show(p)
        beep(.5, 800)
    return(film)
         
def takeRedMovie(shots): 
    film = []
    wait(10)
    beep(1,800)
    for idx in range(shots):
        print("shot #", idx)
        p = takePicture()
        tintRed(p)
        film.append(p)
        show(p)
        beep(.5, 800)
    return(film)    

def takeBlueMovie(shots): 
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots): 
        print("shot #", idx)
        p = takePicture()
        tintBlue(p)
        film.append(p)
        show(p)
        beep(.5, 800)
    return(film)    
                                      
def takeGreenMovie(shots):
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots): 
        print("shot #", idx)
        p = takePicture()
        tintGreen(p)                                                             
        film.append(p)
        show(p)
        beep(.5, 800)
    return(film) 

def takePurpleMovie(shots):
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots): 
        print("shot #", idx)
        p = takePicture()
        tintPurple(p)
        film.append(p)
        show(p)
        beep(.5, 800)
    return(film)
    
def panoramaShot(shots): 
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots): 
        print("shot #", idx)
        p = takePicture()
        film.append(p)
        turnRight(.5, .2) 
        show(p)
        beep(.5, 800)
    return(film)
    
def redPanoramaShot (shots): 
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots):
        p = takePicture() 
        tintRed(p)
        film.append(p)
        turnRight(.5, .2)
        show(p)
        beep(.5, 800)
    return(film)
        
def greenPanoramaShot(shots): 
    film =[]
    wait(10)
    beep(1, 800)
    for idx in range(shots): 
        p = takePicture()
        tintGreen(p)
        film.append(p)
        turnRight(.5,.2)
        show(p)
        beep(.5, 800)
    return(film)     
           
def bluePanoramaShot(shots):
    film = []
    wait(10)
    beep(1, 800)
    for idx in range(shots):
        p = takePicture() 
        tintBlue(p)
        film. append(p)
        turnRight(.5, .2)
        show(p)
        beep(.5, 800)
    return(film)
        
def zoomShot(shots):
    film=[]
    for idx in range(shots):
        print("shot #", idx)
        p = takePicture()
        film.append(p)
        goForward(.5, .2)
    return(film)    

def saveMovie(movie, base): 
    for f in range(len(movie)):
        frame = movie[f]
        name = base + "-" + str(f) +".jpg"
        savePicture(frame, name)

movieList1= [makePicture('Intro-0.jpg'), makePicture('Intro-1.jpg'), makePicture('Intro-2.jpg'), makePicture('Intro-2-0.jpg'), makePicture('Intro-2-1.jpg'), makePicture('Intro-3-0.jpg'), makePicture('Intro-3-1.jpg'), makePicture('Intro-3-2.jpg'), makePicture('titlescene-0.jpg'), makePicture('titlescene-1.jpg'), makePicture('titlescene-2.jpg'), makePicture('titlescene-3.jpg'), makePicture('titlescene-4.jpg'), makePicture('titlescene-5.jpg'), makePicture('titlescene-6.jpg'), makePicture('titlescene-7.jpg'), makePicture('titlescene-8.jpg'), makePicture('titlescene-9.jpg'), makePicture('titlescene-10.jpg'), makePicture('titlescene-11.jpg'), makePicture('titlescene-12.jpg'), makePicture('titlescene-13.jpg'), makePicture('titlescene-14.jpg'), makePicture('zoomin-0.jpg'), makePicture('zoomin-1.jpg'), makePicture('zoomin-2.jpg'), makePicture('zoomin-3.jpg'), makePicture('zoomin-4.jpg'), makePicture('zoomin-5.jpg'), makePicture('zoomin-6.jpg'), makePicture('zoomin-7.jpg'), makePicture('zoomin-8.jpg'), makePicture('zoomin-9.jpg'), makePicture('zoomin-10.jpg'), makePicture('zoomin-11.jpg'), makePicture('zoomin-12.jpg'), makePicture('zoomin-13.jpg'), makePicture('zoomin-14.jpg'), makePicture('zoomin-15.jpg'), makePicture('zoomin-16.jpg'), makePicture('zoomin-17.jpg'), makePicture('zoomin-18.jpg'), makePicture('zoomin-19.jpg'), makePicture('putphoneindrawer-0.jpg'), makePicture('putphoneindrawer-1.jpg') , makePicture('putphoneindrawer-2.jpg'), makePicture('putphoneindrawer-3.jpg'), makePicture('putphoneindrawer-4.jpg'), makePicture('putphoneindrawer-5.jpg'), makePicture('putphoneindrawer-6.jpg'), makePicture('putphoneindrawer-7.jpg'), makePicture('putphoneindrawer-8.jpg'), makePicture('putphoneindrawer-9.jpg'), makePicture('putphoneindrawer-10.jpg'), makePicture('putphoneindrawer-11.jpg'), makePicture('putphoneindrawer-12.jpg'), makePicture('putphoneindrawer-13.jpg'), makePicture('putphoneindrawer-14.jpg'), makePicture('putphoneindrawer-15.jpg'), makePicture('putphoneindrawer-16.jpg'), makePicture('putphoneindrawer-17.jpg'), makePicture('putphoneindrawer-18.jpg'), makePicture('putphoneindrawer-19.jpg')]

drawerone= [makePicture('drawer1-0.jpg'), makePicture('drawer1-1.jpg'), makePicture('drawer1-2.jpg'), makePicture('drawer1-3.jpg'), makePicture('drawer1-4.jpg'), makePicture('drawer1-5.jpg'), makePicture('drawer1-6.jpg'), makePicture('drawer1-7.jpg'), makePicture('drawer1-2-0.jpg'), makePicture('drawer1-2-1.jpg'), makePicture('drawer1-2-2.jpg'), makePicture('drawer1-2-3.jpg'), makePicture('drawer1-2-4.jpg'), makePicture('drawer1-2-5.jpg'), makePicture('drawer1-2-6.jpg'), makePicture('drawer1-2-7.jpg'), makePicture('drawer1-2-8.jpg'), makePicture('drawer1-2-9.jpg')]

drawertwo= [makePicture('drawer2-0.jpg'), makePicture('drawer2-1.jpg'), makePicture('drawer2-2.jpg'), makePicture('drawer2-3.jpg'), makePicture('drawer2-4.jpg'), makePicture('drawer2-5.jpg'), makePicture('drawer2-6.jpg'), makePicture('drawer2-7.jpg'), makePicture('drawer2-2-0.jpg'), makePicture('drawer2-2-1.jpg'), makePicture('drawer2-2-2.jpg'), makePicture('drawer2-2-3.jpg'), makePicture('drawer2-2-4.jpg'), makePicture('drawer2-2-5.jpg'), makePicture('drawer2-2-6.jpg'), makePicture('drawer2-2-7.jpg'), makePicture('drawer2-2-8.jpg')]

drawerthree= [makePicture('drawer3-1-0.jpg'), makePicture('drawer3-1-1.jpg'), makePicture('drawer3-1-2.jpg'), makePicture('drawer3-1-3.jpg'), makePicture('drawer3-1-4.jpg'), makePicture('drawer3-1-5.jpg'), makePicture('drawer3-1-6.jpg'), makePicture('drawer3-1-7.jpg'), makePicture('drawer3-2-0.jpg'), makePicture('drawer3-2-1.jpg'), makePicture('drawer3-2-2.jpg'), makePicture('drawer3-2-3.jpg'), makePicture( 'drawer3-2-4.jpg'), makePicture('drawer3-2-5.jpg'), makePicture('drawer3-2-6.jpg'), makePicture('drawer3-2-7.jpg'), makePicture('drawer3-2-8.jpg'), makePicture('drawer3-2-9.jpg')]

fullMovie= [movieList1 + drawerone + drawertwo + drawerthree] 

savePicture(fullMovie, 'assignmentfourmove.gif')
        
        
        