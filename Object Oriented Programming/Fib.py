def Fibonacci(n):
 if n==1 or n==2:
  return 1
 return Fibonacci(n-1)+Fibonacci(n-2)
print Fibonacci(11) 