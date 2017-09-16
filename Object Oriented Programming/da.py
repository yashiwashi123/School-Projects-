def main():
    population = float(input("Enter current world population: "))
    growthRate = float(input("Enter the growth rate: "))/100.0 
    growthInOneYear = population * growthRate
    growthInADay = growthInOneYear / 365
    print ("World population on January 1, 2008 is", population)
    print ("By Jan. 1, 2009, it wil grow by", growthInOneYear)
    print ("An average daily increase of", growthInADay)
main()

population = 6650000000
growthRate = 1.14/100.0
for year in range(10): 
    population = population * (1 + growthRate)
    print(population)