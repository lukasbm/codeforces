import Control.Monad (forM_, replicateM)
import Data.Bits (testBit, xor)
import Data.Foldable (maximumBy)
import Data.List (intercalate, sort, unfoldr, words)
import Data.Maybe (listToMaybe)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)

-- it is essentially k-graph node coloring.
-- each cell has up up to 4 edges (the neighbors)
-- nvm its not.

-- endless cycle shifted stream
cycleShift :: Int -> [Int] -> [Int]
cycleShift _ [a] = [a]
cycleShift u xs = let n = length xs - u in drop n xs ++ take n xs

shiftStream :: Int -> [Int] -> [Int]
shiftStream u xs = concat (iterate (cycleShift u) xs)

-- FIXME: if anything is broken, it should be fixable by tweaking the shiftStream offset!
-- solution: just start writing out the symbols in order, e.g. 1,2,3 once the max is reached, cyclic shift it and continue 1,2,3, 3,1,2, 2,3,1
solve :: Int -> Int -> Int -> [Int]
solve n m k = take (n * m) $ shiftStream (k `mod` m) [1 .. k]

printGridThis :: Int -> [Int] -> IO ()
printGridThis m [] = return ()
printGridThis m gs = do
  let (start, rest) = splitAt m gs
  putStrLn $ unwords $ map show start
  printGridThis m rest

main :: IO ()
main = do
  inp <- lines <$> getContents
  let t = read $ head inp :: Int
  let cases = map (map read . words) (tail inp) :: [[Int]]

  -- process and print
  mapM_ (\[n, m, k] -> printGridThis m (solve n m k)) cases

b2i False = 0
b2i True = 1

printGrid :: (Show a) => [[a]] -> IO ()
printGrid xss = print "hi"
