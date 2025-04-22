import Control.Monad (forM_, replicateM)
import Data.List (intercalate, sort, unfoldr, words)
import Data.Maybe (listToMaybe)
import Debug.Trace (trace)
import System.IO (hPutStrLn, stderr)



-- F(a,b) = a / gcd(a,b) * b / gcd(a,b)
-- F(a,b) == F(ma, mb)
-- F(a,b) prime => gcd(a,b) == 1
solve :: Int -> Int
solve n = let pairs = [(a, b) | b <- [1 .. n], a <- [1 .. b - 1], gcd a b == 1] in length $ filter isPrime $ map (uncurry (*)) pairs

main :: IO ()
main = do
  -- get size
  t <- readLn :: IO Int
  -- IO friendly parse
  lists <- replicateM t $ fmap (read :: String -> Int) getLine
  print lists

  -- process and print
  let results = map solve lists
  forM_ results print
