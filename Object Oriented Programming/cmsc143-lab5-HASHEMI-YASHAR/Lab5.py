from Myro import * 
'''
com= ask('what come port are you using?')

init(com)
'''
init('sim')

def createParagraph(text):
    r= '<p>%s</p>' % (text) 
    return(r)
    
def createLink(link, linkname): 
    l= "<a href=%s>%s</a>" % (link, linkname)
    return(l)

def createPicture(): 
   p=takePicture()
   show(p)
   savePicture(p, "robotpicture.jpg")
   img='<img src = robotpicture.jpg>'
   return(img)

def createHeader(text):
    r= '<h1>%s</h1>' % (text)
    return(r)
def createTableNames(text1, text2, text3):
    t= '<table><tr> <td> %s </td> <td> %s </td> <td> %s </td> </tr></table>' % (text1, text2, text3)
    return(t)
    
def createTableNumbers(n1, n2, n3): 
    t2= '<table><tr> <td> %g </td> <td> %g </td> <td> %g </td> </tr></table>' % (n1, n2, n3)

f = open ("Lab5.html", "w")


    
head = '''

<!DOCTYPE html> 
<html>
    <head>
        <title>littlerobot CMSC 143 Lab 5</title>
        <style>
        body {background-color: #d0e4fe;}

h1 {color: orange; text-align: center;}

p {font-family: "Times New Roman";font-size: 20px; color: red; text-align:left}

a:link, a:visited 
    {background-color: #f44336;
    color: white;
    padding: 14px 25px;
    right:0;
    bottom: 0;
    position: absolute;
    text-decoration: none;
    display: inline-block;}

a:hover, a:active
    {background-color: red;}

</style>
</head>
<body>
 
'''    

close = '</body></html>'



f.write(head + createHeader('littlerobot webpage') +  '<p>Hi, my name is %s and my battery is %g</p>' % (getName(), getBattery()) + createPicture() + createLink("http://www.betterbots.com/", "Check out these robots!") + '<p></p>' +  createTableNames('left', 'right', 'center')  + '<p></p>' + '<table><tr> <td> %g </td> <td> %g </td> <td> %g </td> </tr> </table>' % (getLight('left'), getLight('center'), getLight('right')) + '<p>These are some things that I like:</p>' + '<ul><li>coffee</li><li>milk</li><li>tea</li></ul>' + close)



f.close ()


 





