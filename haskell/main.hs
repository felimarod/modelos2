
fac ::(Integral a) => a -> a
fac 0 = 1
fac n = n * fac (n - 1)

primerosPrimos :: Integer -> [Integer]
primerosPrimos x = [ i | i<-[1.. x], esPrimo i ]

esPrimo :: Integer -> Bool
esPrimo x = [i | i <-[1 .. x], mod x i == 0] == [1,x]

puedeArmarTriangulo :: [Integer] -> Bool
puedeArmarTriangulo [x, y, z] = x > y + z || y > x + z || x > y + z

main :: IO ()
main = do
print(primerosPrimos 100)
