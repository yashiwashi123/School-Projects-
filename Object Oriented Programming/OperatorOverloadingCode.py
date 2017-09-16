def gcd(a, b):
    ''' Returns the greatest common divisor between a & b'''
    if b == 0:
        return a
    else:
        return gcd(b, a%b)
        
class Fraction(object):
    ''' A new data-type called Fraction '''
    
    def __init__(self, num, denom):
        self.num = num
        self.denom = denom
        self.reduce()
        
    def __str__(self):
        if self.denom == 1:
            return str(self.num)
        else:
            return str(self.num) + "/" + str(self.denom)

    def __repr__(self):
        return str(self)
            
    def __float__(self):
        return self.num / self.denom
        
    def __add__(self, other):
        if not isinstance(other, Fraction):
            other = Fraction(other, 1)
    
        new_num = self.num * other.denom + self.denom * other.num
        new_denom = self.denom * other.denom
        return Fraction(new_num, new_denom)
        
    def __radd__(self, other):
        #return self.__add__(other) 
        return self + other             
                                                                  
    def reduce(self):
        ''' Redue the fraction to the smallest proportion'''
        GCD = gcd(self.num, self.denom)
        self.num = self.num // GCD
        self.denom = self.denom // GCD 
        
## Let's do the __mul__ method & __cmp__
        

frac = Fraction(75, 120)
frac1 = Fraction(23, 100)
print(frac)
print(frac1)
#print(float(frac))
#print(float(frac1))

#print(frac + frac1)
#print(frac + 2)
print(2 + frac)
#print
