import Control.Monad (forM_, replicateM)
import Data.Bits (testBit, xor)
import Data.Foldable (maximumBy)
import Data.List (intercalate, sort, unfoldr, words)
import Data.Maybe (listToMaybe)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)

b2i False = 0
b2i True = 1

checkK :: Int -> [Int] -> Int -> Int
checkK n counts ak = sum [if testBit ak i then (n - counts !! i) * 2 ^ i else counts !! i * 2 ^ i | i <- [0 .. 30]]

-- want to create as many 1s in the MSBs as possible => XOR with the largest number (as the smaller numbers are 0 in their MSB!)
-- problem: if multiple numbers have the same MSB, the maximum might not be the best!
solve :: [Int] -> Int
solve xs = let counts = [sum $ map (\x -> b2i (testBit x i)) xs | i <- [0 .. 30]] in maximum $ map (checkK (length xs) counts) xs

main :: IO ()
main = do
  -- get size
  t <- readLn :: IO Int
  -- IO friendly parse
  lists <- replicateM t $ do
    _ <- getLine -- toss the “length” line
    fmap (map (read :: String -> Int) . words) getLine -- read & parse the list

  -- process and print
  let results = map solve lists
  forM_ results print
